package jp.yitt.bluetoothlowenergytest.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import jp.yitt.bluetoothlowenergytest.BR;
import jp.yitt.bluetoothlowenergytest.model.LengthData;

/**
 * Created by genm1023 on 8/30/16.
 */
public class LengthDataViewModel extends BaseObservable{
    private final String TAG = LengthDataViewModel.class.getSimpleName();
    private final LengthData lengthData;


    public LengthDataViewModel(LengthData model){
        this.lengthData = model;
    }

    @Bindable
    public String getTitle(){
        return lengthData.getTitle();
    }

    public void setTitle(String title){
        lengthData.setTitle(title);
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getTime() {
        return lengthData.getTime();
    }

    public void setTime(String time) {
        lengthData.setTime(time);
        notifyPropertyChanged(BR.time);
    }

    @Bindable
    public String getLength(){return lengthData.getLength();}

    public void setLength(String length){
        lengthData.setLength(length);
        notifyPropertyChanged(BR.length);
    }


}
