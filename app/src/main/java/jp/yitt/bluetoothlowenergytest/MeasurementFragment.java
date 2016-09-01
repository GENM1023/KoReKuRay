package jp.yitt.bluetoothlowenergytest;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.apache.commons.lang.BooleanUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

import jp.yitt.bluetoothlowenergytest.databinding.FragmentMeasurementBinding;
import jp.yitt.bluetoothlowenergytest.util.BluetoothUtil;

/**
 * Created by genm1023 on 8/31/16.
 */
public class MeasurementFragment extends Fragment{
    public static final String TAG = MeasurementFragment.class.getSimpleName();
    FragmentMeasurementBinding binding;
    //LengthDataViewModel lengthDataViewModel;


    /* Bluetooth*/
    BluetoothUtil bluetoothUtil;

    /* 計測した値を保持する */
    ArrayAdapter<String> arrayAdapter;
    static List<String> dataList = new ArrayList<String>();
    /* 計測中の値の判定 */
    MeasurementType.Type dataType = MeasurementType.Type.LENGTH;

    public static MeasurementFragment newInstance(){
        return new MeasurementFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);




    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.d(TAG,"onCreateView");

        bluetoothInitialize();
        bluetoothHandler();

        return inflater.inflate(R.layout.fragment_measurement, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        binding = FragmentMeasurementBinding.bind(getView());
        binding.setFragment(this);

    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");

        //画面の点灯制御 常にON 自動で解除
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setAdapter();


        //状態をINITに変更
        bluetoothUtil.setStatus(BluetoothUtil.AppState.INIT);
        //接続処理
        bluetoothUtil.connectBLE();


    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

        //BLE切断処理
        bluetoothUtil.disconnectBLE();

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        dataList.clear();
    }

    private void setAdapter(){
        Log.d(TAG,"setAdapter");

        arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dataList);
        binding.measuredList.setAdapter(arrayAdapter);

    }

    private void bluetoothInitialize(){
        Log.d(TAG,"bluetoothInitialize");
        //Bluetooth Initialize
        bluetoothUtil = new BluetoothUtil(getContext());
        /* Bluetooth関連の初期化 */
        bluetoothUtil.mBtManager = (BluetoothManager)getContext().getSystemService(Context.BLUETOOTH_SERVICE);
        bluetoothUtil.mBtAdapter = bluetoothUtil.mBtManager.getAdapter();
        if ((bluetoothUtil.mBtAdapter == null) || !bluetoothUtil.mBtAdapter.isEnabled()) {
            Toast.makeText(getActivity().getApplicationContext(), "Warning: Bluetooth Disabled.", Toast.LENGTH_SHORT).show();
            getActivity().finish();
        }


    }

    private void bluetoothHandler(){
        bluetoothUtil.mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                BluetoothUtil.AppState sts = BluetoothUtil.AppState.values()[msg.what];

                //TO DEBUGING
                if(getView() != null && sts != null)Snackbar.make(getView(),sts.toString(), Snackbar.LENGTH_LONG)
                        .show();

                Log.d(TAG, "Handle: " + sts.toString());
                switch (sts) {
                    case INIT:

                        break;
                    case BLE_SCAN_FAILED:
                    case BLE_CLOSED:
                    case BLE_DISCONNECTED:
                    case BLE_SRV_NOT_FOUND:
                    case BLE_NOTIF_REGISTER_FAILED:
                        break;
                    case BLE_SCANNING:
                        binding.statusTitleTextView.setText(R.string.measurement_connecting);
                        break;
                    case BLE_CONNECTED:
                        binding.statusTitleTextView.setText(R.string.measurement_start);

                        //リアルタイム値受信をアクティブ
                        bluetoothUtil.enableBLENotification();

                        break;
                    case BLE_WRITE:
                        break;
                    case BLE_UPDATE_VALUE:
                        binding.statusTitleTextView.setText(R.string.measurement_now);

                        //Distance(Length) from Temperature
                        ByteBuffer buff;
                        buff = ByteBuffer.wrap(bluetoothUtil.mRecvValue, 0, 2);
                        buff.order(ByteOrder.LITTLE_ENDIAN);
                        short rt = buff.getShort();
                        //計測距離viewに代入
                        //if cm/m/inch
                        //binding..setLength(String.valueOf(rt)+R.string.unit_metre);
                        binding.lengthTextView.setText(rt);

                        //Switch Status from Airpressure
                        buff = ByteBuffer.wrap(bluetoothUtil.mRecvValue, 2, 4);
                        buff.order(ByteOrder.LITTLE_ENDIAN);
                        boolean sw = BooleanUtils.toBoolean(buff.getInt());
                        if(sw){
                            onCliickedExSwitch();
                        }

                        break;
                }
            }
        };

    }
    public void unitChange(View v){
        Log.d(TAG,"unitChange");
        //Test Method 外部ボタンの代わり
        onCliickedExSwitch();

    }

    private void onCliickedExSwitch(){
        Log.d(TAG,"ExSwitchOnClicked");
        //値をListに追加
        dataList.add(binding.lengthTextView.getText().toString());
        //更新通知
        arrayAdapter.notifyDataSetChanged();
        Log.d(TAG,"DataSetChanged");





    }





}
