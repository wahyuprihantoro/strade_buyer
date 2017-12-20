package id.strade.android.buyer.network.service

import id.strade.android.buyer.network.response.ListUserResponse
import id.strade.android.buyer.network.response.LocationResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by wahyu on 19 December 2017.
 */
interface UserService {
    @FormUrlEncoded
    @POST("user/location")
    fun updateLocation(@Field("latitude") latitude: Double,
                       @Field("longitude") longitude: Double): Call<LocationResponse>

    @GET("users")
    fun getUsers(): Call<ListUserResponse>
}