package com.waaztech.jmti.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.waaztech.jmti.R
import com.waaztech.jmti.SellerLoginActivity
import com.waaztech.jmti.model.Seller
import com.waaztech.jmti.util.Storage

class SellerShippingInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seller_shipping_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnNext.setOnClickListener {
            val intent = Intent(this, SellerLoginActivity::class.java)
            val seller = getIntent().getStringExtra("email")?.let { it1 ->
                getIntent().getStringExtra("name")?.let { it2 ->
                    getIntent().getStringExtra("phone")?.let { it3 ->
                        getIntent().getStringExtra("shop")?.let { it4 ->
                            getIntent().getStringExtra("add")?.let { it5 ->
                                Seller(email = it1, name = it2,
                                    password = "", phoneNumber = it3,
                                    shopName = it4, shopAddress = it5
                                )
                            }
                        }
                    }
                }
            }
            val sellers = mutableListOf<Seller>()
            if (seller != null) {
                sellers.add(seller)
            }
            Storage().saveSellers(sellers)
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}