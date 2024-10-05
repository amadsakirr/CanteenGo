package com.waaztech.jmti

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.waaztech.jmti.activity.SellerRegisterInfo
import com.waaztech.jmti.util.Storage

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
        val email = findViewById<EditText>(R.id.edtUserInput)

        btnLogin.setOnClickListener {
            checkForUser(email.text.toString())
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

    private fun checkForUser(email: String) {
        val users = Storage().getSellers()

        if (users.isEmpty()) {
            Toast.makeText(this, "Invalid email/password", Toast.LENGTH_LONG).show()
        }

        for (user in users) {
            if (user.email == email) {
                Storage().saveSellerId(user.email)
                Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
                val intent = Intent(this, SellerMainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid email/password", Toast.LENGTH_LONG).show()
            }
        }
    }
}