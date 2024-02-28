package com.eightgroupdev.finalwp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eightgroupdev.finalwp.R
import com.eightgroupdev.finalwp.adapters.Cats
import com.eightgroupdev.finalwp.adapters.CatsAdapter
import com.eightgroupdev.finalwp.adapters.Product
import com.eightgroupdev.finalwp.fragments.HomeFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Cats_category : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cats_category)
        backbtn()

        val recyclerViewCats = findViewById<RecyclerView>(R.id.all_cats)
        val layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)

        recyclerViewCats.layoutManager = layoutManager

        val adapter = CatsAdapter(catList())
        recyclerViewCats.adapter = adapter


    }
    fun catList(): List<Cats>{
        return listOf(
            Cats("Whiskas", "maraShop", R.drawable.whiskas_a, 150.00),
            Cats("Aozi Cat Food 20kg", "pochieShop", R.drawable.aa_aozi20_3300, 3300.00),
            Cats("Pet Bed", "pochieShop", R.drawable.cc_bed_1200, 1200.00),
            Cats("Cozy Tree for Cats", "pochieShop", R.drawable.cc_cozytree_1100, 1100.00),
            Cats("Royal Canin Catfood", "maraShop", R.drawable.aa_royalcanincat_300, 300.00),
            Cats("Water fountain for cats", "angeShop", R.drawable.bb_waterfountain_1570, 1570.00),
            Cats("Cozy Tree for Cats", "pochieShop", R.drawable.cc_cozytree_1100, 1100.00),
            Cats("Purina Friskies Wet food", "pochieShop", R.drawable.aa_friskieswet_110, 110.00),
            Cats("Pet Travel Cage", "pochieShop", R.drawable.ab_travelcage_450, 450.00),
            Cats("Lavander Cat Litter 8kg", "pochieShop", R.drawable.ab_litter_300, 300.00),
            Cats("MeowMix Wet Cat food", "pochieShop", R.drawable.cc_meowmixwet_150, 150.00)

        )

    }
    fun backbtn(){
        val bckbtn = findViewById<FloatingActionButton>(R.id.bckbtn)
        bckbtn.setOnClickListener{
            startActivity(Intent(this@Cats_category, HomeFragment::class.java))
            finish()
        }
    }
}