package id.strade.android.buyer

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import id.strade.android.buyer.adapter.ProductAdapter
import id.strade.android.buyer.model.Product
import id.strade.android.buyer.model.User
import id.strade.android.buyer.network.ApiClient
import id.strade.android.buyer.network.request.FirebaseRequest
import id.strade.android.buyer.network.request.OrderRequest
import id.strade.android.buyer.network.response.FirebaseResponse
import id.strade.android.buyer.network.response.OrderResponse
import id.strade.android.buyer.network.service.FirebaseService
import id.strade.android.buyer.network.service.OrderService
import kotlinx.android.synthetic.main.activity_product_list.*
import org.androidannotations.annotations.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@EActivity(R.layout.activity_product_list)
open class ProductListActivity : AppCompatActivity() {

    @ViewById
    lateinit var rv: RecyclerView
    @ViewById
    lateinit var addressView: EditText
    @ViewById
    lateinit var noteView: EditText
    lateinit var dialog: ProgressDialog

    @Extra
    lateinit var seller: User

    @Bean
    lateinit var apiClient: ApiClient

    private fun showDialog() {
        dialog.run {
            setTitle(null)
            setMessage("Loading...")
            show()
        }
    }

    private lateinit var adapter: ProductAdapter

    @AfterViews
    fun init() {
        if (supportActionBar != null) {
            supportActionBar!!.title = "Sayur Bang Ghozi"
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }
        dialog = ProgressDialog(this)
        var products: ArrayList<Product> = ArrayList()
        products.add(Product(id = 1, name = "Kubis", price = 10000.0, imageUrl = "http://10.0.3.2:8000/media/image/Manfaat-dan-Khasiat-Kubis.jpg"))
        products.add(Product(id = 2, name = "Jengkol", price = 20000.0, imageUrl = "http://10.0.3.2:8000/media/image/jengkol.jpg"))
        rv.layoutManager = LinearLayoutManager(this)
        adapter = ProductAdapter(this, products)
        rv.adapter = adapter

    }


    @Click
    fun submit() {
        val address = address_view.text.toString()
        val note = note_view.text.toString()
        val request = OrderRequest()
        request.address = address
        request.note = note
        request.latitude = -7.43604955
        request.longitude = 110.68609715
        request.sellerId = seller.id!!.toInt()
        request.productIds = adapter.getProductIds()
        apiClient.getService(OrderService::class.java).order(request).enqueue(object : Callback<OrderResponse> {
            override fun onFailure(call: Call<OrderResponse>?, t: Throwable?) {
                Toast.makeText(applicationContext, "gagal membuat orderan", Toast.LENGTH_SHORT).show()
                Log.d("wahyu h", t?.message)
            }

            override fun onResponse(call: Call<OrderResponse>?, response: Response<OrderResponse>) {
                if (response.isSuccessful) {
                    var resp = response.body()
                    if (resp != null && resp.status) {
                        Log.d("wahyu", Gson().toJson(resp))
                        Toast.makeText(applicationContext, "Berhasil membuat orderan", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(applicationContext, resp?.message, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(applicationContext, "gagal membuat orderan", Toast.LENGTH_SHORT).show()
                }
            }

        })
//        sendFirebaseNotification()
    }

    private fun sendFirebaseNotification() {
        val request = FirebaseRequest()
        request.to = "eCQJ4NxVqOc:APA91bGlcDmSJRC6FaA-HyZgIYaRH9JFw0JAPGaRf5zAykWRJ8qybAfkshT700bW5b9YD6up5XUrPrkA03mBBgyk2CV1CZ997V53a4dfO7VmyEbsYHJom2nFj759_wZ29SZ2YZmSysQh"
        request.data!!.message = "Ada pesanan baru: Jengkol 1, Kubis 1"
        apiClient.getService(FirebaseService::class.java).push("key=AIzaSyAZzXvMzFB9glEzdYhTvimyWeiOySlnSPs", request).enqueue(object : Callback<FirebaseResponse> {
            override fun onResponse(call: Call<FirebaseResponse>?, response: Response<FirebaseResponse>?) {
                Toast.makeText(applicationContext, "Berhasil membuat pesanan", Toast.LENGTH_SHORT).show()
                if (response != null) {
                    Log.d("wahyu", Gson().toJson(response.body()))
                    Log.d("wahyu1", response.message())
                    Log.d("wahyu1", response.raw().toString())
                }
                finish()
            }

            override fun onFailure(call: Call<FirebaseResponse>?, t: Throwable?) {
                Toast.makeText(applicationContext, "Gagal", Toast.LENGTH_SHORT).show()
                if (t != null) {
                    Log.d("wahyu", t.message)
                }
            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
