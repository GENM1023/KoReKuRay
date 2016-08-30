package jp.yitt.bluetoothlowenergytest;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

/**
 * Created by genm1023 on 8/31/16.
 */
public class MyApp extends Application{
    @Override
    public void onCreate(){
        super.onCreate();
        AndroidThreeTen.init(this);

    }
}
