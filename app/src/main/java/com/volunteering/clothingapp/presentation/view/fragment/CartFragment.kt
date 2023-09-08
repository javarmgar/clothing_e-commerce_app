package com.volunteering.clothingapp.presentation.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.volunteering.clothingapp.databinding.LayoutFragmentCartBinding

class CartFragment : Fragment() {

    private val LOG_TAG: String = "LT_CartFragment"

    private var _binding: LayoutFragmentCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayoutFragmentCartBinding.inflate(inflater, container, false)
        val view = binding.root
        setChildFragments(savedInstanceState)
        return view
    }

    private fun setChildFragments(savedInstanceState: Bundle?) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(LOG_TAG, "onDestroyView()")
        _binding = null
    }

    companion object {
        const val TAG = "CartFragment"
    }

}