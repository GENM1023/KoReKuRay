package jp.yitt.bluetoothlowenergytest.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.threeten.bp.LocalDateTime;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by genm1023 on 8/30/16.
 */
public class LengthData implements Parcelable{
    @PrimaryKey
    private long id;
    private String title;
    private String length;
    private String time;

    public LengthData(String title, String length, String time){
        this.title = title;
        this.length = length;
        this.time = time;
    }
    public LengthData(Parcel in){
        title = in.readString();
        length = in.readString();
        time = in.readString();
    }
    public LengthData(){

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
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
}
