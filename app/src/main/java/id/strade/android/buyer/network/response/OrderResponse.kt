package id.strade.android.buyer.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import id.strade.android.buyer.model.Order
import id.strade.android.buyer.model.User



/**
 * Created by wahyu on 22 October 2017.
 * modified by ghozi on 22 October 2017
 * modified by rohmat on 25 October 2017
 */


class OrderResponse : BaseResponse() {
    @SerializedName("order")
    @Expose
    var user: Order? = null
}
