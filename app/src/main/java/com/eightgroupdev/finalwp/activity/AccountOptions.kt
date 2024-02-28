package com.eightgroupdev.finalwp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eightgroupdev.finalwp.databinding.ActivityAccountOptionsBinding

class AccountOptions : AppCompatActivity() {

    private lateinit var binding:ActivityAccountOptionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountOptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        

        binding.signbtn.setOnClickListener{

            startActivity(Intent(this@AccountOptions,Register::class.java))
        }

        binding.logbtn.setOnClickListener{
            startActivity(Intent(this@AccountOptions, LogIn::class.java))
        }
    }
}