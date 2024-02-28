package com.eightgroupdev.finalwp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eightgroupdev.finalwp.R
import com.eightgroupdev.finalwp.adapters.AllProductAdapter
import com.eightgroupdev.finalwp.adapters.Product
import com.eightgroupdev.finalwp.fragments.HomeFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AllProducts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_products)
        backbtn()

        val recyclerViewAllProducts = findViewById<RecyclerView>(R.id.allProds)

        val layoutManager = GridLayoutManager(this, 2,GridLayoutManager.VERTICAL,false)

        recyclerViewAllProducts.layoutManager = layoutManager
        // Create and set the adapter for the RecyclerView
        val adapter = AllProductAdapter(genList())
        recyclerViewAllProducts.adapter = adapter
    }
    fun genList(): List<Product>{
        return listOf(
            Product("Whiskas", "maraShop", R.drawable.whiskas_a, 150.00),
            Product("Aozi Cat Food 20kg", "pochieShop", R.drawable.aa_aozi20_3300, 3300.00),
            Product("Pet Bed", "pochieShop", R.drawable.cc_bed_1200, 1200.00),
            Product("Cozy Tree for Cats", "pochieShop", R.drawable.cc_cozytree_1100, 1100.00),

            Product("Royal Canin Catfood", "maraShop", R.drawable.aa_royalcanincat_300, 300.00),
            Product("Pedigree adult Dog food", "angeShop", R.drawable.ab_pedigreeadult_100, 100.00),
            Product("Cozy Tree for Cats", "pochieShop", R.drawable.cc_cozytree_1100, 1100.00)

        )

    }
    fun backbtn(){
        val bckbtn = findViewById<FloatingActionButton>(R.id.bckbtn)
        bckbtn.setOnClickListener{
            startActivity(Intent(this@AllProducts,HomeFragment::class.java))
            finish()
        }
    }
}