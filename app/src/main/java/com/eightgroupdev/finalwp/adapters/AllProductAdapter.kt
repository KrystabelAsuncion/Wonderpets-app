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

data class Product(
    val name: String?,
    val shop: String,
    val imageResourceId: Int,
    val price: Double
)

class AllProductAdapter(private val general: List<Product>) :

    RecyclerView.Adapter<AllProductAdapter.GeneralViewHolder>() {

    inner class GeneralViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val general_Name: TextView = itemView.findViewById(R.id.gen_name)
        val general_Img: ImageView = itemView.findViewById(R.id.gen_prodimg)
        val general_shop: TextView = itemView.findViewById(R.id.gen_shop)
        val general_price: TextView = itemView.findViewById(R.id.gen_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.general_itemholder, parent, false)
        return GeneralViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return general.size
    }

    override fun onBindViewHolder(holder: GeneralViewHolder, position: Int) {
        val all = general[position]

        holder.general_Name.text = all.name
        holder.general_shop.text = all.shop
        holder.general_Img.setImageResource(all.imageResourceId)
        holder.general_price.text = "₱${all.price}"


        holder.itemView.setOnClickListener {
            // Create an intent to open the ProductViewActivity
            val intent = Intent(holder.itemView.context, ProductView::class.java)
            // You may want to pass some data to the ProductView activity, if needed
            intent.putExtra("product_name", all.name)
            intent.putExtra("product_img",all.imageResourceId)
            intent.putExtra("product_price", all.price)
            // Start the ProductView activity
            holder.itemView.context.startActivity(intent)
        }
    }
}
