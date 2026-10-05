package com.example.ahmad_project_3tia

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ahmad_project_3tia.databinding.ActivityLoginBinding
import com.example.ahmad_project_3tia.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val user = intent.getStringExtra("EXTRA_USER")
        val password = intent.getStringExtra("EXTRA_PASS")

        binding.texUsername.text = "user: $user"
        binding.textPassword.text = "password: $password"

        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Halo ini SnackBar",
                Snackbar.LENGTH_LONG)
                .setAction("KEMBALI") {
                    // kembalikan item
                    val intent = Intent (this, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Kembali ke halaman Activity", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Hapus data")
                .setMessage("Data yang dihapus tidak " +
                        "bisa dikembalikan.")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->
                    // proses hapus
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }
    }
}