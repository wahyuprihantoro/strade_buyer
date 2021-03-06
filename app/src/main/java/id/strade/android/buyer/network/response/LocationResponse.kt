package id.strade.android.buyer.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import id.strade.android.buyer.model.UserLocation

/**
 * Created by wahyu on 19 December 2017.
 */
class LocationResponse : BaseResponse() {
    @SerializedName("location")
    @Expose
    lateinit var location: UserLocation
}