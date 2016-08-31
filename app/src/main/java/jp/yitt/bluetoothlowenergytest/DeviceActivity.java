package jp.yitt.bluetoothlowenergytest;

import android.bluetooth.BluetoothClass;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by genm1023 on 8/31/16.
 */
public class DeviceActivity extends AppCompatActivity {

    public static final String TAG = DeviceActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(android.R.id.content, DeviceFragment.newInstance()).commit();

    }

}
