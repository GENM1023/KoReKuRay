package jp.yitt.bluetoothlowenergytest.model;

import org.threeten.bp.LocalDateTime;

import io.realm.RealmObject;

/**
 * Created by genm1023 on 8/30/16.
 */
public class LengthData extends RealmObject{
    private String length;
    private String time;

    public LocalDateTime getTime() {
        return LocalDateTime.parse(time);
    }

    public void setTime(LocalDateTime time) {
        this.time = time.toString();
    }

    public String getLength(){return length;}

    public void setLength(String length){
        this.length = length;
    }


}
