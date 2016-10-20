package jp.yitt.bluetoothlowenergytest;

/**
 * Created by yaritakouhei on 2016/10/20.
 */
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("./")
    Call<RandomUserDemo> apiDemo();
}
