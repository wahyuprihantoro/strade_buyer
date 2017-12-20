package id.strade.android.buyer.network

import id.strade.android.buyer.storage.Prefs
import okhttp3.OkHttpClient
import org.androidannotations.annotations.Bean
import org.androidannotations.annotations.EBean
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by wahyu on 19 October 2017.
 * modified by ghozi on 22 October 2017
 */
@EBean
open class ApiClient {

    val BASE_URL: String = "http://10.0.3.2:8000/api/"

    @Bean
    lateinit var prefs: Prefs

    fun <T> getService(service: Class<T>): T {
        return getRetrofit().create(service)
    }

//    fun getRetrofit(): Retrofit {
//        return Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create()).build()
//    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(provideOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    private fun provideOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                    .header("Content-Type", "application/json")
                    .header("Authorization", "jwt " + prefs.token)
                    .method(original.method(), original.body())
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        httpClient.readTimeout(10, TimeUnit.SECONDS)
        return httpClient.build()
    }

}