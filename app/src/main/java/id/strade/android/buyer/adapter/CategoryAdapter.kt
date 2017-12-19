package id.strade.android.buyer.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import id.strade.android.buyer.R
import id.strade.android.buyer.SellerListActivity_
import id.strade.android.buyer.model.Category

/**
 * Created by ARSnova on 25/11/2017.
 */
class CategoryAdapter(private val categories: ArrayList<Category>, val context: Context) :
        RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.tv_category_title)
        var detail: TextView = itemView.findViewById(R.id.tv_category_detail)
        var img: ImageView = itemView.findViewById(R.id.thumbnail)
        var layout: LinearLayout = itemView.findViewById(R.id.clickable_layout)
        fun bindItems(ctg: Category) {
            title.text = ctg.title
            detail.text = ctg.detail
            Glide.with(context).load(ctg.url_image).into(img)
            layout.setOnClickListener {
                SellerListActivity_.intent(context).start()
            }
        }
    }
}