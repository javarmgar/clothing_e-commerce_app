package com.volunteering.clothingapp.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.clothingapp.core.data.remote.model.BankCardModel
import com.clothingapp.core.data.remote.model.BankNetwork
import com.clothingapp.core.data.remote.model.PaymentsModel
import com.volunteering.clothingapp.databinding.LayoutFragmentPaymentMethodPickerBinding
import com.volunteering.clothingapp.presentation.view.adapter.BankCardAdapter
import com.volunteering.clothingapp.presentation.view.adapter.NewPaymentMethodAdapter
import kotlinx.coroutines.launch

class PaymentMethodPickerFragment : Fragment() {

    private  var _binding: LayoutFragmentPaymentMethodPickerBinding? = null
    private val binding get() = _binding!!

    val mockData = listOf(
        BankCardModel(
            bankAccountNumber = "1234 5678 9101 1121",
            bankAccountName = "John Doe",
            bankTypeNetwork = BankNetwork.MASTER_CARD,
            isCardSelected = true
        ),
        BankCardModel(
            bankAccountNumber = "1121 1314 1516 1718",
            bankAccountName = "Alice Smith",
            bankTypeNetwork = BankNetwork.VISA,
            isCardSelected = false
        ),
        BankCardModel(
            bankAccountNumber = "1920 2122 2324 2526",
            bankAccountName = "Bob Brown",
            bankTypeNetwork = BankNetwork.MASTER_CARD,
            isCardSelected = false
        ),
        BankCardModel(
            bankAccountNumber = "2728 2930 3132 3334",
            bankAccountName = "Charlie Clark",
            bankTypeNetwork = BankNetwork.VISA,
            isCardSelected = true
        )
    )

    val paymentsMockData = listOf(
        PaymentsModel(
            bankNetwork = BankNetwork.MASTER_CARD,
            urlImageCardTypeNetwork = "https://example.com/mastercard.png", // replace with actual URL
            textCardTypeNetwork = "Master Card"
        ),
        PaymentsModel(
            bankNetwork = BankNetwork.VISA,
            urlImageCardTypeNetwork = "https://example.com/visa.png", // replace with actual URL
            textCardTypeNetwork = "Visa"
        ),
        PaymentsModel(
            bankNetwork = BankNetwork.APPLE_PAY,
            urlImageCardTypeNetwork = "https://example.com/applepay.png", // replace with actual URL
            textCardTypeNetwork = "Apple Pay"
        ),
        PaymentsModel(
            bankNetwork = BankNetwork.MASTER_CARD,
            urlImageCardTypeNetwork = "https://example.com/mastercard.png", // replace with actual URL
            textCardTypeNetwork = "Master Card"
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LayoutFragmentPaymentMethodPickerBinding.inflate(inflater, container, false)
        setViewPager()
        setRecyclerView()
        return binding.root
    }

    private fun setViewPager() {
        val adapter = BankCardAdapter()
        binding.viewPagerBankCards.adapter = adapter
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                adapter.submitList(mockData)
            }
        }
    }

    private fun setRecyclerView() {
        val adapter = NewPaymentMethodAdapter()
        binding.rvPaymentMethods.layoutManager = LinearLayoutManager(this.requireContext())
        binding.rvPaymentMethods.adapter = adapter
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                adapter.submitList(paymentsMockData)
            }
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = PaymentMethodPickerFragment()
    }
}