package com.waaztech.jmti.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.waaztech.jmti.databinding.FragmentDashboardBinding
import com.waaztech.jmti.model.Product
import com.waaztech.jmti.util.Storage

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel = ViewModelProvider(this)[DashboardViewModel::class.java]

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.edtUrlInput.doOnTextChanged { text, start, before, count ->
            binding.imgProd.load(text.toString())
        }

        binding.btnConfirm.setOnClickListener {
            saveProduct(Product(id=binding.edtProdNameInput.text.toString(), image=binding.edtUrlInput.text.toString(),
                text = binding.edtProdNameInput.text.toString(), price = binding.edtPriceInput.text.toString(),
                category =binding.edtCatInput.text.toString() , description = binding.edtProdDescInput.text.toString()))
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun saveProduct(product: Product){
        val products = mutableListOf<Product>()
        products.addAll(Storage().getProducts())
        products.add(product)
        Storage().saveProducts(products)
        resetFields()
        Toast.makeText(context, "Product created!", Toast.LENGTH_LONG).show()
    }

    private fun resetFields(){
        binding.edtUrlInput.setText("")
        binding.edtProdNameInput.setText("")
        binding.edtPriceInput.setText("")
        binding.edtProdDescInput.setText("")
        binding.edtCatInput.setText("")
    }
}