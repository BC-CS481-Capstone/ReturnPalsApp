package com.example.returnpals.ui.pricing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.returnpals.databinding.FragmentPricingBinding

class PricingFragment : Fragment() {

    private var _binding: FragmentPricingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val pricingViewModel =
            ViewModelProvider(this).get(PricingViewModel::class.java)

        _binding = FragmentPricingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textPricing
        pricingViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}