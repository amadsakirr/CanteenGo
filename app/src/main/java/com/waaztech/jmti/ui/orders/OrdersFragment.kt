package com.waaztech.jmti.ui.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.waaztech.jmti.databinding.FragmentNotificationsBinding
import com.waaztech.jmti.ui.home.OrderAdapter
import com.waaztech.jmti.util.Storage

class OrdersFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val ordersViewModel =
            ViewModelProvider(this)[OrdersViewModel::class.java]

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recyclerProduct.adapter = OrderAdapter(Storage().getBuyerOrder())
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}