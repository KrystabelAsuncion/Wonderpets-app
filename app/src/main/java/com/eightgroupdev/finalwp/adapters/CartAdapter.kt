package com.eightgroupdev.finalwp.adapters

import CartItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eightgroupdev.finalwp.R
import kotlin.collections.toMutableList

class CartAdapter(
    private var cartItems: List<CartItem>, // Changed List to MutableList
    private val totalItems: TextView, // Renamed TotalItems to totalItems for naming consistency
    private val totalPrice: TextView // Renamed TotalPrice to totalPrice for naming consistency
) : RecyclerView.Adapter<CartAdapter.CartItemViewHolder>() {

    inner class CartItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.prod_name)
        val itemPrice: TextView = itemView.findViewById(R.id.tv_price)
        val itemImage: ImageView = itemView.findViewById(R.id.prod_pic)
        val add: ImageView = itemView.findViewById(R.id.add)
        val minus: ImageView = itemView.findViewById(R.id.minus)
        val quantity: TextView = itemView.findViewById(R.id.tv_quantity)
        val deletebtn: ImageView = itemView.findViewById(R.id.delete_btn)

        fun bind(cartItem: CartItem) {
            itemName.text = cartItem.productName
            itemPrice.text = "₱${cartItem.productPrice}"
            itemImage.setImageResource(cartItem.productImageResource)
            quantity.text = cartItem.quantity.toString()

            add.setOnClickListener {
                // Handle increment button click
                cartItem.incrementQuantity()
                quantity.text = cartItem.quantity.toString()
                updateTotalPrice()
            }

            minus.setOnClickListener {
                // Handle decrement button click
                if (cartItem.quantity > 0) {
                    cartItem.decrementQuantity()
                    quantity.text = cartItem.quantity.toString()
                    updateTotalPrice()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_holder, parent, false)
        return CartItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        val item = cartItems[position]

        holder.bind(item)
        holder.deletebtn.setOnClickListener {
            removeItem(position)
        }
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    fun removeItem(position: Int) {
        cartItems = cartItems.toMutableList()
        (cartItems as MutableList).removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount)
        updateTotalPrice()
    }

    private fun updateTotalPrice() {
        // After removing or updating an item, update the total items and total price
        val totalItemsCount = cartItems.sumOf { it.quantity }
        val totalPriceValue = calculateTotalPrice(cartItems)

        // Update the total items and total price TextViews
        totalItems.text = totalItemsCount.toString()
        totalPrice.text = "₱$totalPriceValue"
    }

    private fun calculateTotalPrice(cartItems: List<CartItem>): Double {
        return cartItems.sumOf { it.productPrice * it.quantity }
    }
}
