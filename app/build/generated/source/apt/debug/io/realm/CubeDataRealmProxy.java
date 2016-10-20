package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmFieldType;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CubeDataRealmProxy extends jp.yitt.bluetoothlowenergytest.model.CubeData
    implements RealmObjectProxy, CubeDataRealmProxyInterface {

    static final class CubeDataColumnInfo extends ColumnInfo {

        public final long idIndex;
        public final long nameIndex;
        public final long heightIndex;
        public final long widthIndex;
        public final long lengthIndex;
        public final long timeIndex;

        CubeDataColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(6);
            this.idIndex = getValidColumnIndex(path, table, "CubeData", "id");
            indicesMap.put("id", this.idIndex);

            this.nameIndex = getValidColumnIndex(path, table, "CubeData", "name");
            indicesMap.put("name", this.nameIndex);

            this.heightIndex = getValidColumnIndex(path, table, "CubeData", "height");
            indicesMap.put("height", this.heightIndex);

            this.widthIndex = getValidColumnIndex(path, table, "CubeData", "width");
            indicesMap.put("width", this.widthIndex);

            this.lengthIndex = getValidColumnIndex(path, table, "CubeData", "length");
            indicesMap.put("length", this.lengthIndex);

            this.timeIndex = getValidColumnIndex(path, table, "CubeData", "time");
            indicesMap.put("time", this.timeIndex);

            setIndicesMap(indicesMap);
        }
    }

    private final CubeDataColumnInfo columnInfo;
    private final ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("height");
        fieldNames.add("width");
        fieldNames.add("length");
        fieldNames.add("time");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    CubeDataRealmProxy(ColumnInfo columnInfo) {
        this.columnInfo = (CubeDataColumnInfo) columnInfo;
        this.proxyState = new ProxyState(jp.yitt.bluetoothlowenergytest.model.CubeData.class, this);
    }

    @SuppressWarnings("cast")
    public long realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    public void realmSet$id(long value) {
        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.idIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    public void realmSet$name(String value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @SuppressWarnings("cast")
    public double realmGet$height() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.heightIndex);
    }

    public void realmSet$height(double value) {
        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.heightIndex, value);
    }

    @SuppressWarnings("cast")
    public double realmGet$width() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.widthIndex);
    }

    public void realmSet$width(double value) {
        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.widthIndex, value);
    }

    @SuppressWarnings("cast")
    public double realmGet$length() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.lengthIndex);
    }

    public void realmSet$length(double value) {
        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.lengthIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$time() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.timeIndex);
    }

    public void realmSet$time(String value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.timeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.timeIndex, value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_CubeData")) {
            Table table = transaction.getTable("class_CubeData");
            table.addColumn(RealmFieldType.INTEGER, "id", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "height", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "width", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "length", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "time", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return transaction.getTable("class_CubeData");
    }

    public static CubeDataColumnInfo validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_CubeData")) {
            Table table = transaction.getTable("class_CubeData");
            if (table.getColumnCount() != 6) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 6 but was " + table.getColumnCount());
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 6; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final CubeDataColumnInfo columnInfo = new CubeDataColumnInfo(transaction.getPath(), table);

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("id") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'long' for field 'id' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.idIndex) && table.findFirstNull(columnInfo.idIndex) != TableOrView.NO_MATCH) {
                throw new IllegalStateException("Cannot migrate an object with null value in field 'id'. Either maintain the same type for primary key field 'id', or remove the object with null value before migration.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Primary key not defined for field 'id' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("height")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'height' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("height") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'double' for field 'height' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.heightIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'height' does support null values in the existing Realm file. Use corresponding boxed type for field 'height' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("width")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'width' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("width") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'double' for field 'width' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.widthIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'width' does support null values in the existing Realm file. Use corresponding boxed type for field 'width' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("length")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'length' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("length") != RealmFieldType.DOUBLE) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'double' for field 'length' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.lengthIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'length' does support null values in the existing Realm file. Use corresponding boxed type for field 'length' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("time")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'time' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("time") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'time' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.timeIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'time' is required. Either set @Required to field 'time' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The 'CubeData' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_CubeData";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static jp.yitt.bluetoothlowenergytest.model.CubeData createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        jp.yitt.bluetoothlowenergytest.model.CubeData obj = null;
        if (update) {
            Table table = realm.getTable(jp.yitt.bluetoothlowenergytest.model.CubeData.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                obj = new io.realm.CubeDataRealmProxy(realm.schema.getColumnInfo(jp.yitt.bluetoothlowenergytest.model.CubeData.class));
                ((RealmObjectProxy)obj).realmGet$proxyState().setRealm$realm(realm);
                ((RealmObjectProxy)obj).realmGet$proxyState().setRow$realm(table.getUncheckedRow(rowIndex));
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.CubeDataRealmProxy) realm.createObject(jp.yitt.bluetoothlowenergytest.model.CubeData.class, null);
                } else {
                    obj = (io.realm.CubeDataRealmProxy) realm.createObject(jp.yitt.bluetoothlowenergytest.model.CubeData.class, json.getLong("id"));
                }
            } else {
                obj = (io.realm.CubeDataRealmProxy) realm.createObject(jp.yitt.bluetoothlowenergytest.model.CubeData.class);
            }
        }
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                ((CubeDataRealmProxyInterface) obj).realmSet$id((long) json.getLong("id"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((CubeDataRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((CubeDataRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("height")) {
            if (json.isNull("height")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'height' to null.");
            } else {
                ((CubeDataRealmProxyInterface) obj).realmSet$height((double) json.getDouble("height"));
            }
        }
        if (json.has("width")) {
            if (json.isNull("width")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'width' to null.");
            } else {
                ((CubeDataRealmProxyInterface) obj).realmSet$width((double) json.getDouble("width"));
            }
        }
        if (json.has("length")) {
            if (json.isNull("length")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'length' to null.");
            } else {
                ((CubeDataRealmProxyInterface) obj).realmSet$length((double) json.getDouble("length"));
            }
        }
        if (json.has("time")) {
            if (json.isNull("time")) {
                ((CubeDataRealmProxyInterface) obj).realmSet$time(null);
            } else {
                ((CubeDataRealmProxyInterface) obj).realmSet$time((String) json.getString("time"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    public static jp.yitt.bluetoothlowenergytest.model.CubeData createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        jp.yitt.bluetoothlowenergytest.model.CubeData obj = realm.createObject(jp.yitt.bluetoothlowenergytest.model.CubeData.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((CubeDataRealmProxyInterface) obj).realmSet$id((long) reader.nextLong());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CubeDataRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((CubeDataRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("height")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'height' to null.");
                } else {
                    ((CubeDataRealmProxyInterface) obj).realmSet$height((double) reader.nextDouble());
                }
            } else if (name.equals("width")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'width' to null.");
                } else {
                    ((CubeDataRealmProxyInterface) obj).realmSet$width((double) reader.nextDouble());
                }
            } else if (name.equals("length")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'length' to null.");
                } else {
                    ((CubeDataRealmProxyInterface) obj).realmSet$length((double) reader.nextDouble());
                }
            } else if (name.equals("time")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CubeDataRealmProxyInterface) obj).realmSet$time(null);
                } else {
                    ((CubeDataRealmProxyInterface) obj).realmSet$time((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static jp.yitt.bluetoothlowenergytest.model.CubeData copyOrUpdate(Realm realm, jp.yitt.bluetoothlowenergytest.model.CubeData object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (jp.yitt.bluetoothlowenergytest.model.CubeData) cachedRealmObject;
        } else {
            jp.yitt.bluetoothlowenergytest.model.CubeData realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(jp.yitt.bluetoothlowenergytest.model.CubeData.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((CubeDataRealmProxyInterface) object).realmGet$id());
                if (rowIndex != TableOrView.NO_MATCH) {
                    realmObject = new io.realm.CubeDataRealmProxy(realm.schema.getColumnInfo(jp.yitt.bluetoothlowenergytest.model.CubeData.class));
                    ((RealmObjectProxy)realmObject).realmGet$proxyState().setRealm$realm(realm);
                    ((RealmObjectProxy)realmObject).realmGet$proxyState().setRow$realm(table.getUncheckedRow(rowIndex));
                    cache.put(object, (RealmObjectProxy) realmObject);
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static jp.yitt.bluetoothlowenergytest.model.CubeData copy(Realm realm, jp.yitt.bluetoothlowenergytest.model.CubeData newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (jp.yitt.bluetoothlowenergytest.model.CubeData) cachedRealmObject;
        } else {
            jp.yitt.bluetoothlowenergytest.model.CubeData realmObject = realm.createObject(jp.yitt.bluetoothlowenergytest.model.CubeData.class, ((CubeDataRealmProxyInterface) newObject).realmGet$id());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((CubeDataRealmProxyInterface) realmObject).realmSet$id(((CubeDataRealmProxyInterface) newObject).realmGet$id());
            ((CubeDataRealmProxyInterface) realmObject).realmSet$name(((CubeDataRealmProxyInterface) newObject).realmGet$name());
            ((CubeDataRealmProxyInterface) realmObject).realmSet$height(((CubeDataRealmProxyInterface) newObject).realmGet$height());
            ((CubeDataRealmProxyInterface) realmObject).realmSet$width(((CubeDataRealmProxyInterface) newObject).realmGet$width());
            ((CubeDataRealmProxyInterface) realmObject).realmSet$length(((CubeDataRealmProxyInterface) newObject).realmGet$length());
            ((CubeDataRealmProxyInterface) realmObject).realmSet$time(((CubeDataRealmProxyInterface) newObject).realmGet$time());
            return realmObject;
        }
    }

    public static long insert(Realm realm, jp.yitt.bluetoothlowenergytest.model.CubeData object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(jp.yitt.bluetoothlowenergytest.model.CubeData.class);
        long tableNativePtr = table.getNativeTablePointer();
        CubeDataColumnInfo columnInfo = (CubeDataColumnInfo) realm.schema.getColumnInfo(jp.yitt.bluetoothlowenergytest.model.CubeData.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((CubeDataRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CubeDataRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
            if (primaryKeyValue != null) {
                Table.nativeSetLong(tableNativePtr, pkColumnIndex, rowIndex, ((CubeDataRealmProxyInterface) object).realmGet$id());
            }
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((CubeDataRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.heightIndex, rowIndex, ((CubeDataRealmProxyInterface)object).realmGet$height());
        Table.nativeSetDouble(tableNativePtr, columnInfo.widthIndex, rowIndex, ((CubeDataRealmProxyInterface)object).realmGet$width());
        Table.nativeSetDouble(tableNativePtr, columnInfo.lengthIndex, rowIndex, ((CubeDataRealmProxyInterface)object).realmGet$length());
        String realmGet$time = ((CubeDataRealmProxyInterface)object).realmGet$time();
        if (realmGet$time != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.timeIndex, rowIndex, realmGet$time);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(jp.yitt.bluetoothlowenergytest.model.CubeData.class);
        long tableNativePtr = table.getNativeTablePointer();
        CubeDataColumnInfo columnInfo = (CubeDataColumnInfo) realm.schema.getColumnInfo(jp.yitt.bluetoothlowenergytest.model.CubeData.class);
        long pkColumnIndex = table.getPrimaryKey();
        jp.yitt.bluetoothlowenergytest.model.CubeData object = null;
        while (objects.hasNext()) {
            object = (jp.yitt.bluetoothlowenergytest.model.CubeData) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((CubeDataRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CubeDataRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                    if (primaryKeyValue != null) {
                        Table.nativeSetLong(tableNativePtr, pkColumnIndex, rowIndex, ((CubeDataRealmProxyInterface) object).realmGet$id());
                    }
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$name = ((CubeDataRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.heightIndex, rowIndex, ((CubeDataRealmProxyInterface)object).realmGet$height());
                Table.nativeSetDouble(tableNativePtr, columnInfo.widthIndex, rowIndex, ((CubeDataRealmProxyInterface)object).realmGet$width());
                Table.nativeSetDouble(tableNativePtr, columnInfo.lengthIndex, rowIndex, ((CubeDataRealmProxyInterface)object).realmGet$length());
                String realmGet$time = ((CubeDataRealmProxyInterface)object).realmGet$time();
                if (realmGet$time != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.timeIndex, rowIndex, realmGet$time);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, jp.yitt.bluetoothlowenergytest.model.CubeData object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(jp.yitt.bluetoothlowenergytest.model.CubeData.class);
        long tableNativePtr = table.getNativeTablePointer();
        CubeDataColumnInfo columnInfo = (CubeDataColumnInfo) realm.schema.getColumnInfo(jp.yitt.bluetoothlowenergytest.model.CubeData.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((CubeDataRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CubeDataRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
            if (primaryKeyValue != null) {
                Table.nativeSetLong(tableNativePtr, pkColumnIndex, rowIndex, ((CubeDataRealmProxyInterface) object).realmGet$id());
            }
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((CubeDataRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.heightIndex, rowIndex, ((CubeDataRealmProxyInterface)object).realmGet$height());
        Table.nativeSetDouble(tableNativePtr, columnInfo.widthIndex, rowIndex, ((CubeDataRealmProxyInterface)object).realmGet$width());
        Table.nativeSetDouble(tableNativePtr, columnInfo.lengthIndex, rowIndex, ((CubeDataRealmProxyInterface)object).realmGet$length());
        String realmGet$time = ((CubeDataRealmProxyInterface)object).realmGet$time();
        if (realmGet$time != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.timeIndex, rowIndex, realmGet$time);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.timeIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(jp.yitt.bluetoothlowenergytest.model.CubeData.class);
        long tableNativePtr = table.getNativeTablePointer();
        CubeDataColumnInfo columnInfo = (CubeDataColumnInfo) realm.schema.getColumnInfo(jp.yitt.bluetoothlowenergytest.model.CubeData.class);
        long pkColumnIndex = table.getPrimaryKey();
        jp.yitt.bluetoothlowenergytest.model.CubeData object = null;
        while (objects.hasNext()) {
            object = (jp.yitt.bluetoothlowenergytest.model.CubeData) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((CubeDataRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CubeDataRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                    if (primaryKeyValue != null) {
                        Table.nativeSetLong(tableNativePtr, pkColumnIndex, rowIndex, ((CubeDataRealmProxyInterface) object).realmGet$id());
                    }
                }
                cache.put(object, rowIndex);
                String realmGet$name = ((CubeDataRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.heightIndex, rowIndex, ((CubeDataRealmProxyInterface)object).realmGet$height());
                Table.nativeSetDouble(tableNativePtr, columnInfo.widthIndex, rowIndex, ((CubeDataRealmProxyInterface)object).realmGet$width());
                Table.nativeSetDouble(tableNativePtr, columnInfo.lengthIndex, rowIndex, ((CubeDataRealmProxyInterface)object).realmGet$length());
                String realmGet$time = ((CubeDataRealmProxyInterface)object).realmGet$time();
                if (realmGet$time != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.timeIndex, rowIndex, realmGet$time);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.timeIndex, rowIndex);
                }
            }
        }
    }

    public static jp.yitt.bluetoothlowenergytest.model.CubeData createDetachedCopy(jp.yitt.bluetoothlowenergytest.model.CubeData realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        jp.yitt.bluetoothlowenergytest.model.CubeData unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (jp.yitt.bluetoothlowenergytest.model.CubeData)cachedObject.object;
            } else {
                unmanagedObject = (jp.yitt.bluetoothlowenergytest.model.CubeData)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new jp.yitt.bluetoothlowenergytest.model.CubeData();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((CubeDataRealmProxyInterface) unmanagedObject).realmSet$id(((CubeDataRealmProxyInterface) realmObject).realmGet$id());
        ((CubeDataRealmProxyInterface) unmanagedObject).realmSet$name(((CubeDataRealmProxyInterface) realmObject).realmGet$name());
        ((CubeDataRealmProxyInterface) unmanagedObject).realmSet$height(((CubeDataRealmProxyInterface) realmObject).realmGet$height());
        ((CubeDataRealmProxyInterface) unmanagedObject).realmSet$width(((CubeDataRealmProxyInterface) realmObject).realmGet$width());
        ((CubeDataRealmProxyInterface) unmanagedObject).realmSet$length(((CubeDataRealmProxyInterface) realmObject).realmGet$length());
        ((CubeDataRealmProxyInterface) unmanagedObject).realmSet$time(((CubeDataRealmProxyInterface) realmObject).realmGet$time());
        return unmanagedObject;
    }

    static jp.yitt.bluetoothlowenergytest.model.CubeData update(Realm realm, jp.yitt.bluetoothlowenergytest.model.CubeData realmObject, jp.yitt.bluetoothlowenergytest.model.CubeData newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((CubeDataRealmProxyInterface) realmObject).realmSet$name(((CubeDataRealmProxyInterface) newObject).realmGet$name());
        ((CubeDataRealmProxyInterface) realmObject).realmSet$height(((CubeDataRealmProxyInterface) newObject).realmGet$height());
        ((CubeDataRealmProxyInterface) realmObject).realmSet$width(((CubeDataRealmProxyInterface) newObject).realmGet$width());
        ((CubeDataRealmProxyInterface) realmObject).realmSet$length(((CubeDataRealmProxyInterface) newObject).realmGet$length());
        ((CubeDataRealmProxyInterface) realmObject).realmSet$time(((CubeDataRealmProxyInterface) newObject).realmGet$time());
        return realmObject;
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeDataRealmProxy aCubeData = (CubeDataRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCubeData.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCubeData.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCubeData.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
