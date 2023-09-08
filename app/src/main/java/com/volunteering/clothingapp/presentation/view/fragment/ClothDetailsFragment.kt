package com.volunteering.clothingapp.presentation.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clothingapp.core.data.remote.model.params.Category
import com.clothingapp.core.data.remote.model.params.ClothingItem
import com.clothingapp.core.data.remote.model.params.ClothingPreviewItem
import com.clothingapp.core.data.remote.model.params.Color
import com.clothingapp.core.data.remote.model.params.Condition
import com.clothingapp.core.data.remote.model.params.Geo
import com.clothingapp.core.data.remote.model.params.Location
import com.clothingapp.core.data.remote.model.params.Occasion
import com.clothingapp.core.data.remote.model.params.Price
import com.clothingapp.core.data.remote.model.params.Season
import com.clothingapp.core.data.remote.model.params.Seller
import com.clothingapp.core.data.remote.model.params.ShippingOption
import com.clothingapp.core.data.remote.model.params.Size
import com.clothingapp.core.data.remote.model.params.Status
import com.clothingapp.core.data.remote.model.params.oneLine
import com.volunteering.clothingapp.databinding.LayoutFragmentClothDetailsBinding


class ClothDetailsFragment : Fragment() {

    private lateinit var clothingItem: ClothingPreviewItem
    private val LOG_TAG: String = "LT_ClothDetailsFragment"

    private var _binding: LayoutFragmentClothDetailsBinding? = null
    private val binding get() = _binding!!

    val mockClothingItem = ClothingItem(
        itemId = "001",
        title = "Vintage Denim Jacket",
        description = "A lightly worn, vintage denim jacket from the 90s. Perfect for casual outings and gives a retro vibe.",
        images = listOf("url_denim_jacket1.jpg", "url_denim_jacket2.jpg", "url_denim_jacket3.jpg"),
        category = Category.OUTERWEAR,
        subcategory = "Jackets",
        condition = Condition.LIKE_NEW,
        size = Size.L,
        price = Price(
            original = 100.00,
            selling = 50.00
        ),
        brand = "Levi's",
        material = "100% Cotton",
        careInstructions = "Machine wash cold. Tumble dry low.",
        color = Color(
            primary = "Blue",
            pattern = "Solid"
        ),
        location = Location(
            city = "New York",
            state = "NY",
            country = "USA",
            geo = Geo(
                latitude = 40.7128,
                longitude = -74.0060
            )
        ),
        shippingOptions = listOf(ShippingOption.FREE_SHIPPING, ShippingOption.STANDARD_SHIPPING),
        seller = Seller(
            sellerId = "user987654",
            rating = 4.5,
            name = "Javier Armenta"
        ),
        season = Season.ALL_SEASON,
        occasion = Occasion.CASUAL,
        dateListed = "2023-08-15",
        popularity = 120,
        status = Status.AVAILABLE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if(bundle != null ){
            clothingItem = bundle.toClothingPreviewItem()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayoutFragmentClothDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        setView()
        setChildFragments(savedInstanceState)
        return view
    }

    private fun setView() {
        binding.layoutRvClothes.apply {
            tvDetailsTitle.text = mockClothingItem.title
            tvDetailsSubtitle.text = mockClothingItem.description.substring(0,10)
            itemStatusViewImpl.state = mockClothingItem.status
            tvTotalTitle.text = mockClothingItem.price.selling.toString()
            tvDetailsValueCondition.text = mockClothingItem.condition.name
            tvDetailsValueSize.text = mockClothingItem.size.name
            tvDetailsValueBrand.text = mockClothingItem.brand
            tvDetailsValueMaterial.text = mockClothingItem.material
            tvDetailsValueColor.text = mockClothingItem.color.primary
            tvDetailsValueLocation.text = mockClothingItem.location.oneLine()
            tvDetailsValueDateListed.text = mockClothingItem.dateListed
            tvDetailsValueDescription.text = mockClothingItem.description
            itemSellerPreview.tvSellerName.text = mockClothingItem.seller.name
        }
    }

    private fun setChildFragments(savedInstanceState: Bundle?) {
        setHomeFragment(savedInstanceState)
    }

    private fun setHomeFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            binding.layoutRvClothes.btnAddToCart.setOnClickListener {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(LOG_TAG, "onDestroyView()")
        _binding = null
    }

    companion object {
        const val TAG = "ClothDetailsFragment"
        fun ClothingPreviewItem.toBundle(): Bundle {
            val bundle = Bundle()
            bundle.putString("itemId", itemId)
            bundle.putString("title", title)
            bundle.putStringArrayList("images", ArrayList(images))
            bundle.putString("distance", distance)
            bundle.putString("price", price)
            return bundle
        }

        fun Bundle.toClothingPreviewItem(): ClothingPreviewItem {
            val itemId = getString("itemId") ?: ""
            val title = getString("title") ?: ""
            val images = getStringArrayList("images") ?: ArrayList()
            val distance = getString("distance") ?: ""
            val price = getString("price") ?: ""

            return ClothingPreviewItem(itemId, title, images, distance, price)
        }

    }

}