package id.strade.android.buyer.model

/**
 * Created by ARSnova on 25/11/2017.
 */
class Category(title:String,url:String,detail:String){
    var title: String? = null
    var url_image: String? = null
    var detail: String? = null

    init{
        this.title=title
        url_image = url
        this.detail = detail
    }
}
