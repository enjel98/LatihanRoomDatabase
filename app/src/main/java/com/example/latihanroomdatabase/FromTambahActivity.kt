package com.example.latihanroomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.latihanroomdatabase.databinding.ActivityFromTambahBinding
import com.example.latihanroomdatabase.db.Student

class FromTambahActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as AplikasiRoomPPB).repository)
    }
    private lateinit var binding: ActivityFromTambahBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFromTambahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnSimpan.setOnClickListener {
                val nim = etNim.text.toString()
                val nama = etNama.text.toString()
                val student = Student(0, nim, nama)
                viewModel.insert(student)
                finish()
            }
        }
    }
}