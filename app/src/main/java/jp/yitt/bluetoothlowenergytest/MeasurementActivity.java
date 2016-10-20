package jp.yitt.bluetoothlowenergytest;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.nifty.cloud.mb.core.NCMB;

//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.Request;
//import okhttp3.Response;

public class MeasurementActivity extends AppCompatActivity {
    public static final String APP_KEY    = "5857106a4890ccae8bc75eb78ed808bd307ec3ef65aedd7ca8cd36db383c74da";
    public static final String CLIENT_KEY = "c1e90372dca02afe782c2753ad5e62024d812d78d1a61ad77b2fe820af708164";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NCMB.initialize(this, APP_KEY, CLIENT_KEY);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(android.R.id.content, MeasurementFragment.newInstance()).commit();
    }

}
