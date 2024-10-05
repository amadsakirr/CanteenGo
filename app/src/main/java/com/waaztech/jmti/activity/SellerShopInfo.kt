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

class SellerShopInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seller_shop_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val edtShopName = findViewById<EditText>(R.id.edtShopNameInput)
        val edtShopAdd = findViewById<EditText>(R.id.edtShopAddressInput)
        val edtEmail = findViewById<EditText>(R.id.edtEmailInput)
        val edtPhone = findViewById<EditText>(R.id.edtPhoneInput)


        btnNext.setOnClickListener {
            val intent = Intent(this, SellerShippingInfo::class.java)
            intent.putExtra("name", getIntent().getStringExtra("name"))
            intent.putExtra("ic", getIntent().getStringExtra("ic"))
            intent.putExtra("shop", edtShopName.text.toString())
            intent.putExtra("add", edtShopAdd.text.toString())
            intent.putExtra("email", edtEmail.text.toString())
            intent.putExtra("phone", edtPhone.text.toString())
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}