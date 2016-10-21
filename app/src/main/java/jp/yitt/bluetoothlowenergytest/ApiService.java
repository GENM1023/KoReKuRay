package jp.yitt.bluetoothlowenergytest;

/**
 * Created by yaritakouhei on 2016/10/20.
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {
//    @POST("./")
//    Call<FurnitureRequest> createRequest(@Body FurnitureRequest fr);
  //  Call<RandomUserDemo> apiDemo();
//    @Headers({
//            "Accept: application/json",
//            "Content-type: application/json"
//    })
//    //@POST("./hoge")
//    Observable<Void> createUser(@Body FurnitureRequest body);
    @GET
    Call<RandomUserDemo> cretateRequest(@Url String url);
    //クエリパラメータを引数で設定、引数にnullを入れるとパラメータは付与されなくなる
//    Call<List<RandomUserDemo>> getTasks(
//            @Query("name") String name
//
//    );
//    Call<FurnitureRequest> createRequest();
//    Call<RandomUserDemo> apiDemo();
}
