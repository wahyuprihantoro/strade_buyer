package id.strade.android.buyer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * Created by wahyu on 22 October 2017.
 * modified by ghozi on 22 October 2017
 */
class Store(imageUrl: String, status: String, name: String, address: String, distance: Double) : Serializable {
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
    @SerializedName("current_address")
    @Expose
    var address: String = ""
    @SerializedName("current_distance")
    @Expose
    var distance: Double = 0.0
    @SerializedName("status_full")
    @Expose
    var statusStr: String = "BUKA"

    init {
        this.imageUrl = imageUrl
        this.statusStr = status
        this.name = name
        this.address = address
        this.distance = distance
    }
}