package id.strade.android.buyer.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import id.strade.android.buyer.ProductListActivity_
import id.strade.android.buyer.R
import id.strade.android.buyer.model.User

/**
 * Created by ARSnova on 20/11/2017.
 */
class SellerAdapter(val context: Context, val itemList: ArrayList<User>) : RecyclerView.Adapter<SellerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_seller, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name_view)
        var image: ImageView = itemView.findViewById(R.id.image_view)
        var address: TextView = itemView.findViewById(R.id.address_view)
        var status: TextView = itemView.findViewById(R.id.status_view)
        var distance: TextView = itemView.findViewById(R.id.distance_view)
        fun bindItems(user: User) {
            name.text = user.store?.name
            address.text = user.store?.address
            distance.text = "${user.store?.distance} KM"
            status.text = "BUKA"
//            status.text = "${store.statusStr}"
            Glide.with(image).load(user.store?.imageUrl).into(image)
            image.setOnClickListener {
                ProductListActivity_.intent(context).seller(user).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start()
            }
        }

    }
}