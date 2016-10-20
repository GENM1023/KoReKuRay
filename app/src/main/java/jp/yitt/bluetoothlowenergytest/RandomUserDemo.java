package jp.yitt.bluetoothlowenergytest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

/**
 * Created by yaritakouhei on 2016/10/20.
 */
@Generated("org.jsonschema2pojo")
public class RandomUserDemo {
    @SerializedName("service")
    @Expose
    public List<String> service = new ArrayList<String>();
    @SerializedName("name")
    @Expose
    public List<String> name = new ArrayList<String>();
    @SerializedName("url")
    @Expose
    public List<String> url = new ArrayList<String>();
    @SerializedName("images")
    @Expose
    public List<String> images = new ArrayList<String>();
    @SerializedName("price")
    @Expose
    public List<String> price = new ArrayList<String>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Class: " + this.getClass().getCanonicalName() + "\n");
        sb.append("Settings:\n");
        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                sb.append(field.getName() + " = " + field.get(this) + "\n");
            } catch (IllegalAccessException e) {
                sb.append(field.getName() + " = " + "access denied\n");
            }
        }
        return sb.toString();
    }
}
