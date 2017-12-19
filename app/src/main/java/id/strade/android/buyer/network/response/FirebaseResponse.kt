package id.strade.android.buyer.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by wahyu on 27 November 2017.
 */
class FirebaseResponse {

    @SerializedName("multicast_id")
    @Expose
    var multicastId: Long = 0
    @SerializedName("success")
    @Expose
    var success: Int = 0
    @SerializedName("failure")
    @Expose
    var failure: Int = 0
    @SerializedName("canonical_ids")
    @Expose
    var canonicalIds: Int = 0
    @SerializedName("results")
    @Expose
    var results: List<Result>? = null

    inner class Result {

        @SerializedName("message_id")
        @Expose
        var messageId: String? = null

    }
}