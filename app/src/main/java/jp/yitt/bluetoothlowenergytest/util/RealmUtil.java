package jp.yitt.bluetoothlowenergytest.util;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by genm1023 on 9/1/16.
 */
public class RealmUtil {

    public void addData(final ArrayList<RealmObject> arrayList){
        final Realm realm = Realm.getDefaultInstance();
        try {
            realm.executeTransaction(new Realm.Transaction(){

                @Override
                public void execute(Realm realm){
                    for (RealmObject item : arrayList){
                        realm.copyToRealmOrUpdate(item);
                    }
                }
            });
        }finally {
            realm.close();
        }


    }
}
