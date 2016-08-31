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

import jp.yitt.bluetoothlowenergytest.databinding.FragmentMainBinding;

/**
 * Created by genm1023 on 8/31/16.
 */
public class MainFragment extends Fragment {
    public static final String TAG = MainFragment.class.getSimpleName();

    FragmentMainBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
    }

    public static MainFragment newInstance(){
        return new MainFragment();
    }

    public void listAdd(View v){
        Log.d(TAG,"listAdd");

    }

    //finish()によりcallされる
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


}
