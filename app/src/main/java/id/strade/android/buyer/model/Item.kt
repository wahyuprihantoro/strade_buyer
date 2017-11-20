package id.strade.android.buyer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by ARSnova on 20/11/2017.
 */
class Item(s:String,i:Int){
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("price")
    @Expose
    var price: Int? = null

    init {
        name=s
        price=i
    }
}