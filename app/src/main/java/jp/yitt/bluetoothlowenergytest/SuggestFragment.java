package jp.yitt.bluetoothlowenergytest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.List;

import jp.yitt.bluetoothlowenergytest.databinding.FragmentSuggestBinding;
import jp.yitt.bluetoothlowenergytest.databinding.ProductCardBinding;


/**
 * Created by genm1023 on 9/2/16.
 */
public class SuggestFragment extends Fragment {
    FragmentSuggestBinding suggestBinding;
    ProductCardBinding productCardBinding;

    public SuggestFragment() {
    }

    public static SuggestFragment newInstance(){
        return new SuggestFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_suggest, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        suggestBinding = FragmentSuggestBinding.bind(getView());

        //productCardBinding = ProductCardBinding.bind(getView());
        suggestBinding.cardLinear.removeAllViews();

        for(int i=0; i<5; i++){
            //CardView cardView = productCardBinding.cardView;
            //suggestBinding.cardLinear

            //suggestBinding.cardLinear.addView(cardView);


        }


    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);



    }

    @Override
    public void onStart() {
        super.onStart();

        //suggestBinding.cardLinear




    }
    public void onClickedItem(View v){

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }



}

