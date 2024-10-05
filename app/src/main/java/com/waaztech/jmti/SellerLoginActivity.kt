package com.waaztech.jmti

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.waaztech.jmti.activity.SellerRegisterInfo

class SellerLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seller_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnLogin.setOnClickListener {
            val intent = Intent(this, SellerMainActivity::class.java)
            intent.putExtra("key", "")
            startActivity(intent)
        }

        btnRegister.setOnClickListener {
            //Register here
            val intent = Intent(this, SellerRegisterInfo::class.java)
            intent.putExtra("key", "")
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}