package jp.yitt.bluetoothlowenergytest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import io.realm.Realm;
import jp.yitt.bluetoothlowenergytest.databinding.FragmentMainBinding;
import jp.yitt.bluetoothlowenergytest.model.LengthData;

/**
 * Created by genm1023 on 8/31/16.
 */
public class MainFragment extends Fragment {
    public static final String TAG = MainFragment.class.getSimpleName();
    FragmentMainBinding binding;
    private Realm realm;
    ArrayList<LengthData> lengthList;
    MainListAdapter mainListAdapter;

    /*LengthDataViewModel[] lengthDataViewModels ={
            new LengthDataViewModel(new LengthData("データ1","100cm","2016/08/31")),
            new LengthDataViewModel(new LengthData("データ2","120cm","2016/08/30")),
            new LengthDataViewModel(new LengthData("データ3","203cm","2016/08/29")),
            new LengthDataViewModel(new LengthData("データ4","40cm","2016/08/28")),
            new LengthDataViewModel(new LengthData("データ5","50cm","2016/08/27"))
    };*/

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        //realm= Realm.getDefaultInstance();

    }

    public static MainFragment newInstance(){
        return new MainFragment();
    }


    public void listAdd(View v){
        Log.d(TAG,"listAdd");

        lengthList.add(new LengthData("あああ","いいい","ううう"));
        mainListAdapter.notifyDataSetChanged();
        //Realm realm = Realm.getInstance();


    }

    public void startMeasurementActivity(View v){
        Log.d(TAG,"startMeasurementActivity");
        Intent intent = new Intent(getActivity(), MeasurementActivity.class);

        startActivityForResult(intent,1);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        binding = FragmentMainBinding.bind(getView());
        binding.setFragment(this);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.d(TAG,"onCreateView");

        return inflater.inflate(R.layout.fragment_main, container, false);
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }

    //view
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");





        //FloatingActionButton
        binding.actionLength.setSize(FloatingActionButton.SIZE_MINI);
        binding.actionLength.setIcon(R.drawable.scale);
        binding.actionArea.setSize(FloatingActionButton.SIZE_MINI);
        binding.actionArea.setIcon(R.drawable.area);
        binding.actionAddlist.setSize(FloatingActionButton.SIZE_MINI);
        binding.actionAddlist.setIcon(R.drawable.ic_add_white_24dp);

        lengthList = new ArrayList<>();

        LengthData jojo = new LengthData();
        jojo.setLength("123m");
        jojo.setId(12);
        jojo.setTime("2016/08/31");
        jojo.setTitle("棚からぼたもち");

        lengthList.add(jojo);

        mainListAdapter = new MainListAdapter(getContext());
        mainListAdapter.setLengthList(lengthList);

        binding.mainListView.setAdapter(mainListAdapter);



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
        realm.close();
    }


}
