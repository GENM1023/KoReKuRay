package jp.yitt.bluetoothlowenergytest;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

import org.threeten.bp.LocalDate;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by genm1023 on 8/31/16.
 */
public class MyApp extends Application{
    @Override
    public void onCreate(){
        super.onCreate();
        AndroidThreeTen.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfiguration);
        //Realm.deleteRealm(realmConfiguration);
    }
}
