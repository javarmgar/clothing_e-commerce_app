package com.volunteering.clothingapp.presentation.view.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.volunteering.clothingapp.R
import com.volunteering.clothingapp.databinding.ActivityMainBinding
import com.volunteering.clothingapp.presentation.view.fragment.GetStartedFragment
import com.volunteering.clothingapp.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val LOG_TAG: String = "LT_MainActivity"

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "onCreate() ")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setHostFragment(savedInstanceState)
    }

    private fun setHostFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add<GetStartedFragment>(R.id.fragment_container_view, tag = GetStartedFragment.TAG)
                setPrimaryNavigationFragment(supportFragmentManager.findFragmentByTag(GetStartedFragment.TAG))
                setReorderingAllowed(true)
            }
        }
    }


}
