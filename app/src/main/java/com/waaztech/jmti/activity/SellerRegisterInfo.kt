package com.waaztech.jmti.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.waaztech.jmti.R
import com.waaztech.jmti.RegisterActivity

class SellerRegisterInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seller_register_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val edtIC = findViewById<EditText>(R.id.edtIcInput)
        val edtName = findViewById<EditText>(R.id.edtNameInput)

        btnNext.setOnClickListener {
            val intent = Intent(this, SellerShopInfo::class.java)
            intent.putExtra("ic", edtIC.text.toString())
            intent.putExtra("name", edtName.text.toString())
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            finish()
        }

    }
}