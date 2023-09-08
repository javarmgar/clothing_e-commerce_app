package com.volunteering.clothingapp.presentation.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.clothingapp.core.data.remote.model.params.Category
import com.clothingapp.core.data.remote.model.params.ClothingCategory
import com.clothingapp.core.data.remote.model.params.ClothingPreviewItem
import com.volunteering.clothingapp.R
import com.volunteering.clothingapp.databinding.LayoutFragmentHomeBinding
import com.volunteering.clothingapp.presentation.view.adapter.CategoryAdapter
import com.volunteering.clothingapp.presentation.view.adapter.ClothesPreviewAdapter
import com.volunteering.clothingapp.presentation.view.fragment.ClothDetailsFragment.Companion.toBundle
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private val LOG_TAG: String = "LT_GetStartedFragment"

    private var _binding: LayoutFragmentHomeBinding? = null
    private val binding get() = _binding!!

    val mockCategories = listOf(
        ClothingCategory(name = Category.TOPS),
        ClothingCategory(name = Category.BOTTOMS),
        ClothingCategory(name = Category.DRESSES_JUMPSUITS),
        ClothingCategory(name = Category.OUTERWEAR),
        ClothingCategory(name = Category.ACTIVEWEAR),
        ClothingCategory(name = Category.UNDERWEAR_LINGERIE),
        ClothingCategory(name = Category.FOOTWEAR),
        ClothingCategory(name = Category.ACCESSORIES),
        ClothingCategory(name = Category.SWIMWEAR),
        ClothingCategory(name = Category.SPECIAL_OCCASIONS_ETHNIC),
        ClothingCategory(name = Category.MATERNITY),
        ClothingCategory(name = Category.KIDS_BABIES),
        ClothingCategory(name = Category.UNISEX)
    )

    val mockClothingPreview = listOf(
        ClothingPreviewItem(
            itemId = "001",
            title = "Vintage Denim Jacket",
            images = listOf("url_denim_jacket.jpg"),
            distance = "2 miles away",
            price = "$50"
        ),
        ClothingPreviewItem(
            itemId = "002",
            title = "Red Summer Dress",
            images = listOf("url_red_dress.jpg"),
            distance = "1.5 miles away",
            price = "$30"
        ),
        ClothingPreviewItem(
            itemId = "003",
            title = "Black Running Shoes",
            images = listOf("url_running_shoes.jpg"),
            distance = "3 miles away",
            price = "$70"
        ),
        ClothingPreviewItem(
            itemId = "004",
            title = "White Polo Shirt",
            images = listOf("url_polo_shirt.jpg"),
            distance = "0.5 miles away",
            price = "$25"
        ),
        ClothingPreviewItem(
            itemId = "005",
            title = "Green Hoodie",
            images = listOf("url_green_hoodie.jpg"),
            distance = "2.5 miles away",
            price = "$40"
        ),
        ClothingPreviewItem(
            itemId = "006",
            title = "Brown Leather Jacket",
            images = listOf("url_leather_jacket.jpg"),
            distance = "3.5 miles away",
            price = "$120"
        ),
        ClothingPreviewItem(
            itemId = "007",
            title = "Blue Skinny Jeans",
            images = listOf("url_skinny_jeans.jpg"),
            distance = "1 mile away",
            price = "$45"
        ),
        ClothingPreviewItem(
            itemId = "008",
            title = "Black Heels",
            images = listOf("url_black_heels.jpg"),
            distance = "4 miles away",
            price = "$60"
        ),
        ClothingPreviewItem(
            itemId = "009",
            title = "Gold Wrist Watch",
            images = listOf("url_gold_watch.jpg"),
            distance = "2.7 miles away",
            price = "$150"
        ),
        ClothingPreviewItem(
            itemId = "010",
            title = "Gray Sweatpants",
            images = listOf("url_sweatpants.jpg"),
            distance = "0.8 miles away",
            price = "$35"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayoutFragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        setChildFragments(savedInstanceState)
        setRecyclerViews()
        return view
    }

    private fun setRecyclerViews() {
        setRecyclerViewCategories()
        setRecyclerViewClothes()
    }

    private fun setRecyclerViewCategories() {
        val adapter = CategoryAdapter()
        binding.layoutCategories.rvClothesCategories.apply {
            layoutManager =  LinearLayoutManager(this@HomeFragment.requireContext(), RecyclerView.HORIZONTAL, false)
            this.adapter = adapter
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                adapter.submitList(mockCategories)
            }
        }
    }

    private val onClickDetail = { item: ClothingPreviewItem ->
        requireActivity().supportFragmentManager.commit {
            add<ClothDetailsFragment>(
                R.id.fragment_container_view,
                tag = ClothDetailsFragment.TAG,
                args = item.toBundle()
            )
            setPrimaryNavigationFragment(childFragmentManager.findFragmentByTag(ClothDetailsFragment.TAG))
            setReorderingAllowed(true)
            addToBackStack(null)
        }

    }
    private fun setRecyclerViewClothes() {
        val adapter = ClothesPreviewAdapter(onClickDetail)
        binding.layoutRvClothes.rvClothes.apply {
            layoutManager =  GridLayoutManager(this@HomeFragment.requireContext(),2)
            this.adapter = adapter
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                adapter.submitList(mockClothingPreview)
            }
        }
    }

    private fun setChildFragments(savedInstanceState: Bundle?) {
        setCartFragment(savedInstanceState)
    }

    private fun setCartFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            binding.layoutSearcher.ivBtnFilter.setOnClickListener {
                requireActivity().supportFragmentManager.commit {
                    add<FiltersFragment>(R.id.fragment_container_view, tag = FiltersFragment.TAG)
                    setPrimaryNavigationFragment(childFragmentManager.findFragmentByTag(FiltersFragment.TAG))
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

    companion object {
        const val TAG = "HomeFragment"
    }

}