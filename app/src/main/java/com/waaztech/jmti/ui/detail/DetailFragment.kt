package com.waaztech.jmti.ui.detail

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import coil.load
import com.waaztech.jmti.R
import com.waaztech.jmti.databinding.FragmentDetailBinding
import com.waaztech.jmti.databinding.FragmentProfileBinding
import com.waaztech.jmti.model.Product
import com.waaztech.jmti.model.UserOrder
import com.waaztech.jmti.ui.profile.ProfileViewModel
import com.waaztech.jmti.util.Storage

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val prodId = arguments?.getString("id")
        val product = prodId?.let { Storage().getSingleProduct(it) }

        binding.prodTitle.text = product?.text
        binding.prodImage.load(product?.image)
        binding.prodPrice.text = "RM${product?.price}"
        binding.prodDesc.text = product?.description

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnAddCart.setOnClickListener {
            saveOrder(userOrder = UserOrder(product?.id, product?.image, product?.text, product?.price,
                product?.category, product?.description))
        }

        return root
    }

    private fun saveOrder(userOrder: UserOrder){
        val orders = mutableListOf<UserOrder>()
        orders.addAll(Storage().getBuyerOrder())
        orders.add(userOrder)
        Storage().saveBuyerOrder(orders)

        Toast.makeText(context, "Sent order to seller", Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}