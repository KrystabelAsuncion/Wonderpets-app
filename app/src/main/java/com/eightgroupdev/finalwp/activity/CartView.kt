package com.eightgroupdev.finalwp.activity

import CartItem
import CartSharedViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eightgroupdev.finalwp.R // Import your Product_ class
import com.eightgroupdev.finalwp.adapters.CartAdapter

class CartView : AppCompatActivity() {
    private lateinit var cartRecyclerView: RecyclerView
    private lateinit var totalItemsTextView: TextView
    private lateinit var totalPriceTextView: TextView
    //dagda
    private lateinit var cartSharedViewModel: CartSharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_view)
        //andagdag
        cartSharedViewModel = ViewModelProvider(this).get(CartSharedViewModel::class.java)

        cartRecyclerView = findViewById(R.id.RC_View)
        totalItemsTextView = findViewById(R.id.totalItem)
        totalPriceTextView = findViewById(R.id.totalPrice)
        val cartItems = CartManager.getCartItems() // Retrieve cart items

// Set up the RecyclerView
        cartRecyclerView.layoutManager = LinearLayoutManager(this)
        val cartAdapter = CartAdapter(cartItems, totalItemsTextView, totalPriceTextView)
        cartRecyclerView.adapter = cartAdapter
        val totalItems = cartItems.size // Total items is the size of the cart
        val totalPrice = calculateTotalPrice(cartItems)

        // Set the total items and total price in TextViews
        totalItemsTextView.text = totalItems.toString()
        totalPriceTextView.text = "₱$totalPrice"
    }

    // Replace this method with your own logic to create cart items

    // Replace this method with your own logic to calculate the total price
    private fun calculateTotalPrice(cartItems: List<CartItem>): Double {
        var totalPrice = 0.0
        for (item in cartItems) {
            // Assuming that productPrice and quantity are properties of CartItem class
            totalPrice += item.productPrice * item.quantity
        }
        return totalPrice
    }
}
