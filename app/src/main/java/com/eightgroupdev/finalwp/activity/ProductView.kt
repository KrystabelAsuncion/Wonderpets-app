package com.eightgroupdev.finalwp.activity

import CartItem
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.eightgroupdev.finalwp.R
import com.eightgroupdev.finalwp.adapters.img_adapter
import com.eightgroupdev.finalwp.adapters.tabPagerAdapter
import com.eightgroupdev.finalwp.fragments.DescriptionFragment
import com.eightgroupdev.finalwp.fragments.ReviewsFragment
import com.eightgroupdev.finalwp.fragments.shopDetailFragment
import com.eightgroupdev.finalwp.managers.Product_
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

@Suppress("DEPRECATION")
class ProductView : AppCompatActivity() {

    private lateinit var imgPager: ViewPager
    private lateinit var imgAdapter: img_adapter
    private lateinit var tabviewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var tabpageradapter: tabPagerAdapter
    private val cart = mutableListOf<Product_>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_view)

        backBtn()
        buyNow()
        tabPager()
        displaydata()

    }

    fun displaydata(){

        // Retrieve the data passed via Intent
        val productName = intent.getStringExtra("product_name")
        val productPrice = intent.getDoubleExtra("product_price", 0.0)
        val productImageResource = intent.getIntExtra("product_img", 0)



        val disp_name = findViewById<TextView>(R.id.disp_name)
        val disp_price = findViewById<TextView>(R.id.disp_price)
        val disp_img = findViewById<ImageView>(R.id.disp_img)


        // Set the text in the TextViews
        disp_name.text = productName
        disp_price.text = "₱${productPrice}"

        // Set the image resource for the ImageView
        disp_img.setImageResource(productImageResource)

        val addToCartButton = findViewById<RelativeLayout>(R.id.RL_addtocart)
        addToCartButton.setOnClickListener {
            addToCartClicked()
        }
    }


    fun tabPager(){
        tabviewPager = findViewById(R.id.tabPager)
        tabLayout = findViewById(R.id.tab)

        // Create an adapter to manage the fragments
        val adapter = tabPagerAdapter(supportFragmentManager)
        adapter.addFragment(DescriptionFragment(), "Description")
        adapter.addFragment(shopDetailFragment(), "Shop")
        adapter.addFragment(ReviewsFragment(), "Reviews")

        tabviewPager.adapter = adapter
        tabLayout.setupWithViewPager(tabviewPager)
    }

    fun backBtn() {
        val fab_back = findViewById<FloatingActionButton>(R.id.fab_back)
        fab_back.setOnClickListener{
            startActivity(Intent(this@ProductView, BottomNavBar::class.java))
            finish()
        }
    }

    fun addToCartClicked() {
        val productName = intent.getStringExtra("product_name")
        val productPrice = intent.getDoubleExtra("product_price", 0.0)
        val productImageResource = intent.getIntExtra("product_img", 0)

        val product = Product_(productName, productPrice, productImageResource)

        // Create a CartItem with product details
        val cartItem = CartItem(product.name, product.price, product.image,1)

        // Add the cartItem to the cart using your CartManager
        CartManager.addToCart(cartItem)

        // Notify the user
        Toast.makeText(this, "Added to Cart", Toast.LENGTH_SHORT).show()
    }



    fun buyNow() {
        val buy_now = findViewById<RelativeLayout>(R.id.RL_buynow)
        buy_now.setOnClickListener{
            Toast.makeText(this,"Buy now clicked",Toast.LENGTH_SHORT).show()
        }
    }

}
