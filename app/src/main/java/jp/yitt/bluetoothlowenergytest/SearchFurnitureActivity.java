package jp.yitt.bluetoothlowenergytest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yaritakouhei on 2016/10/13.
 */
public class SearchFurnitureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_search_furniture);
          //Button returnButton = (Button) findViewById(R.id.return_button);
          //returnButton.setOnClickListener(new View.OnClickListener() {
//              @Override
//              public void onClick(View v) {
//                  finish();
//              }
//          });
        Intent intent = getIntent();
        String searchName   = intent.getStringExtra("name");
        String searchLength = intent.getStringExtra("length");
        Log.d("画面遷移テスト", searchName + " " + searchLength);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                //header設定
                Request request = original.newBuilder()
                        .header("Accept", "application/json")
                        .method(original.method(), original.body())
                        .build();

                Response response = chain.proceed(request);

                return response;
            }
        });

        //ログ出力設定
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        httpClient.addInterceptor(logging);

        //クライアント生成
        OkHttpClient client = httpClient.build();
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("http://10.222.13.109:3000")
                .baseUrl("http://192.168.1.6:3000/")
                .addConverterFactory(GsonConverterFactory.create(gson))//Gsonの使用
                .client(client)//カスタマイズしたokhttpのクライアントの設定
                .build();
        //Interfaceから実装を取得
        ApiService API = retrofit.create(ApiService.class);
        FurnitureRequest fr = new FurnitureRequest(searchName, searchLength);
        String encodedResult = "たんす";
        try {
             encodedResult = URLEncoder.encode(searchName, "UTF-8");
        }catch(Exception e){

        }
        //実行
        API.cretateRequest("/?name=" + encodedResult + "&width=" + searchLength).enqueue(new Callback<RandomUserDemo>() {
            @Override
            public void onResponse(Call<RandomUserDemo> call, retrofit2.Response<RandomUserDemo> response) {

                if (response.isSuccessful()) {
                    Log.d("RETROFIT_TEST", "isSuccessful");

                    //ここでリスト表示
                    //通信結果をオブジェクトで受け取る
                    final RandomUserDemo demo = response.body();
                   // renderListView(demo);
//                    List<FurnitureListItem> flist = new ArrayList<FurnitureListItem>();
//                    for(int i = 0 ; i < demo.name.size(); i++ ){
//                        FurnitureListItem flistItem = new FurnitureListItem();
//                        flistItem.setName(demo.name.get(i));
//                        flistItem.setPrice(demo.price.get(i));
//                        flistItem.setUrl(demo.url.get(i));
//                        flist.add(flistItem);
//                    }
                    //adapterのインスタンスを作成
                   // ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
                    ListView list = (ListView) findViewById(R.id.ListViewMain);
                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(SearchFurnitureActivity.this, android.R.layout.simple_list_item_1);
                    adapter.addAll(demo.name);
                   // final FurnitureListAdapter adapter = new FurnitureListAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, flist);

                    // final FurnitureListAdapter adapter = new FurnitureListAdapter(SearchFurnitureActivity.this, android.R.layout.simple_list_item_1);
//                    Log.d("FURNITURE_ACTIVITY_TEST", list.getParent().toString());
//                    Log.d("FURNITURE_ACTIVITY_TEST", list.toString());
                    //adapter.getView(0, list), (ViewGroup) list.getParent());

                    //ListView list = (ListView) findViewById(R.id.ListViewMain);
                    list.setAdapter(adapter);

                    // リスト項目がクリックされた時の処理
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView parent, View view, int position, long id) {
                            ArrayList<String> url =  (ArrayList)demo.url;
                            //String strData = adapter.getItem(position);
                            //FurnitureListItem strData = adapter.getItem(position);
                                Uri uri = Uri.parse(url.get(position));
                                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                                startActivity(intent);
                        }
                    });


                } else {
                    //通信が成功したが、エラーcodeが返ってきた場合はこちら
                    Log.d("RETROFIT_TEST", "error_code" + response.code());
                }
            }

            @Override
            public void onFailure(Call<RandomUserDemo> call, Throwable t) {
                //通信が失敗した場合など
                Log.d("RETROFIT_TEST", "onFailure", t);
            }
        });

        API.cretateRequest("/?" + encodedResult + "&" + searchLength).enqueue(new Callback<RandomUserDemo>() {
            @Override
            public void onResponse(Call<RandomUserDemo> call, retrofit2.Response<RandomUserDemo> response) {
                RandomUserDemo demo = response.body();
            }

            @Override
            public void onFailure(Call<RandomUserDemo> call, Throwable t) {
            }
        });
    }

    private void renderListView(RandomUserDemo demo){
        ListView list = (ListView) findViewById(R.id.ListViewMain);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, demo.name);
       // final FurnitureListAdapter adapter = new FurnitureListAdapter(this,android.R.layout.simple_list_item_1);
        Log.d("FURNITURE_ACTIVITY_TEST", list.getParent().toString());
        Log.d("FURNITURE_ACTIVITY_TEST", list.toString());
        //adapter.getView(0, list, (ViewGroup) list.getParent());

        list.setAdapter(adapter);

        // リスト項目がクリックされた時の処理
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                //String strData = adapter.getItem(position);
                 //FurnitureListItem strData = adapter.getItem(position);

            //    Intent intent = new Intent();

                switch (position) {
                    case 0:
                       // intent.setClass(MainActivity.this, SubActivity_A.class);
                        Log.d("LIST_VIEW_TEST", "いっこめクリック");
                        break;
                    case 1:
//                        intent.setClass(MainActivity.this, SubActivity_B.class);
                        Log.d("LIST_VIEW_TEST", "にこめクリック");
                        break;
                }
            //    intent.putExtra("SELECTED_DATA", strData);
             //   startActivity(intent);
            }
        });
    }

}
