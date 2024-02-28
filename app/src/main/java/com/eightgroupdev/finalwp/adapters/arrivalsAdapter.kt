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
import com.eightgroupdev.finalwp.domain.arrivalDomain
import com.google.android.gms.analytics.ecommerce.Product

@Suppress("DEPRECATION")
class arrivalsAdapter(private val arrivals: List<FavoritesDomain>) :
    RecyclerView.Adapter<arrivalsAdapter.ArrivalViewHolder>() {

    inner class ArrivalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.itemName)
        val productImage: ImageView = itemView.findViewById(R.id.itemPic)
        val shopName: TextView = itemView.findViewById(R.id.itemShop)
        val productPrice: TextView = itemView.findViewById(R.id.itemPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArrivalViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.arrivalvewholder, parent, false)
        return ArrivalViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ArrivalViewHolder, position: Int) {
        val currentArrival = arrivals[position]

        holder.productName.text = currentArrival.title
        holder.shopName.text = currentArrival.shop // You can set the actual shop name
        holder.productPrice.text = "₱${currentArrival.getFee()}"
        holder.productImage.setImageResource(/* resId = */ currentArrival.picResourceId)
        // Reduce spacing between items
        holder.itemView.setPadding(5, 0, 5, 0)

        holder.itemView.setOnClickListener {
            // Create an intent to open the ProductViewActivity
            val intent = Intent(holder.itemView.context, ProductView::class.java)
            // You may want to pass some data to the ProductView activity, if needed
            intent.putExtra("product_name", currentArrival.title)
            intent.putExtra("product_img",currentArrival.picResourceId)
            intent.putExtra("product_price", currentArrival.fee)
            // Start the ProductView activity
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return arrivals.size
    }
}

