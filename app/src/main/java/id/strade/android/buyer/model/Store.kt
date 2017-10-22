package id.strade.android.buyer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by wahyu on 22 October 2017.
 * modified by ghozi on 22 October 2017
 */
class Store {
    @SerializedName("id")
    @Expose
    var id: Long? = null
    @SerializedName("status")
    @Expose
    var status: Long? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("category")
    @Expose
    var category: Long? = null
    @SerializedName("open_time")
    @Expose
    var openTime: String? = null
    @SerializedName("close_time")
    @Expose
    var closeTime: String? = null
    @SerializedName("image_url")
    @Expose
    var imageUrl: String? = null
}