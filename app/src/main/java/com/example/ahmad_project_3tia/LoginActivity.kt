package com.example.ahmad_project_3tia

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ahmad_project_3tia.databinding.ActivityLoginBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        val tombollogin: Button = findViewById(R.id.btnLogin)
//        val username : EditText = findViewById(R.id.username)
//        val password : EditText = findViewById(R.id.edtPassword)

        binding.btnLogin.setOnClickListener {
            val user = binding.username.text.toString()
            val password = binding.edtPassword.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("EXTRA_USER", user)
            intent.putExtra("EXTRA_PASS", password)
            startActivity(intent)

            Log.d("Output","Username: $user  Password: $password")
            Toast.makeText(this,"Username: $user  Password: $password", Toast.LENGTH_LONG).show()
        }
    }
}