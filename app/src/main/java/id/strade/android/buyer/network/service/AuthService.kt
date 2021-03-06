package id.strade.android.buyer.network.service

import id.strade.android.buyer.network.response.UserResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by wahyu on 22 October 2017.
 * Modified by ghozi on 22 October 2017.
 */
interface AuthService {
    @FormUrlEncoded
    @POST("login")
    fun login(@Field("username") username: String,
              @Field("password") password: String,
              @Field("role") role: String): Call<UserResponse>

    @FormUrlEncoded
    @POST("register")
    fun register(@Field("username") username: String,
                 @Field("name") name: String,
                 @Field("phone_number") phoneNumber: String,
                 @Field("password") password: String,
                 @Field("role") role: String): Call<UserResponse>
}