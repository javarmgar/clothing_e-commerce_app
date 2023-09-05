package com.volunteering.clothingapp.presentation.view.activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.clothingapp.core.data.remote.model.HiringResponseModel
import com.clothingapp.core.data.remote.model.params.HiringParamsModel
import com.volunteering.clothingapp.R
import com.volunteering.clothingapp.databinding.ActivityMainBinding
import com.volunteering.clothingapp.framework.library.utils.Resource
import com.volunteering.clothingapp.framework.library.utils.Status
import com.volunteering.clothingapp.framework.library.utils.setGone
import com.volunteering.clothingapp.framework.library.utils.setVisible
import com.volunteering.clothingapp.presentation.base.ChipCustomView
import com.volunteering.clothingapp.presentation.base.ItemStatusView
import com.volunteering.clothingapp.presentation.view.adapter.HiringAdapter
import com.volunteering.clothingapp.presentation.view.fragment.FiltersFragment
import com.volunteering.clothingapp.presentation.view.fragment.ModalBottomSheetAddress
import com.volunteering.clothingapp.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val LOG_TAG: String = "LT_MainActivity"

    private val bottomSheet =  ModalBottomSheetAddress()
    val filterByName = { item: HiringResponseModel -> item.name != "null" && item.name != "" }

    val filterNone = { _: HiringResponseModel -> true }
    val comparatorByFirst = compareBy<HiringResponseModel> { it.listId }

    val comparatorByFirstSecond = comparatorByFirst.thenBy { it.name }
    private var filter: (HiringResponseModel) -> Boolean = filterNone

    private lateinit var comparator: Comparator<HiringResponseModel>
    private var isFilterByName = MutableLiveData(false)
    private var sortingCriteria = MutableLiveData(0)
    private lateinit var adapter: HiringAdapter
    private lateinit var filterByNameSpinner: Spinner

    private lateinit var sortingFieldSpinner: Spinner
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "onCreate() ")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setChipGroup()
        setCustomStatus()
        setSortingFieldSpinner()
        setFilterByNameSpinner()
        setRecyclerView()
        setModalBottomSheet()
        setFilterFragment(savedInstanceState)

    }

    private fun setFilterFragment(savedInstanceState: Bundle?) {
        binding.btnFilterFragment.setOnClickListener{
            if(savedInstanceState == null){
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<FiltersFragment>(R.id.fragment_container_view)
                }
            }
        }
    }

    private fun setChipGroup() {
        //0 create list that helps with the chain view's ids required for <androidx.constraintlayout.helper.widget.Flow attr
        val chipArrayIds = mutableListOf<Int>()
        resources.getStringArray(R.array.array_categories).forEach {
            //1.- inflate view
            val inflater = LayoutInflater.from(this)
            val chipCustomView = inflater.inflate(R.layout.layout_item_chip, binding.layoutChipItems.root, false) as ChipCustomView
            //2.- set view attributes
            chipCustomView.text = it
            chipCustomView.id = View.generateViewId() // Generate a unique ID for the view
            //3.- set constraints - omitted cause xml layout_item_chip contains constraint attrs
            //4.- add the view to the view group
            binding.layoutChipItems.root.addView(chipCustomView)
            //5.- add the
            chipArrayIds.add(chipCustomView.id )

        }
        //6.- Add  chain id's  array to androidx.constraintlayout.helper.widget.Flow attr
        binding.layoutChipItems.flowChipOptions.referencedIds = chipArrayIds.toIntArray()

    }

    private fun setCustomStatus() {
        binding.itemStatusViewImpl.also {statusView ->
            statusView.setOnClickListener {
                ItemStatusView.apply {
                    statusView.state = when(statusView.state){
                        AVAILABLE -> SOLD
                        SOLD ->  INACTIVE
                        INACTIVE -> AVAILABLE
                        else -> AVAILABLE
                    }
                }
            }
        }
    }

    private fun setModalBottomSheet() {
        binding.btnBottomSheetDialog.setOnClickListener {
            bottomSheet.show(supportFragmentManager, ModalBottomSheetAddress.TAG)

        }
    }

    private fun setSortingFieldSpinner() {
        sortingFieldSpinner = binding.spnSortByField
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.hiring_fields,
            android.R.layout.simple_spinner_item
        )
        sortingFieldSpinner.adapter = adapter
        sortingFieldSpinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val itemSelected: String? = parent?.getItemAtPosition(position) as String?
                Log.d(LOG_TAG, "setSortingFieldSpinner() itemSelected: $itemSelected")
                sortingCriteria.value = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d(LOG_TAG, "setSortingFieldSpinner() onNothingSelected")
            }
        }
    }

    private fun setFilterByNameSpinner() {
        filterByNameSpinner = binding.spnFilterByName
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.filter_name_options,
            android.R.layout.simple_spinner_item
        )
        filterByNameSpinner.adapter = adapter
        filterByNameSpinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val itemSelected: String? = parent?.getItemAtPosition(position) as String?
                Log.d(LOG_TAG, "setFilterByNameSpinner() itemSelected: $itemSelected")
                isFilterByName.value = when (position) {
                    0 -> false
                    else -> true
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d(LOG_TAG, "setFilterByNameSpinner() onNothingSelected")
            }
        }
    }


    private fun setRecyclerView() {
        adapter = HiringAdapter()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.hiringListState.collect { resource ->
                    Log.d(LOG_TAG, "onCreate() viewModel.hiringListState.collect -> $resource")
                    updateRecyclerView(resource)

                }
            }
        }
        viewModel.fetchHiringList(object : HiringParamsModel {})
    }

    private fun updateRecyclerView(resource: Resource<List<HiringResponseModel>>) {
        Log.d(LOG_TAG, "updateRecyclerView() resource.status ${resource.status}")
        when (resource.status) {
            Status.LOADING -> {
                setLoadingState()
            }

            Status.ERROR -> {
                setErrorState(resource.message)
            }

            Status.SUCCESS -> {
                setSuccessState(resource.data)
            }

            else -> {}
        }
    }

    private fun setLoadingState() {
        binding.apply {
            progressBar.setVisible()
            ivMsgError.setGone()
            tvMsgError.setGone()
            rvHirings.root.setGone()
        }
    }

    private fun setErrorState(message: String?) {
        Log.d(LOG_TAG, "setErrorState() resource.message $message")
        binding.apply {
            progressBar.setGone()
            ivMsgError.setVisible()
            tvMsgError.setVisible()
            rvHirings.root.setGone()
        }
    }

    private fun setSuccessState(hiringList: List<HiringResponseModel>?) {
        Log.d(LOG_TAG, "setSuccessState() hiringList $hiringList")
        hiringList?.run {
            binding.rvHirings.recyclerView.adapter = adapter
            setSortingMethods(this)
            setFilterMethods(this)
            adapter.submitList(this)
        }
        binding.apply {
            progressBar.setGone()
            ivMsgError.setGone()
            tvMsgError.setGone()
            rvHirings.root.setVisible()
        }
    }

    private fun setSortingMethods(hiringList: List<HiringResponseModel>) {
        sortingCriteria.observe(this) {
            comparator = when (it) {
                1 -> comparatorByFirst
                else -> comparatorByFirstSecond
            }
            setListAttributes(hiringList)
            Log.d(LOG_TAG, "setSortingMethods() sortingCriteria: $it")
        }
    }

    private fun setFilterMethods(hiringList: List<HiringResponseModel>) {
        isFilterByName.observe(this) { it ->
            filter = if (it) filterByName else filterNone
            setListAttributes(hiringList)
            Log.d(LOG_TAG, "setFilterMethods() isFilterByName: $it")
        }
    }

    private fun setListAttributes(hiringList: List<HiringResponseModel>) {
        val list = hiringList.filter(filter).sortedWith(comparator)
        (binding.rvHirings.recyclerView.adapter as HiringAdapter).submitList(list)
    }
}
