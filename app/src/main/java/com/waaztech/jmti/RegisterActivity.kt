package com.waaztech.jmti

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.waaztech.jmti.model.User
import com.waaztech.jmti.util.Storage

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnConfirmRegister = findViewById<Button>(R.id.btnConfirmRegister)

        val edtEmail = findViewById<EditText>(R.id.edtEmailInput)
        val edtPass = findViewById<EditText>(R.id.edtPassInput)
        val edtPhone = findViewById<EditText>(R.id.edtPhoneInput)
        val edtName = findViewById<EditText>(R.id.edtUserInput)


        btnBack.setOnClickListener {
            finish()
        }

        btnConfirmRegister.setOnClickListener {
            val users = mutableListOf<User>()
            users.add(User(edtEmail.text.toString(), edtName.text.toString(), edtPass.text.toString(), edtPhone.text.toString()))
            Storage().saveUsers(users)
            Toast.makeText(this, "User registered, you may proceed to login.", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}