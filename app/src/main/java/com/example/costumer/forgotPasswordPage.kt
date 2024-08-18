package com.example.costumer

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.costumer.databinding.ActivityForgotPasswordPageBinding

class forgotPasswordPage : AppCompatActivity() {
    private var _binding: ActivityForgotPasswordPageBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityForgotPasswordPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.cancelButton.setOnClickListener {
           val intent= Intent(this, loginPage::class.java)
            startActivity(intent)
        }
        binding.resetPasswordButton.setOnClickListener {
            val intent= Intent(this, loginPage::class.java)
            startActivity(intent)
        }

    }
}