package id.strade.android.buyer.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import id.strade.android.buyer.model.User

/**
 * Created by ARSnova on 19/12/2017.
 */

class StoreByCategoryResponse {
    @SerializedName("status")
    @Expose
    var status: Boolean? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("users")
    @Expose
    var users: ArrayList<User>? = null
}