package jp.yitt.bluetoothlowenergytest.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import org.threeten.bp.LocalDateTime;

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
    public LocalDateTime getTime() {
        return lengthData.getTime();
    }

    public void setTime(LocalDateTime time) {
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
