package id.strade.android.buyer.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import id.strade.android.buyer.model.User



/**
 * Created by wahyu on 22 October 2017.
 * modified by ghozi on 22 October 2017
 * modified by rohmat on 25 October 2017
 */


class UserResponse {
    @SerializedName("status")
    @Expose
    var status: Boolean? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("user")
    @Expose
    var user: User? = null
    @SerializedName("token")
    @Expose
    var token: String? = null
}
