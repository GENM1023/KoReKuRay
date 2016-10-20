package jp.yitt.bluetoothlowenergytest;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;

import org.apache.commons.lang.BooleanUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import jp.yitt.bluetoothlowenergytest.databinding.FragmentMeasurementBinding;
import jp.yitt.bluetoothlowenergytest.model.AreaData;
import jp.yitt.bluetoothlowenergytest.model.CubeData;
import jp.yitt.bluetoothlowenergytest.model.LengthData;
import jp.yitt.bluetoothlowenergytest.util.BluetoothUtil;

/**
 * Created by genm1023 on 8/31/16.
 */
public class MeasurementFragment extends Fragment{
    public static final String TAG = MeasurementFragment.class.getSimpleName();

    boolean switchTouched = false;
    FragmentMeasurementBinding binding;

    /* Bluetooth*/
    BluetoothUtil bluetoothUtil;

    /* 計測した値を保持する */
    ArrayAdapter<String> arrayAdapter;
    static List<String> dataList = new ArrayList<String>();
    /* 計測中の値の判定 */
    MeasurementType dataType;

    public static MeasurementFragment newInstance(){
        return new MeasurementFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        dataType = MeasurementType.INIT;

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

        dataList.clear();
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
                if(getView() != null && sts != null && !sts.equals(BluetoothUtil.AppState.BLE_UPDATE_VALUE))Snackbar.make(getView(),sts.toString(), Snackbar.LENGTH_LONG)
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
                        int rt = buff.getShort();
                        //計測距離viewに代入
                        //if cm/m/inch
                        //binding..setLength(String.valueOf(rt)+R.string.unit_metre);
                        binding.lengthTextView.setText(String.valueOf(rt));

                        //Switch Status from Airpressure
                        buff = ByteBuffer.wrap(bluetoothUtil.mRecvValue, 2, 4);
                        buff.order(ByteOrder.LITTLE_ENDIAN);
                        boolean sw = BooleanUtils.toBoolean(buff.getInt());
                        if(sw && !switchTouched){
                            onCliickedExSwitch();
                            switchTouched = true;
                        }else if(sw == false){
                            if(switchTouched){
                                switchTouched = false;
                            }
                        }
                        break;
                }
            }
        };

    }

    public void unitChange(View v){
        Log.d(TAG,"unitChange");
        //TODO Test Method 外部ボタンの代わり
        onCliickedExSwitch();

    }

    public void eraseDatas(View v){
        Log.d(TAG,"eraseDatas");
        dataList.clear();
        arrayAdapter.notifyDataSetChanged();
        dataType = MeasurementType.INIT;
        binding.saveButton.setEnabled(false);
        binding.eraseButton.setEnabled(false);

    }
    //DialogDataSavingBinding sbinding;

    public void saveDatas(final View v){
        Log.d(TAG,"saveDatas");
        final View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_data_saving, null);

        new AlertDialog.Builder(getActivity())
                .setTitle(R.string.savedialog_title)
                .setView(dialogView)
                .setPositiveButton(R.string.savedialog_saving,new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){

                        /* Realm */
                        final Realm realm = Realm.getDefaultInstance();

                        EditText editText = (EditText)dialogView.findViewById(R.id.savingNameEditText);

                        if(editText.getText().equals(null)){

                            Snackbar.make(getView(),R.string.nothing_input_text, Snackbar.LENGTH_LONG)
                                    .show();
                            return;
                        }
                        String name = editText.getText().toString();

                        switch (dataType){
                            case INIT:
                                NCMBObject obj = new NCMBObject("SaveObjectTest");
                                obj.put("user", "testUser");
                                obj.put("objectName", "initdummy");
                                obj.put("distance", "100mm");
                                obj.saveInBackground(new DoneCallback() {
                                    @Override
                                    public void done(NCMBException e) {
                                        if (e != null) {
                                            Log.d("NCMB_TAG", "失敗しました" + e);
                                            //エラー発生時の処理
                                        } else {
                                            Log.d("NCMB_TAG", "保存しました");
                                            //成功時の処理
                                        }
                                    }
                                });
                                break;
                            case LENGTH:
                                LengthData lengthData = new LengthData();
                                lengthData.setName(name);
                                lengthData.setLength(dataList.get(0));
                                lengthData.setTime("1234/23/43");
                                NCMBObject obj2 = new NCMBObject("LengthData");
                                obj2.put("user", "testUser");
                                obj2.put("objectName", name);
                                obj2.put("distance", dataList.get(0));
                                obj2.put("angle", 0);
                                obj2.saveInBackground(new DoneCallback() {
                                    @Override
                                    public void done(NCMBException e) {
                                        if (e != null) {
                                            Log.d("NCMB_TAG", "失敗しました" + e);
                                            //エラー発生時の処理
                                        } else {
                                            Log.d("NCMB_TAG", "保存しました");
                                            //成功時の処理
                                        }
                                    }
                                });
                             //   final RealmResults<LengthData> lengthDatas = realm.where(LengthData.class).findAll();
                              //  lengthDatas.size();

                                realm.beginTransaction();
                              //  realm.copyToRealm(lengthData);
                                //realm.copyToRealmOrUpdate(lengthData);
                                realm.commitTransaction();

                              //  lengthDatas.addChangeListener(new RealmChangeListener<RealmResults<LengthData>>() {
//                                    @Override
//                                    public void onChange(RealmResults<LengthData> element) {
//                                        Log.d(TAG,String.valueOf(lengthDatas.size()));
//
//                                    }
                               // });


                                break;
                            case AREA:
                                AreaData areaData = new AreaData();
                                areaData.setName(name);
                                areaData.setHeight(Double.valueOf(dataList.get(0)));
                                areaData.setWidth(Double.valueOf(dataList.get(1)));
                                realm.beginTransaction();
                                realm.copyToRealmOrUpdate(areaData);
                                realm.commitTransaction();
                                break;
                            case CUBE:
                                CubeData cubeData = new CubeData();
                                cubeData.setName(name);
                                cubeData.setHeight(Double.valueOf(dataList.get(0)));
                                cubeData.setWidth(Double.valueOf(dataList.get(1)));
                                cubeData.setLength(Double.valueOf(dataList.get(2)));
                                realm.beginTransaction();
                                realm.copyToRealmOrUpdate(cubeData);
                                realm.commitTransaction();
                                break;
                            case OTHER:
                                break;
                        }
                        Realm real = Realm.getDefaultInstance();
                      //  final RealmResults<LengthData> hoge = real.where(LengthData.class).findAll();
                     //   Log.d(TAG,hoge.toString());
                        //画面を破棄
                        getActivity().finish();

                    }
                })
                .setNegativeButton(R.string.savedialog_cancel,null)
                .show();





    }

    private void onCliickedExSwitch(){
        Log.d(TAG,"ExSwitchOnClicked");

        switch (dataType){
            case INIT:
                dataType = MeasurementType.LENGTH;
                binding.saveButton.setEnabled(true);
                binding.eraseButton.setEnabled(true);
                break;
            case LENGTH:
                dataType = MeasurementType.AREA;
                break;
            case AREA:
                dataType = MeasurementType.CUBE;
                break;
            case CUBE:
                //データは3個まででよいので
                //dataType = MeasurementType.OTHER;
                return;
            case OTHER:
                return;
        }
        //値をListに追加
        dataList.add(binding.lengthTextView.getText().toString());
        //更新通知
        arrayAdapter.notifyDataSetChanged();
        Log.d(TAG,"DataSetChanged:"+dataType.toString());

        if(getView() != null && dataType != null)Snackbar.make(getView(),R.string.measurement_added_item, Snackbar.LENGTH_LONG)
                .setAction(R.string.measurement_added_undo, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d(TAG,"DataSetUndo");
                        switch (dataType){
                            case INIT:
                                return;
                            case LENGTH:
                                dataType = MeasurementType.INIT;
                                binding.saveButton.setEnabled(false);
                                binding.eraseButton.setEnabled(false);
                                break;
                            case AREA:
                                dataType = MeasurementType.LENGTH;
                                break;
                            case CUBE:
                                dataType = MeasurementType.AREA;
                                break;
                            case OTHER:
                                dataType = MeasurementType.CUBE;
                                break;
                        }
                        dataList.remove(dataList.size()-1);
                        arrayAdapter.notifyDataSetChanged();


                    }
                })
                .show();




    }




}
