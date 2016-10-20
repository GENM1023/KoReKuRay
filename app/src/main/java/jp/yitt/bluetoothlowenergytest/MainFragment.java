package jp.yitt.bluetoothlowenergytest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import jp.yitt.bluetoothlowenergytest.databinding.FragmentMainBinding;
import jp.yitt.bluetoothlowenergytest.databinding.ListItemLengthBinding;
import jp.yitt.bluetoothlowenergytest.model.LengthData;

/**
 * Created by genm1023 on 8/31/16.
 */
public class MainFragment extends Fragment implements OnRecyclerListener {
    public static final String TAG = MainFragment.class.getSimpleName();
    /* data binding */
    FragmentMainBinding binding;
    /* realm */
    private Realm realm;
    /* Listview */
    //ArrayList<Object> objectList;
    //MainListAdapter mainListAdapter;

    //RecyclerView
    List<RealmObject> items = new ArrayList<>();
    MainListAdapter adapter;
    View mView;

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

        //lengthList.add(new LengthData("あああ","いいい","ううう"));
        //mainListAdapter.notifyDataSetChanged();
        //Realm realm = Realm.getInstance();

        LengthData hoge = new LengthData();
        hoge.setTime("12345");
        hoge.setName("テスト");
        hoge.setLength(123.45);
        items.add(hoge);
        adapter.notifyDataSetChanged();


    }

    public void startMeasurementActivity(View v){
        Log.d(TAG,"startMeasurementActivity");

        Intent intent = new Intent(getActivity(), MeasurementActivity.class);

        startActivityForResult(intent,10);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode != -1){
            if(requestCode == 10){
                //data.getData().
            }
        }
    }

    public void startSuggestActivity(View v){
        Log.d(TAG,"startSuggestActivity");
        Intent intent = new Intent(getActivity(), SuggestActivity.class);

        startActivityForResult(intent,1);

    }
    @Override
    public void onRecyclerClicked(View v, int position){
        Log.d(TAG,"onRecyclerClicked:"+position);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        binding = FragmentMainBinding.bind(getView());
        binding.setFragment(this);


        items.clear();

        LengthData hoge = new LengthData();
        hoge.setTime("12345");
        hoge.setName("テスト");
        hoge.setLength(123.45);
        items.add(hoge);

        //adapter = new MainListAdapter(items);

        //binding.mainRecyclerView.setAdapter(adapter);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.d(TAG,"onCreateView");
        mView = inflater.inflate(R.layout.fragment_main, container, false);


        return mView;
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

        //縦方向の標準リストであることを指定
        binding.mainRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //mainListAdapter = new MainListAdapter(getContext(), objectList);
        //mainListAdapter.setLengthList(lengthList);
        //binding.mainListView.setAdapter(mainListAdapter);



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
        //realm.close();
    }

}
