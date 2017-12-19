package id.strade.android.buyer

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.google.gson.Gson
import id.strade.android.buyer.adapter.SellerAdapter
import id.strade.android.buyer.model.Store
import id.strade.android.buyer.model.User
import id.strade.android.buyer.network.ApiClient
import id.strade.android.buyer.network.response.StoreByCategoryResponse
import id.strade.android.buyer.network.service.StoreByCategoryService
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.Bean
import org.androidannotations.annotations.EActivity
import org.androidannotations.annotations.ViewById
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

@EActivity(R.layout.activity_seller_list)
open class SellerListActivity : AppCompatActivity() {

    @ViewById
    lateinit var rv: RecyclerView
    @Bean
    lateinit var apiClient: ApiClient

    @AfterViews
    fun init() {
        var id = intent.getIntExtra("id", 0)
        var stores: ArrayList<Store> = ArrayList()
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = SellerAdapter(this, stores)

        apiClient.getService(StoreByCategoryService::class.java).store_by_category(id).enqueue(object : Callback<StoreByCategoryResponse> {
            override fun onResponse(call: Call<StoreByCategoryResponse>, response: Response<StoreByCategoryResponse>) {
                if (response.isSuccessful) {
                    var resp = response.body()
                    if (resp != null && resp.status!!) {
                        Log.d("wahyu", Gson().toJson(resp))
                        var users: ArrayList<User> = resp.users!!
                        users.forEach {
                            it.store?.address = it.location.currentAddress
                            it.store?.distance = it.id?.minus(Random().nextDouble())!!
                            stores.add(it.store!!)
                        }
                        rv.adapter = SellerAdapter(applicationContext, stores)
                        Toast.makeText(applicationContext, "Berhasil", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(applicationContext, resp?.message, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(applicationContext, "ada kesalahan pada server", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<StoreByCategoryResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }
        })
        if (supportActionBar != null) {
            if (id == 1) {
                supportActionBar!!.title = "Jajanan"
            } else if (id == 2) {
                supportActionBar!!.title = "Minuman"
            } else if (id == 3) {
                supportActionBar!!.title = "Makanan"
            } else if (id == 4) {
                supportActionBar!!.title = "Jasa"
            } else if (id == 5) {
                supportActionBar!!.title = "Perabotan"
            } else if (id == 6) {
                supportActionBar!!.title = "Mainan"
            } else if (id == 7) {
                supportActionBar!!.title = "Sayur dan Buah"
            }
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }
//        val sellers: ArrayList<Store> = ArrayList()
//        sellers.add(Store(imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQylvZ7R5ykRP9MrA34pSOaBICvEZkCaBB5bGxYbTR7hskpLX4A", status = "Buka", name = "Sayur Bang Ghozi", distance = 1.32, address = "Jalan Haji Kodja No 58"))
//        sellers.add(Store(imageUrl = "http://www.teropongbisnis.com/wp-content/uploads/2014/05/1.Menggiurkannya-Pedagang-Sayur-Keliling-2.jpg", status = "Buka", name = "Sayur Enak dan Murah", distance = 2.17, address = "Jalan Pala kali No 5"))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
