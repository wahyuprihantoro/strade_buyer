package id.strade.android.buyer.network

import org.androidannotations.annotations.EBean
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by wahyu on 19 October 2017.
 * modified by ghozi on 22 October 2017
 */
@EBean
open class ApiClient {

    val BASE_URL: String = "http://10.0.3.2:8000/api/"

    fun <T> getService(service: Class<T>): T {
        return getRetrofit().create(service)
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
    }

}