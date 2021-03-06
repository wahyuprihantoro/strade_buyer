package id.strade.android.buyer.network.service

import id.strade.android.buyer.network.response.OrderResponse
import retrofit2.Call
import retrofit2.http.GET

import id.strade.android.buyer.network.request.OrderRequest
import id.strade.android.buyer.network.response.ListOrderResponse
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by wahyu on 27 November 2017.
 */

interface OrderService{
    @GET("orders")
    fun get_order(): Call<ListOrderResponse>

    @POST("orders")
    fun order(@Body request: OrderRequest): Call<OrderResponse>

}