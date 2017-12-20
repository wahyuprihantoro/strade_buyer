package id.strade.android.buyer.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import id.strade.android.buyer.model.Order

/**
 * Created by ARSnova on 20/12/2017.
 */
class OrderResponse{
    @SerializedName("orders")
    @Expose
    lateinit var orders: List<Order>
}