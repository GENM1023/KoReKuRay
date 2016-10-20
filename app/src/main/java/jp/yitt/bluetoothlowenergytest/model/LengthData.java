package jp.yitt.bluetoothlowenergytest.model;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.annotations.PrimaryKey;

/**
 * Created by genm1023 on 8/30/16.
 */
public class LengthData implements Parcelable {
    @PrimaryKey
    private long id;
    private String name;
    private String length;
    private String time;

    public LengthData(String name, String length, String time){
        this.name = name;
        this.length = length;
        this.time = time;
    }

    public LengthData(Parcel in){
        name = in.readString();
        length = in.readString();
        time = in.readString();
    }

    public LengthData(){}

    public long getId(){return id;}
    public void setId(long id){
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTime() {
        return time;
    }


    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(length);
        dest.writeString(time);
    }

    public static final Parcelable.Creator<LengthData> CREATOR
            = new Parcelable.Creator<LengthData>(){
        public LengthData createFromParcel(Parcel in){
            return new LengthData(in);
        }
        public LengthData[] newArray(int size){
            return new LengthData[size];
        }
    };

    @Override
    public String toString() {
        return super.toString();
    }

}
