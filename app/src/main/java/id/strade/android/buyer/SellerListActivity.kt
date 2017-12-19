package id.strade.android.buyer

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import id.strade.android.buyer.adapter.SellerAdapter
import id.strade.android.buyer.model.Store
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EActivity
import org.androidannotations.annotations.ViewById

@EActivity(R.layout.activity_seller_list)
open class SellerListActivity : AppCompatActivity() {

    @ViewById
    lateinit var rv: RecyclerView

    @AfterViews
    fun init() {
        if (supportActionBar != null) {
            supportActionBar!!.title = "Sayur dan Buah"
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }
        val sellers: ArrayList<Store> = ArrayList()
        sellers.add(Store(imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQylvZ7R5ykRP9MrA34pSOaBICvEZkCaBB5bGxYbTR7hskpLX4A", status = "Buka", name = "Sayur Bang Ghozi", distance = 1.32, address = "Jalan Haji Kodja No 58"))
        sellers.add(Store(imageUrl = "http://www.teropongbisnis.com/wp-content/uploads/2014/05/1.Menggiurkannya-Pedagang-Sayur-Keliling-2.jpg", status = "Buka", name = "Sayur Enak dan Murah", distance = 2.17, address = "Jalan Pala kali No 5"))
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = SellerAdapter(this, sellers)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
