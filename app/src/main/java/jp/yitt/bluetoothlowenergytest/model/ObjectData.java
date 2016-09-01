package jp.yitt.bluetoothlowenergytest.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by genm1023 on 9/1/16.
 */
public class ObjectData extends RealmObject {
    @PrimaryKey
    private long id;
    private RealmList<LengthData> length;
    private RealmList<AreaData> area;
    private RealmList<CubeData> cube;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RealmList<LengthData> getLength() {
        return length;
    }

    public void setLength(RealmList<LengthData> length) {
        this.length = length;
    }

    public RealmList<AreaData> getArea() {
        return area;
    }

    public void setArea(RealmList<AreaData> area) {
        this.area = area;
    }

    public RealmList<CubeData> getCube() {
        return cube;
    }

    public void setCube(RealmList<CubeData> cube) {
        this.cube = cube;
    }
}
