package com.eightgroupdev.finalwp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eightgroupdev.finalwp.R
import com.eightgroupdev.finalwp.adapters.Cats
import com.eightgroupdev.finalwp.adapters.CatsAdapter
import com.eightgroupdev.finalwp.adapters.Dogs
import com.eightgroupdev.finalwp.adapters.DogsAdapter
import com.eightgroupdev.finalwp.fragments.HomeFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Dogs_category : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dogs_category)

        backbtn()

        val recyclerViewCats = findViewById<RecyclerView>(R.id.all_dogs)
        val layoutManager = GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false)

        recyclerViewCats.layoutManager = layoutManager

        val adapter = DogsAdapter(dogList())
        recyclerViewCats.adapter = adapter


    }
    fun dogList(): List<Dogs>{
        return listOf(
            Dogs("Oatmeal Shampoo fo Dogs", "maraShop", R.drawable.cc_shamp_400, 400.00),
            Dogs("Pedigree Adult Dog Food", "pochieShop", R.drawable.ab_pedigreeadult_100, 100.00),
            Dogs("Durable Tactical Dog Collar", "pochieShop", R.drawable.cc_collardog_165, 165.00),
            Dogs("Durable Tactical Dog Collar", "pochieShop", R.drawable.bb_dogcollar_265, 265.00),
            Dogs("Aozi Wet food Dog", "maraShop", R.drawable.bb_aoziwetdog_75, 75.00)

        )

    }
    fun backbtn(){
        val bckbtn = findViewById<FloatingActionButton>(R.id.bckbtn)
        bckbtn.setOnClickListener{
            startActivity(Intent(this@Dogs_category, HomeFragment::class.java))
            finish()
        }
    }
}