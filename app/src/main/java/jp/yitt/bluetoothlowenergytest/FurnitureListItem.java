package jp.yitt.bluetoothlowenergytest;

/**
 * Created by yaritakouhei on 2016/10/16.
 */
public class FurnitureListItem {
    private int imageId;
    private String name;
    private String price;
    private String url;
    public int getImageId() {
        return imageId;
    }

    public String getName() { return name; }
    public void setName(String name){
        this.name = name;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price){
        this.price = price;
    }

    public String getUrl(){ return url;}
    public void setUrl(String url){
        this.url = url;
    }
}
