package id.strade.android.buyer.homefragment

import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import id.strade.android.buyer.R
import id.strade.android.buyer.network.ApiClient
import id.strade.android.buyer.network.response.OrderResponse
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.Bean
import org.androidannotations.annotations.EFragment
import org.androidannotations.annotations.ViewById
import id.strade.android.buyer.network.service.OrderService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import id.strade.android.buyer.network.response.BaseResponse
import id.strade.android.buyer.adapter.OrderAdapter
import id.strade.android.buyer.network.response.ListOrderResponse

@EFragment(R.layout.fragment_request)
open class RequestFragment : Fragment() {
    @ViewById
    lateinit var rv: RecyclerView
    @Bean
    lateinit var apiClient: ApiClient

    @AfterViews
    fun init() {
        rv.layoutManager = LinearLayoutManager(context)
        apiClient.getService(OrderService::class.java).get_order().enqueue(object: Callback<ListOrderResponse>{
            override fun onResponse(call: Call<ListOrderResponse>, response: Response<ListOrderResponse>) {
                if (response.isSuccessful) {
                    val resp = response.body()
                    val adapter = OrderAdapter(context, resp!!.orders)
                    rv.adapter = adapter
                } else if (response is HttpException) {
                    if (response.code() == 401) {
                        Toast.makeText(context, "Sesi anda telah berakhir, silakan login kembali.", Toast.LENGTH_SHORT).show()
                        activity.finish()
                    } else {
                        val raw = response.response().errorBody()?.charStream()?.readText()
                        val resp = Gson().fromJson(raw, BaseResponse::class.java)
                        Toast.makeText(context, resp.message, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Log.d("wahyu error", response.body().toString())
                    Toast.makeText(context, "Terjadi kesalahan pada koneksi.", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<ListOrderResponse>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }


}