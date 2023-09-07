package com.volunteering.clothingapp.presentation.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.volunteering.clothingapp.R
import com.volunteering.clothingapp.databinding.LayoutFragmentHostBinding


class HostFragment : Fragment() {

    private val LOG_TAG: String = "LT_HostFragment"

    private var _binding: LayoutFragmentHostBinding? = null
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
        _binding = LayoutFragmentHostBinding.inflate(inflater,container,false)
        val view = binding.root
        setChildFragments(savedInstanceState)
        return view
    }

    private fun setChildFragments(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            childFragmentManager.commit {
                add<GetStartedFragment>(R.id.fragment_container_view, tag = GetStartedFragment.TAG)
                setPrimaryNavigationFragment(childFragmentManager.findFragmentByTag(GetStartedFragment.TAG))
                setReorderingAllowed(true)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(LOG_TAG, "onDestroyView()")
        _binding = null
    }

    companion object{
        const val TAG = "HostFragment"
    }
}