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
import com.volunteering.clothingapp.databinding.LayoutFragmentSignInBinding
import com.volunteering.clothingapp.framework.library.utils.setVisible


class SignInFragment : Fragment() {

    private val LOG_TAG: String = "LT_SignInFragment"

    private  var _binding: LayoutFragmentSignInBinding? = null
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
        _binding = LayoutFragmentSignInBinding.inflate(inflater,container,false)
        val view = binding.root
        setChildFragments(savedInstanceState)
        return view
    }

    private fun setChildFragments(savedInstanceState: Bundle?) {
        setHomeFragment(savedInstanceState)
        setSignUpFragment(savedInstanceState)
    }

    private fun setHomeFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            binding.btnLoginAccept.setOnClickListener {
                binding.fragmentContainerView.setVisible()
                childFragmentManager.commit {
                    add<HomeFragment>(R.id.fragment_container_view, tag = HomeFragment.TAG)
                    setPrimaryNavigationFragment(childFragmentManager.findFragmentByTag(HomeFragment.TAG))
                    setReorderingAllowed(true)
                    addToBackStack(null)
                }
            }
        }
    }

    private fun setSignUpFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            binding.tvSignUpTitle.setOnClickListener {
                binding.fragmentContainerView.setVisible()
                childFragmentManager.commit {
                    add<SignUpFragment>(R.id.fragment_container_view, tag = SignUpFragment.TAG)
                    setPrimaryNavigationFragment(childFragmentManager.findFragmentByTag(SignUpFragment.TAG))
                    setReorderingAllowed(true)
                    addToBackStack(null)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(LOG_TAG, "onDestroyView()")
        _binding = null
    }

    companion object{
        const val TAG = "SignInFragment"
    }
}