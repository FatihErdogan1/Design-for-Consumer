package com.example.costumer

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.costumer.databinding.ActivityLoginPageBinding

class loginPage : AppCompatActivity() {
    private var _binding: ActivityLoginPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.loginButton.setOnClickListener {
            val intent= Intent(this, mainMenuPage::class.java)
            startActivity(intent)

        }
      binding.forgotPasswordText.setOnClickListener {
            val intent= Intent(this, forgotPasswordPage::class.java)
            startActivity(intent)

        }
        binding.signUpNowText.setOnClickListener {
            val intent= Intent(this, RegisterPage::class.java)
            startActivity(intent)

        }
        binding.guestModeButton.setOnClickListener {
            val intent= Intent(this, mainMenuPage::class.java)
            startActivity(intent)

        }






    }




}