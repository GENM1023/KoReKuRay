package jp.yitt.bluetoothlowenergytest.util;

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.FindCallback;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;
import com.nifty.cloud.mb.core.NCMBQuery;

import java.util.List;

/**
 * Created by yaritakouhei on 2016/08/31.
 */
public class NCMBUtil {

    /* 測ったデータを保存するメソッド
     * distance 距離
     * angle 角度
     * objName 測ったものの名前
     */
    protected static void saveData(int distance, int angle, String objName){
        NCMBObject obj = new NCMBObject("measured_value");
        obj.put("distance", distance);
        obj.put("angle", angle);
        obj.put("object_name", objName);
        obj.saveInBackground(new DoneCallback() {
            @Override
            public void done(NCMBException e) {
                if(e == null){
                    //保存成功
                    System.out.println("保存成功");
                }else {
                    //保存失敗
                    System.out.println("保存失敗");
                }
            }
        });
    }

    /*測ったデータを検索、取得するメソッド
     *objName 測った物の名前
     */
    protected static void getData(String objName){
        //TestClassを検索するためのNCMBQueryインスタンスを作成
        NCMBQuery<NCMBObject> query = new NCMBQuery<>("measured_value");

        //keyというフィールドがvalueとなっているデータを検索する条件を設定
        query.whereEqualTo("object_name", objName);

        //データストアからデータを検索
        query.findInBackground(new FindCallback<NCMBObject>() {
            @Override
            public void done(List<NCMBObject> results, NCMBException e) {
                if (e != null) {
                    //検索失敗時の処理
                    print("検索失敗しました" + e);
                } else {
                    //検索成功時の処理
                    print("検索結果...");
                    for (NCMBObject obj: results) {
                        print("object_name: " + obj.getString("object_name") +
                                " distance: " + obj.getString("distance") +
                                " angle: "     + obj.getString("angle"));
                    }
                }
            }
        });

    }

    private static void print(String str){
        System.out.println(str);
    }

}
