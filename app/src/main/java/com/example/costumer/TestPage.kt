package com.example.costumer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.costumer.databinding.ActivityTestPageBinding

class TestPage : AppCompatActivity() {
    private var _binding: ActivityTestPageBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityTestPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
         val testList = listOf(
            Test("Test 1", "Test 1 Description", "https://www.youtube.com/watch?v=test1"),
            Test("Test 2", "Test 2 Description", null), // No video for this test
            Test("Test 3", "Test 3 Description", "https://www.youtube.com/watch?v=test3")
        )
        val testNames = testList.map { it.testname }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, testNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.testSpinner.adapter = adapter
        binding.testSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedTest = testList[position]
                binding.descriptionTextView.text = selectedTest.description

                if (selectedTest.videoUrl != null) {
                    binding.videoButton.visibility = View.VISIBLE
                   binding.videoButton.setOnClickListener {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(selectedTest.videoUrl))
                        startActivity(intent)
                    }
                } else {
                   binding.videoButton.visibility = View.GONE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
              binding.descriptionTextView.text = "Select a test to see the description"
                binding.videoButton.visibility = View.GONE
            }
        }



    }
}