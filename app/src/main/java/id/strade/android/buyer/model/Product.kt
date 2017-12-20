package id.strade.android.buyer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * Created by wahyu on 18 November 2017.
 */
class Product(name: String, imageUrl: String, price: Double, id: Int) : Serializable {
    @SerializedName("id")
    @Expose
    var id: Int = id
    @SerializedName("name")
    @Expose
    var name: String = name
    @SerializedName("price")
    @Expose
    var price: Double = price
    @SerializedName("image_url")
    @Expose
    var imageUrl: String = imageUrl

}