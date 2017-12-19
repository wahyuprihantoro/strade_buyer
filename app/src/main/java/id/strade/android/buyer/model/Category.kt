package id.strade.android.buyer.model

/**
 * Created by ARSnova on 25/11/2017.
 */
class Category(title:String,url:String,id:Int){
    var title: String? = null
    var url_image: String? = null
    var id: Int? =null
    init{
        this.title=title
        url_image = url
        this.id = id
    }
}
