package jp.yitt.bluetoothlowenergytest.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by genm1023 on 9/1/16.
 */
public class AreaData extends RealmObject {

    @PrimaryKey
    private long id;
    private String name;
    private double height;
    private double width;
    private String time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "AreaData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", time='" + time + '\'' +
                '}';
    }

}
