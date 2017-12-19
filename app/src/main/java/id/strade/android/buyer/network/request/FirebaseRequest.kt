package id.strade.android.buyer.network.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by wahyu on 27 November 2017.
 */
class FirebaseRequest {
    @SerializedName("to")
    @Expose
    var to: String? = null
    @SerializedName("data")
    @Expose
    var data: Data? = Data()

    inner class Data {

        @SerializedName("message")
        @Expose
        var message: String? = ""

    }
}