package com.waaztech.jmti.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.waaztech.jmti.R
import com.waaztech.jmti.model.Product
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import coil.load

class ProductAdapter (private val mList: List<Product>, private val homeFragment: HomeFragment) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = mList[position]

        holder.imageView.load(product.image)
        holder.name.text = product.text
        holder.price.text = "RM ${product.price}"
        holder.view.setOnClickListener {
            homeFragment.navigateToDetail(product.id)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val view: LinearLayout = itemView.findViewById(R.id.view)
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val name: TextView = itemView.findViewById(R.id.name)
        val price: TextView = itemView.findViewById(R.id.price)
    }
}