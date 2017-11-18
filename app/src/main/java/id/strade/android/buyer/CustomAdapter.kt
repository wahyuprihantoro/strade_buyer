package id.strade.android.buyer

/**
 * Created by ARSnova on 18/11/2017.
 */
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import id.strade.android.buyer.model.Store
import kotlinx.android.synthetic.main.list_layout.view.*
import org.w3c.dom.Text


class CustomAdapter(val userList: ArrayList<Store>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is hodling the list view
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_name)
        var openTime:TextView = itemView.findViewById(R.id.tv_openTime)
        var closeTime:TextView = itemView.findViewById(R.id.tv_closeTime)
        fun bindItems(user: Store) {
            name.text = user.name
            openTime.text = user.openTime
            closeTime.text = user.closeTime
        }
    }
}