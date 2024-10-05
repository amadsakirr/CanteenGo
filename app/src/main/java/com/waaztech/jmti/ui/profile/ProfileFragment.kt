package com.waaztech.jmti.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.waaztech.jmti.MainActivity
import com.waaztech.jmti.databinding.FragmentProfileBinding
import com.waaztech.jmti.util.Storage

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val userId = Storage().getId()
        val userInfo = Storage().getSpecificUser(userId)

        binding.txtName.text = userInfo.name
        binding.txtEmail.text = userInfo.email
        binding.txtPhoneNumber.text = userInfo.phoneNumber

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