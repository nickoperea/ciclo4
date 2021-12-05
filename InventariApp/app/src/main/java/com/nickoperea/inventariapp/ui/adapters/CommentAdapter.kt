package com.nickoperea.inventariapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nickoperea.inventariapp.data.models.Comment
import com.nickoperea.inventariapp.databinding.ItemCommentBinding

class CommentAdapter(var items: List<Comment>): RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    class ViewHolder(val item: ItemCommentBinding): RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentAdapter.ViewHolder {
        return ViewHolder(
            ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CommentAdapter.ViewHolder, position: Int) {
        var item = items[position]
        holder.item.commentAuthorLabel.text = item.author
        holder.item.commentDescriptionLabel.text = item.description
//        holder.item.commentDateLabel.text = item.date
        Glide.with(holder.itemView).load(item.image).into(holder.item.commentImageFrame)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    fun newDataSet(newData: List<Comment>) {
        items = newData
        notifyDataSetChanged()
    }
}