package id.strade.android.buyer.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import id.strade.android.buyer.model.Order


class OrderResponse : BaseResponse() {
    @SerializedName("order")
    @Expose
    var user: Order? = null
}