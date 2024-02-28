package com.eightgroupdev.finalwp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eightgroupdev.finalwp.R
import com.eightgroupdev.finalwp.activity.ProductView
import com.eightgroupdev.finalwp.domain.FavoritesDomain

class favoritesAdapter(private val favorites: List<FavoritesDomain>) :
    RecyclerView.Adapter<favoritesAdapter.favoriteviewholder>() {

    inner class favoriteviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.itemName_f)
        val productImage: ImageView = itemView.findViewById(R.id.itemPic_f)
        val shopName: TextView = itemView.findViewById(R.id.itemShop_f)
        val productPrice: TextView = itemView.findViewById(R.id.itemPrice_f)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): favoriteviewholder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.favoriteviewholder, parent, false)
        return favoriteviewholder(itemView)
    }

    override fun onBindViewHolder(holder: favoriteviewholder, position: Int) {
        val currentFave= favorites[position]

        holder.productName.text = currentFave.title
        holder.shopName.text = currentFave.shop // You can set the actual shop name
        holder.productPrice.text = "₱${currentFave.getFee()}"
        holder.productImage.setImageResource(/* resId = */ currentFave.picResourceId)

        holder.itemView.setOnClickListener {
            // Create an intent to open the ProductViewActivity
            val intent = Intent(holder.itemView.context, ProductView::class.java)
            // You may want to pass some data to the ProductView activity, if needed
            intent.putExtra("product_name", currentFave.title)
            intent.putExtra("product_img",currentFave.picResourceId)
            intent.putExtra("product_price", currentFave.fee)
            // Start the ProductView activity
            holder.itemView.context.startActivity(intent)
        }
        // Reduce spacing between items
        holder.itemView.setPadding(5, 0, 5, 0)

    }

    override fun getItemCount(): Int {
        return favorites.size
    }
}