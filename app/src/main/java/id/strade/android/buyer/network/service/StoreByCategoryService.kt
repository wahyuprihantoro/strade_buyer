package id.strade.android.buyer.network.service

import id.strade.android.buyer.network.response.StoreByCategoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by ARSnova on 19/12/2017.
 */
interface StoreByCategoryService {
    @GET("stores/{id}")
    fun store_by_category(@Path("id") id: Int): Call<StoreByCategoryResponse>

}