package com.volunteering.clothingapp.presentation.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.volunteering.clothingapp.databinding.LayoutFragmentSignUpBinding


class SignUpFragment : Fragment() {

    private val LOG_TAG: String = "LT_SigUpFragment"

    private  var _binding: LayoutFragmentSignUpBinding? = null
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
        _binding = LayoutFragmentSignUpBinding.inflate(inflater,container,false)
        val view = binding.root
        setChildFragments(savedInstanceState)
        return view
    }

    private fun setChildFragments(savedInstanceState: Bundle?) {
        setStatusRegisterFragment(savedInstanceState)
        setSignInFragment(savedInstanceState)
    }

    private fun setStatusRegisterFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            binding.btnLoginAccept.setOnClickListener {
                requireActivity().supportFragmentManager.commit {
                    DialogSuccessStatusFragment().show(childFragmentManager, DialogSuccessStatusFragment.TAG)
                    setReorderingAllowed(true)
                    addToBackStack(null)
                }
            }
        }

    }

    private fun setSignInFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            binding.tvSignInTitle.setOnClickListener {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(LOG_TAG, "onDestroyView()")
        _binding = null
    }

    companion object{
        const val TAG = "SignUpFragment"
    }

}