package com.waaztech.jmti.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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

        val category = ArrayList<Category>()

        category.add(Category("1", "All"));
        category.add(Category("2", "Food"));
        category.add(Category("3", "Fashion"));
        category.add(Category("4", "Cosmetic"));
        category.add(Category("5", "Toys"));


        binding.recyclerProduct.adapter = ProductAdapter(addDemoProduct(), this)
        binding.recyclerCat.adapter = CategoryAdapter(category)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addDemoProduct(): List<Product> {
        val data = Storage().getProducts().toMutableList()
        data.add(
            Product(
                id = "CSR Sugar",
                price = "7.80",
                text = "CSR Sugar",
                image = "https://csr-malaysia.com.my/storage/2023/08/CSR_BetterWhite_Jernih.png",
                category = "food",
                description = "Sugar"
            )
        )
        data.add(
            Product(
                id = "CSR Sugar",
                price = "7.80",
                text = "CSR Sugar",
                image = "https://www.wcrf-uk.org/wp-content/uploads/2021/06/Kiwi_A-Z-Fruit13-300x300.jpg",
                category = "food",
                description = "Sugar"
            )
        )
        data.add(
            Product(
                id = "CSR Sugar",
                price = "7.80",
                text = "CSR Sugar",
                image = "https://www.wcrf-uk.org/wp-content/uploads/2021/06/Kiwi_A-Z-Fruit13-300x300.jpg",
                category = "food",
                description = "Sugar"
            )
        )

        return data
    }

    fun navigateToDetail(id: String){
        val bundle = bundleOf("id" to id)
        findNavController().navigate(R.id.action_navigation_home_to_detailFragment, bundle)
    }
}