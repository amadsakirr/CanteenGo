package com.waaztech.jmti.ui.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.carousel.auna.models.SlideModel
import com.waaztech.jmti.R
import com.waaztech.jmti.databinding.FragmentHomeBinding
import com.waaztech.jmti.model.Category
import com.waaztech.jmti.model.Product
import com.waaztech.jmti.util.Storage

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.edtSearchInput.doOnTextChanged { text, start, before, count ->
            val allProducts = Storage().returnAllProd()
            val searchedProduct = mutableListOf<Product>()

            if(text != null) {
                for (prod in allProducts) {
                    if (prod.text.contains(text, true)) {
                        searchedProduct.add(prod)
                    }
                }
            }

            binding.recyclerProduct.adapter = ProductAdapter(searchedProduct, this)
        }

        val category = ArrayList<Category>()

        category.add(Category("1", "All"));
        category.add(Category("2", "Food"));
        category.add(Category("3", "Fashion"));
        category.add(Category("4", "Cosmetic"));
        category.add(Category("5", "Toys"));


        binding.recyclerProduct.adapter = ProductAdapter(Storage().returnAllProd(), this)
        binding.recyclerCat.adapter = CategoryAdapter(category)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel("https://img.freepik.com/free-psd/fashion-sale-banner-template_23-2148935598.jpg?semt=ais_hybrid","Buy One get two for free",true))
        imageList.add(SlideModel("https://as2.ftcdn.net/v2/jpg/02/52/71/83/1000_F_252718372_G8xqAJCiktFD2T3vrcZkRjO9HOoc5afB.jpg","Eat at 5% price reduction on Fridays",true))
        imageList.add(SlideModel("https://img.freepik.com/free-vector/gradient-sale-background_23-2148934477.jpg","Come and enjoy with your family",true))

        binding.imageSlider.setImageList(imageList)
        binding.imageSlider.startSliding(3000)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun navigateToDetail(id: String){
        val bundle = bundleOf("id" to id)
        findNavController().navigate(R.id.action_navigation_home_to_detailFragment, bundle)
    }
}