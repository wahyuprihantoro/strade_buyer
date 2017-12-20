package id.strade.android.buyer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by ARSnova on 20/12/2017.
 */
class OrderItem : Serializable {
    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("count")
    @Expose
    var count: Int = 0
    @SerializedName("item")
    @Expose
    lateinit var product: Product
}