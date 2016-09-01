package jp.yitt.bluetoothlowenergytest;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import jp.yitt.bluetoothlowenergytest.databinding.FragmentMeasurementBinding;
import jp.yitt.bluetoothlowenergytest.model.LengthData;
import jp.yitt.bluetoothlowenergytest.util.BluetoothUtil;
import jp.yitt.bluetoothlowenergytest.viewmodel.LengthDataViewModel;

/**
 * Created by genm1023 on 8/31/16.
 */
public class MeasurementFragment extends Fragment{
    public static final String TAG = MeasurementFragment.class.getSimpleName();
    FragmentMeasurementBinding binding;
    LengthDataViewModel lengthDataViewModel;

    /* Bluetooth*/
    BluetoothUtil bluetoothUtil;




    public static MeasurementFragment newInstance(){
        return new MeasurementFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.d(TAG,"onCreateView");

        return inflater.inflate(R.layout.fragment_measurement, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        binding = FragmentMeasurementBinding.bind(getView());
        // TODO
        lengthDataViewModel = new LengthDataViewModel(new LengthData());
        binding.setViewmodel(lengthDataViewModel);

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


        //Bluetooth Initialize
        bluetoothUtil = new BluetoothUtil(getContext());
        /* Bluetooth関連の初期化 */
        bluetoothUtil.mBtManager = (BluetoothManager)getContext().getSystemService(Context.BLUETOOTH_SERVICE);
        bluetoothUtil.mBtAdapter = bluetoothUtil.mBtManager.getAdapter();
        if ((bluetoothUtil.mBtAdapter == null) || !bluetoothUtil.mBtAdapter.isEnabled()) {
            Toast.makeText(getActivity().getApplicationContext(), "Warning: Bluetooth Disabled.", Toast.LENGTH_SHORT).show();
            getActivity().finish();
        }
        bluetoothUtil.mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                BluetoothUtil.AppState sts = BluetoothUtil.AppState.values()[msg.what];
                switch (sts) {
                    case INIT:
                    case BLE_SCAN_FAILED:
                    case BLE_CLOSED:
                    case BLE_DISCONNECTED:
                    case BLE_SRV_NOT_FOUND:
                    case BLE_NOTIF_REGISTER_FAILED:
                    case BLE_SCANNING:
                    case BLE_CONNECTED:
                    case BLE_WRITE:
                    case BLE_UPDATE_VALUE:
                        break;
                }
            }
        };

        //test view
        lengthDataViewModel.setLength("ほげ");


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
    }

    private void bleInit(){

    }
}
