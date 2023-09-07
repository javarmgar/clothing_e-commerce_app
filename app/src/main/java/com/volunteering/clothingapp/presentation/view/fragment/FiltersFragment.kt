package com.volunteering.clothingapp.presentation.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.widget.ConstraintLayout
import com.volunteering.clothingapp.R
import com.volunteering.clothingapp.databinding.LayoutFragmentFiltersBinding
import com.volunteering.clothingapp.presentation.base.ChipCustomView


class FiltersFragment : Fragment() {

    private val LOG_TAG: String = "LT_FiltersFragment"

    private var _binding: LayoutFragmentFiltersBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(LOG_TAG, "onCreateView()")
        _binding = LayoutFragmentFiltersBinding.inflate(inflater,container,false)
        val view = binding.root
        setPriceRangeSection()
        setCategoriesSection()
        setSizeSection()
        setConditionSection()
        setGenderSection()
        setDistanceSection()
        setDeliverySection()
        setSortBySection()
        return view
    }

    private fun setPriceRangeSection() {

    }

    private fun setCategoriesSection() {
        setChipGroupCategories()
    }

    private fun setChipGroupCategories() {
        setChipGroup(
            R.array.array_categories,
            binding.layoutFilterCategories.layoutChipItems.flowChipOptions,
            binding.layoutFilterCategories.layoutChipItems.root
        )
    }

    private fun setSizeSection() {

        val items = resources.getStringArray(R.array.array_filter_size_bottom).toList()
        val adapter = ArrayAdapter(requireContext(), R.layout.item_spinner_list, items)
        (binding.layoutFilterSize.spinnerTextView).setAdapter(adapter)

    }

    private fun setConditionSection() {
        setChipGroupCondition()
    }

    private fun setGenderSection() {

    }

    private fun setDistanceSection() {
    }

    private fun setDeliverySection() {
    }

    private fun setSortBySection() {
        setChipGroupSortBy()
    }

    private fun setChipGroupSortBy(){
        setChipGroup(
            R.array.array_sort_by,
            binding.layoutFilterSortBy.layoutChipItems.flowChipOptions,
            binding.layoutFilterSortBy.layoutChipItems.root
        )
    }

    private fun setChipGroupCondition() {
        setChipGroup(
            R.array.array_condition,
            binding.layoutFilterCondition.layoutChipItems.flowChipOptions,
            binding.layoutFilterCondition.layoutChipItems.root
        )
    }

    private fun setChipGroup(arrayResId: Int, flowChipOptions: Flow, parent: ConstraintLayout,) {
        //0 create list that helps with the chain view's ids required for <androidx.constraintlayout.helper.widget.Flow attr
        val chipArrayIds = mutableListOf<Int>()
        resources.getStringArray(arrayResId).forEach {
            //1.- inflate view
            val inflater = LayoutInflater.from(requireContext())
            val chipCustomView = inflater.inflate(R.layout.layout_item_chip, parent, false) as ChipCustomView
            //2.- set view attributes
            chipCustomView.text = it
            chipCustomView.id = View.generateViewId() // Generate a unique ID for the view
            //3.- set constraints - omitted cause xml layout_item_chip contains constraint attrs
            //4.- add the view to the view group
            parent.addView(chipCustomView)
            //5.- add the
            chipArrayIds.add(chipCustomView.id )

        }
        //6.- Add  chain id's  array to androidx.constraintlayout.helper.widget.Flow attr
        flowChipOptions.referencedIds = chipArrayIds.toIntArray()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(LOG_TAG, "onViewCreated()")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop()")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy()")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(LOG_TAG, "onDestroyView()")
        _binding = null
    }
    companion object {
        const val TAG = "FiltersFragment"
    }
}