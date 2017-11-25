package id.strade.android.buyer.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import id.strade.android.buyer.R
import id.strade.android.buyer.model.Item

/**
 * Created by ARSnova on 20/11/2017.
 */
class SellerAdapter(val itemList: ArrayList<Item>) : RecyclerView.Adapter<SellerAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_list_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(itemList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return itemList.size
    }

    //the class is hodling the list view
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_item_name)
        var price: TextView = itemView.findViewById(R.id.tv_price)
        fun bindItems(user: Item) {
            name.text = user.name
            price.text = user.price.toString()
        }

    }
}