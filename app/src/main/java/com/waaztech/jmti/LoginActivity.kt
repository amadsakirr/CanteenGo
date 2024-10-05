package com.waaztech.jmti

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.waaztech.jmti.util.Storage


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtEmail = findViewById<EditText>(R.id.edtEmailInput)
        val edtPassword = findViewById<EditText>(R.id.edtPassInput)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnLoginSeller = findViewById<Button>(R.id.btnLoginSeller)

        btnLogin.setOnClickListener {
            checkForUser(edtEmail.text.toString(), edtPassword.text.toString())
        }

        btnRegister.setOnClickListener {
            //Register here
            val intent = Intent(this, RegisterActivity::class.java)
            intent.putExtra("key", "")
            startActivity(intent)
        }

        btnLoginSeller.setOnClickListener {
            val intent = Intent(this, SellerLoginActivity::class.java)
            intent.putExtra("key", "")
            startActivity(intent)
        }
    }

    private fun checkForUser(email: String, password: String) {
        val users = Storage().getUsers()

        if (users.isEmpty()) {
            Toast.makeText(this, "Invalid email/password", Toast.LENGTH_LONG).show()
        }

        for (user in users) {
            if (user.email == email && user.password == password) {
                Storage().saveId(user.email)
                Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("key", "")
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid email/password", Toast.LENGTH_LONG).show()
            }
        }
    }
}