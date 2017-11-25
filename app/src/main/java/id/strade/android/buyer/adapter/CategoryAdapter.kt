package id.strade.android.buyer.adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import id.strade.android.buyer.R
import id.strade.android.buyer.model.Category
import id.strade.android.buyer.model.Store

/**
 * Created by ARSnova on 25/11/2017.
 */
class CategoryAdapter (val categoryList: ArrayList<Category>, val rv: RecyclerView,val ctx: Context): RecyclerView.Adapter<CategoryAdapter.ViewHolder> (){
    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.category_card, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(categoryList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return categoryList.size
    }

    //the class is hodling the list view
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.tv_category_title)
        var detail: TextView = itemView.findViewById(R.id.tv_category_detail)
        var img: ImageView = itemView.findViewById(R.id.thumbnail)
        fun bindItems(ctg: Category) {
            title.text = ctg.title
            detail.text = ctg.detail
            Glide.with(ctx).load(ctg.url_image).into(img)
            itemView.setOnClickListener(View.OnClickListener {
                val list_adapter = CustomAdapter(getItemLists(),rv,ctx)
                rv.layoutManager = LinearLayoutManager(ctx, LinearLayout.VERTICAL, false)
                rv.adapter = list_adapter
            })
        }
        fun getItemLists(): ArrayList<Store> {
            var lists = ArrayList<Store>()
            lists.add(Store(1, 1, "Bakso Pak Mamat", 0, "08.00", "16.00"))
            lists.add(Store(1, 1, "Siomay Bang Jek", 0, "08.00", "16.00"))
            lists.add(Store(1, 1, "Jamu Gendong Uhuy", 0, "08.00", "16.00"))
            return lists;
        }

    }
}