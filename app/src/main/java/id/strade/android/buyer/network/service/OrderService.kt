package id.strade.android.buyer.network.service

import id.strade.android.buyer.network.response.OrderResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by wahyu on 27 November 2017.
 */
interface OrderService{
    @GET("orders")
    fun get_order(): Call<OrderResponse>
}