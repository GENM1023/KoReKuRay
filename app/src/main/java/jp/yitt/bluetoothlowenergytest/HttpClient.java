package jp.yitt.bluetoothlowenergytest;

import java.io.IOException;

import okhttp3.*;

/**
 * Created by genm1023 on 8/30/16.
 */
public class HttpClient {
    OkHttpClient client = new OkHttpClient();

    public String getByOkHttp() throws IOException {
        Request request = new Request.Builder()
                .url("https://qiita.com/api/v2/items")
                .get()
                .build();

        //非同期で実行
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
