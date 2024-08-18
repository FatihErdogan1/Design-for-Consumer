package com.example.costumer

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.costumer.databinding.ActivityMainMenuPageBinding

class mainMenuPage : AppCompatActivity() {
    private var _binding: ActivityMainMenuPageBinding? = null
    private val binding get() = _binding!!
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainMenuPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
            enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
            binding.scannerButton.setOnClickListener() {


            }
            binding.mainMenu.setOnClickListener() {
                val intent = Intent(this, mainMenuPage::class.java)
                startActivity(intent)
            }
            binding.surveyPageButton.setOnClickListener() {
                //val intent = Intent(this, surveyPage::class.java)
                //startActivity(intent)
            }
            binding.logOutButton.setOnClickListener() {
                val intent = Intent(this, loginPage::class.java)
                startActivity(intent)
            }
            binding.toolbarLayoutTop.imageViewMenu.setOnClickListener {
                val popup = PopupMenu(this, binding.toolbarLayoutTop.imageViewMenu)
                val inflater: MenuInflater = popup.menuInflater
                inflater.inflate(R.menu.toolbar_menu, popup.menu)
                popup.show()
                popup.setOnMenuItemClickListener { item: MenuItem? ->
                    when (item!!.itemId) {
                        R.id.mainMenu -> {
                            val intent = Intent(this, mainMenuPage::class.java)
                            startActivity(intent)
                            true
                        }
                        R.id.storyPageButton -> {
                            val intent = Intent(this, honeyStoryPage::class.java)
                            startActivity(intent)
                            true
                        }

                        R.id.logOutButton -> {
                            val intent = Intent(this, loginPage::class.java)
                            startActivity(intent)
                            true
                        }
                        else -> false
                    }
                }
            }


    }
}