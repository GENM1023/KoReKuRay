package jp.yitt.bluetoothlowenergytest.util;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import android.os.Handler;
import android.os.Message;

/**
 * Created by genm1023 on 8/31/16.
 */
public class BluetoothUtil {
    //BLEスキャンタイムアウト
    private static final int SCAN_TIMEOUT = 20000;
    //接続対象のデバイス名
    private static final String DEVICE_NAME = "HyouRowGan00";
    /* UUIDs */
    //BlueNinja Motion sensor Service
    private static final String UUID_SERVICE_MSS = "00050000-6727-11e5-988e-f07959ddcdfb";
    //Motion sensor values.
    private static final String UUID_CHARACTERISTIC_VALUE = "00050001-6727-11e5-988e-f07959ddcdfb";
    //キャラクタリスティック設定UUID (加速度用に変更)
    private static final String UUID_CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb";
    //ログのTAG
    private static final String TAG = BluetoothUtil.class.getSimpleName();



    private enum BLEState {
        INIT,
        BLE_SCANNING,
        BLE_SCAN_FAILED,
        BLE_DEV_FOUND,
        BLE_SRV_FOUND,
        BLE_CHARACTERISTIC_NOT_FOUND,
        BLE_CONNECTED,
        BLE_DISCONNECTED,
        BLE_SRV_NOT_FOUND,
        BLE_READ_SUCCESS,
        BLE_NOTIF_REGISTERD,
        BLE_NOTIF_REGISTER_FAILED,
        BLE_WRITE_FALIED,
        BLE_WRITE,
        BLE_UPDATE_VALUE,
        BLE_CLOSED
    }

    /* メンバ変数 */
    private BluetoothManager mBtManager;
    private BluetoothAdapter mBtAdapter;
    private BluetoothGatt mGatt;
    private BluetoothGatt mBtGatt;
    private BluetoothGattCharacteristic mCharacteristic;

    private Handler mHandler;


    public BluetoothUtil(){
        //mBtManager = (BluetoothManager)getSystemService();

    }
    //初期状態
    private BLEState bleState = BLEState.INIT;

    //状態変更
    private void setStatus(BLEState state){
        Message msg = new Message();
        msg.what = bleState.ordinal();
        msg.obj = bleState.name();
        bleState = state;

    }


}
