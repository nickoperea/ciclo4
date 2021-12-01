package com.nickoperea.inventariapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nickoperea.inventariapp.data.models.Product
import com.nickoperea.inventariapp.databinding.ItemProductBinding
import com.nickoperea.inventariapp.ui.listeners.OnProductListener

class ProductAdapter(var items: List<Product>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(val item: ItemProductBinding): RecyclerView.ViewHolder(item.root)

    var listener: OnProductListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        return ViewHolder(
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        var item = items[position]
        holder.item.productTitleLabel.text = item.name
        holder.item.productPriceLabel.text = item.price.toString()
        Glide.with(holder.itemView).load(item.image).into(holder.item.productImageFrame)
        holder.item.root.setOnClickListener {
            listener?.onClick(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun newDataSet(newData: List<Product>) {
        items = newData
        notifyDataSetChanged()
    }
}