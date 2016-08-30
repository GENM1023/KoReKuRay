package jp.yitt.bluetoothlowenergytest;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class MeasurementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(android.R.id.content, MeasurementFragment.newInstance()).commit();
    }


    /*public void onClickButton(View v){
        mainBinding.button.setEnabled(false);
        Toast.makeText(v.getContext(),"HTTP開始",Toast.LENGTH_SHORT).show();
        Request request = new Request.Builder()
                .url("https://qiita.com/api/v2/items")
                .get()
                .build();

        okClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Main","onFailure"+ e.getMessage(), e);
                showResponse("失敗やで");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseBody = response.body().string();
                showResponse(responseBody);
            }
        });


        mainBinding.button.setEnabled(true);
    }*/
}
