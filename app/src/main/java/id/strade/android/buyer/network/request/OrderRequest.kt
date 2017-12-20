package id.strade.android.buyer.network.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by wahyu on 20 December 2017.
 */
class OrderRequest {

    @SerializedName("latitude")
    @Expose
    var latitude: Double = 0.0
    @SerializedName("longitude")
    @Expose
    var longitude: Double = 0.0
    @SerializedName("product_ids")
    @Expose
    var productIds: List<Int>? = null
    @SerializedName("seller_id")
    @Expose
    var sellerId: Int = 0
    @SerializedName("note")
    @Expose
    var note: String? = null
    @SerializedName("address")
    @Expose
    var address: String? = null

}