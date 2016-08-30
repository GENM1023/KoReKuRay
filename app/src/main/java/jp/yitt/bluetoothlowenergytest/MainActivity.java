package jp.yitt.bluetoothlowenergytest;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jakewharton.threetenabp.AndroidThreeTen;

import okhttp3.*;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(android.R.id.content, MainFragment.newInstance()).commit();


        //setContentView(R.layout.activity_main);
        //mainBinding.setActivity(this);

        //okClient = new OkHttpClient();


        //mainBinding.actionLength.setSize(FloatingActionButton.SIZE_MINI);
        //mainBinding.actionLength.setIcon(R.drawable.scale);
        //mainBinding.actionArea.setSize(FloatingActionButton.SIZE_MINI);
        //mainBinding.actionArea.setIcon(R.drawable.area);


    }
    /*
    private void showResponse(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {


            }
        });
    }*/
}
