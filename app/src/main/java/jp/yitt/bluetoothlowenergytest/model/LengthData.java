package jp.yitt.bluetoothlowenergytest.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by genm1023 on 8/30/16.
 */
public class LengthData extends RealmObject{
    private String name;
    private double length;
    private String time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getTime() {
        return time;
    }


    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
