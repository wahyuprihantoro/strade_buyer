package id.strade.android.buyer.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import id.strade.android.buyer.model.User


/**
 * Created by wahyu on 22 October 2017.
 */
class ListUserResponse : BaseResponse() {
    @SerializedName("users")
    @Expose
    var users: List<User> = ArrayList()
}