package com.example.latihanroomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanroomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as AplikasiRoomPPB).repository)
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = StudentAdapter { student ->
            viewModel.delete(student)
        }

        binding.rvStudent.layoutManager = LinearLayoutManager(this)
        binding.rvStudent.adapter = adapter
        viewModel.students.observe(this) { students ->
            adapter.students = students
        }

        viewModel.isLoading.observe(this) {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }

        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, FromTambahActivity::class.java)
            startActivity(intent)
        }
    }
}