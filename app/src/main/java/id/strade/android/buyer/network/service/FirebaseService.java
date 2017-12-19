package id.strade.android.buyer.network.service;

import id.strade.android.buyer.network.request.FirebaseRequest;
import id.strade.android.buyer.network.response.FirebaseResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by wahyu on 27 November 2017.
 */

public interface FirebaseService {
    @Headers({
            "Accept: application/json",
            "Authorization:key=AIzaSyAZzXvMzFB9glEzdYhTvimyWeiOySlnSPs"
    })
    @POST("https://fcm.googleapis.com/fcm/send")
    Call<FirebaseResponse> push(@Header("Authorization") String auth, @Body FirebaseRequest firebaseRequest);
}
