package com.volunteering.clothingapp.presentation.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
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
        // Inflate the layout for this fragment
        _binding = LayoutFragmentFiltersBinding.inflate(inflater,container,false)
        val view = binding.root
        setSizeSection()
        setCondition()
        return view
    }

    private fun setCondition() {
        setChipGroupCondition()
    }

    private fun setChipGroupCondition() {
        setChipGroup(R.array.array_condition)
    }

    private fun setChipGroup(arrayResId: Int) {
        //0 create list that helps with the chain view's ids required for <androidx.constraintlayout.helper.widget.Flow attr
        val chipArrayIds = mutableListOf<Int>()
        val parent = binding.layoutFilterCondition.layoutChipItems.root
        val chipOptionsView = binding.layoutFilterCondition.layoutChipItems.flowChipOptions
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
        chipOptionsView.referencedIds = chipArrayIds.toIntArray()

    }

    private fun setSizeSection() {

        val items = resources.getStringArray(R.array.array_filter_size_bottom).toList()
        val adapter = ArrayAdapter(requireContext(), R.layout.item_spinner_list, items)
        (binding.layoutFilterSize.spinnerTextView).setAdapter(adapter)

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
        @JvmStatic
        fun newInstance() = FiltersFragment()
    }
}