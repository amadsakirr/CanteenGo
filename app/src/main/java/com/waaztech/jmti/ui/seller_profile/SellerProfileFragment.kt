package com.waaztech.jmti.ui.seller_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.waaztech.jmti.databinding.FragmentSellerProfileBinding
import com.waaztech.jmti.util.Storage

class SellerProfileFragment : Fragment() {

    private var _binding: FragmentSellerProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val sellerProfileViewModel = ViewModelProvider(this)[SellerProfileViewModel::class.java]

        _binding = FragmentSellerProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val id = Storage().getSellerId()
        val seller = Storage().getSpecificSeller(id)

        binding.txtName.text = seller.name
        binding.txtEmail.text = seller.email
        binding.txtPhoneNumber.text = seller.phoneNumber
        binding.txtShopAddress.text = seller.shopAddress

        binding.btnLogout.setOnClickListener {
            activity?.finish()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}