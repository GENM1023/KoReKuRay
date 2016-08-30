package jp.yitt.bluetoothlowenergytest.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import org.threeten.bp.LocalDateTime;

import jp.yitt.bluetoothlowenergytest.BR;

/**
 * Created by genm1023 on 8/30/16.
 */
public class LengthData extends BaseObservable{
    private final String TAG = LengthData.class.getSimpleName();
    public String length;
    public LocalDateTime time;


    public LengthData(String length, LocalDateTime dateTime){
        Log.d(TAG,"Lengthdata(String:" + length + "LocalDateTime:" + dateTime.toString()+")");
        this.length = length;
        this.time = dateTime;
    }

    @Bindable
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        Log.d(TAG, "setTime("+time.toString()+")");
        this.time = time;
        notifyPropertyChanged(BR.time);
    }

    @Bindable
    public String getLength(){return length;}

    public void setLength(String length){
        Log.d(TAG, "setLength("+length+")");
        this.length = length;
        notifyPropertyChanged(BR.length);

    }


}
