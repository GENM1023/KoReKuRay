package jp.yitt.bluetoothlowenergytest.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by genm1023 on 8/30/16.
 */
public class LengthDataRO extends RealmObject{
    @PrimaryKey
    private long id;
    private String title;
    private String length;
    private String time;

    public LengthDataRO(String title, String length, String time){
        this.title = title;
        this.length = length;
        this.time = time;
    }
    public LengthDataRO(){

    }

    public long getId(){return id;}
    public void setId(long id){
        this.id = id;
    }

    public String getTitle(){return title;}
    public void setTitle(String title){
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time.toString();
    }

    public String getLength(){return length;}

    public void setLength(String length){
        this.length = length;
    }


}
