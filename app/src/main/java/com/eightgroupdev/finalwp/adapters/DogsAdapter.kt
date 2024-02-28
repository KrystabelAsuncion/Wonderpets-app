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

data class Dogs(
    val name: String?,
    val shop: String,
    val imageResourceId: Int,
    val price: Double
)

class DogsAdapter(private val general: List<Dogs>) :
    RecyclerView.Adapter<DogsAdapter.GeneralViewHolder>() {

    inner class GeneralViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val general_Name: TextView = itemView.findViewById(R.id.gen_name)
        val general_Img: ImageView = itemView.findViewById(R.id.gen_prodimg)
        val general_shop: TextView = itemView.findViewById(R.id.gen_shop)
        val general_price: TextView = itemView.findViewById(R.id.gen_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.general_itemholder, parent, false)
        return GeneralViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return general.size
    }

    override fun onBindViewHolder(holder: GeneralViewHolder, position: Int) {
        val cats = general[position]

        holder.general_Name.text = cats.name
        holder.general_shop.text = cats.shop
        holder.general_Img.setImageResource(cats.imageResourceId)
        holder.general_price.text = "₱${cats.price}"


        holder.itemView.setOnClickListener {
            // Create an intent to open the ProductViewActivity
            val intent = Intent(holder.itemView.context, ProductView::class.java)
            // You may want to pass some data to the ProductView activity, if needed
            intent.putExtra("product_name", cats.name)
            intent.putExtra("product_img", cats.imageResourceId)
            intent.putExtra("product_price", cats.price)
            // Start the ProductView activity
            holder.itemView.context.startActivity(intent)
        }
    }
}