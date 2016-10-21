package jp.yitt.bluetoothlowenergytest;

/**
 * Created by yaritakouhei on 2016/10/20.
 */

import android.database.Observable;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {
    @Headers({
            "Accept: application/json",
            "Content-type: application/json"
    })
    @POST("./hoge")
    Observable<Void> createUser(@Body FurnitureRequest body);
    @GET("./")
    Call<RandomUserDemo> apiDemo();
}
