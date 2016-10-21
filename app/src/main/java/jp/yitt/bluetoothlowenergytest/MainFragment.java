package jp.yitt.bluetoothlowenergytest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.nifty.cloud.mb.core.FindCallback;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;
import com.nifty.cloud.mb.core.NCMBQuery;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import jp.yitt.bluetoothlowenergytest.databinding.FragmentMainBinding;
import jp.yitt.bluetoothlowenergytest.model.LengthData;

//import jp.yitt.bluetoothlowenergytest.databinding.*;

/**
 * Created by genm1023 on 8/31/16.
 */
public class MainFragment extends Fragment  {
    public static final String TAG = MainFragment.class.getSimpleName();
    /* data binding */
    FragmentMainBinding binding;
    /* realm */
    private Realm realm;
    /* Listview */
    ArrayList<LengthData> lengthList;
    MainListAdapter mainListAdapter;

    //RecyclerView
   // List<RealmObject> items = new ArrayList<>();
    //MainListAdapter adapter;
    //View mView;

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
        mainListAdapter.notifyDataSetChanged();
        //Realm realm = Realm.getInstance();

        LengthData hoge = new LengthData();
        hoge.setTime("12345");
        hoge.setName("テスト");
        hoge.setLength("123.45");
        //items.add(hoge);


    }

    public void startMeasurementActivity(View v){
        Log.d(TAG,"startMeasurementActivity");
        Intent intent = new Intent(getActivity(), MeasurementActivity.class);

        startActivityForResult(intent,10);

    }


//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(resultCode != -1){
//            if(requestCode == 10){
//                //data.getData().
//            }
//        }
//    }

//    public void startSuggestActivity(View v){
//        Log.d(TAG,"startSuggestActivity");
//        Intent intent = new Intent(getActivity(), SuggestActivity.class);
//
//        startActivityForResult(intent,1);
//
//    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
//        super.onActivityCreated(savedInstanceState);
//        binding = FragmentMainBinding.bind(getView());
//        binding.setFragment(this);
        super.onActivityCreated(savedInstanceState);
        Log.d("FRAGMENT_TEST", getView().toString());
        binding = FragmentMainBinding.bind(getView());
        binding.setFragment(this);

//        items.clear();
//
//        LengthData hoge = new LengthData();
//        hoge.setTime("12345");
//        hoge.setName("テスト");
//        hoge.setLength("123.45");
//        items.add(hoge);

        //adapter = new MainListAdapter(items);

        //binding.mainRecyclerView.setAdapter(adapter);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
          Log.d(TAG,"onCreateView");
//        mView = inflater.inflate(R.layout.fragment_main, container, false);
//
//
//        return mView;
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
//        binding.actionArea.setSize(FloatingActionButton.SIZE_MINI);
//        binding.actionArea.setIcon(R.drawable.area);

        //縦方向の標準リストであることを指定
        //binding.mainRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //mainListAdapter = new MainListAdapter(getContext(), objectList);
        //mainListAdapter.setLengthList(lengthList);
        //binding.mainListView.setAdapter(mainListAdapter);
        lengthList = new ArrayList<>();
        NCMBQuery<NCMBObject> query = new NCMBQuery<>("LengthData");


  //      keyというフィールドがvalueとなっているデータを検索する条件を設定
        query.whereEqualTo("user", "testUser");

        //データストアからデータを検索
        query.findInBackground(new FindCallback<NCMBObject>() {
            @Override
            public void done(List<NCMBObject> results, NCMBException e) {
                if (e != null) {
                    //検索失敗時の処理
                    Log.d("NCMB_TAG", "検索失敗しました" + e);
                } else if(results.size() > 0){
                    //検索成功時の処理
                    Log.d("NCMB_TAG", "検索結果...");
                    for (NCMBObject obj: results) {


                        LengthData ld = new LengthData();
                        ld.setLength(obj.getString("distance"));
                        ld.setTime("2016/08/31");
                        ld.setName(obj.getString("objectName"));
                        lengthList.add(ld);

                        Log.d("NCMB_TAG", "objectName: " + obj.getString("objectName") +
                                " distance: " + obj.getString("distance") +
                                " angle: "    + obj.getString("angle")    +
                                " date: "     + obj.getString("createDate"));

                    }
                    mainListAdapter = new MainListAdapter(getContext());
                    mainListAdapter.setLengthList(lengthList);
                    binding.mainListView.setAdapter(mainListAdapter);

                } else {
                    Log.d("NCMB_TAG", "データはありませんでした");
                }
            }
        });
//        LengthData ld = new LengthData();
//                        ld.setLength("1000");
//                        ld.setTime("2016/08/31");
//                        ld.setName("たんす");
                      //  lengthList.add(ld);
//        mainListAdapter = new MainListAdapter(getContext());
//                    mainListAdapter.setLengthList(lengthList);
//                    binding.mainListView.setAdapter(mainListAdapter);

        binding.mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = position + "番目のアイテムがクリックされました";
                Log.d("ITEM_CLICK_TEST", msg);

                Log.d(TAG, "startSearchFurnitureActivity");
                Intent intent = new Intent(getActivity(), SearchFurnitureActivity.class);
                intent.putExtra("name", lengthList.get(position).getName());
                intent.putExtra("length", lengthList.get(position).getLength());
                startActivityForResult(intent, (int)lengthList.get(position).getId());
            }

        });



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
