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

public class AreaDataRealmProxy extends jp.yitt.bluetoothlowenergytest.model.AreaData
    implements RealmObjectProxy, AreaDataRealmProxyInterface {

    static final class AreaDataColumnInfo extends ColumnInfo {

        public final long idIndex;
        public final long nameIndex;
        public final long heightIndex;
        public final long widthIndex;
        public final long timeIndex;

        AreaDataColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(5);
            this.idIndex = getValidColumnIndex(path, table, "AreaData", "id");
            indicesMap.put("id", this.idIndex);

            this.nameIndex = getValidColumnIndex(path, table, "AreaData", "name");
            indicesMap.put("name", this.nameIndex);

            this.heightIndex = getValidColumnIndex(path, table, "AreaData", "height");
            indicesMap.put("height", this.heightIndex);

            this.widthIndex = getValidColumnIndex(path, table, "AreaData", "width");
            indicesMap.put("width", this.widthIndex);

            this.timeIndex = getValidColumnIndex(path, table, "AreaData", "time");
            indicesMap.put("time", this.timeIndex);

            setIndicesMap(indicesMap);
        }
    }

    private final AreaDataColumnInfo columnInfo;
    private final ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("height");
        fieldNames.add("width");
        fieldNames.add("time");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    AreaDataRealmProxy(ColumnInfo columnInfo) {
        this.columnInfo = (AreaDataColumnInfo) columnInfo;
        this.proxyState = new ProxyState(jp.yitt.bluetoothlowenergytest.model.AreaData.class, this);
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
        if (!transaction.hasTable("class_AreaData")) {
            Table table = transaction.getTable("class_AreaData");
            table.addColumn(RealmFieldType.INTEGER, "id", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "height", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.DOUBLE, "width", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "time", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return transaction.getTable("class_AreaData");
    }

    public static AreaDataColumnInfo validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_AreaData")) {
            Table table = transaction.getTable("class_AreaData");
            if (table.getColumnCount() != 5) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 5 but was " + table.getColumnCount());
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 5; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final AreaDataColumnInfo columnInfo = new AreaDataColumnInfo(transaction.getPath(), table);

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
            throw new RealmMigrationNeededException(transaction.getPath(), "The 'AreaData' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_AreaData";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static jp.yitt.bluetoothlowenergytest.model.AreaData createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        jp.yitt.bluetoothlowenergytest.model.AreaData obj = null;
        if (update) {
            Table table = realm.getTable(jp.yitt.bluetoothlowenergytest.model.AreaData.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                obj = new io.realm.AreaDataRealmProxy(realm.schema.getColumnInfo(jp.yitt.bluetoothlowenergytest.model.AreaData.class));
                ((RealmObjectProxy)obj).realmGet$proxyState().setRealm$realm(realm);
                ((RealmObjectProxy)obj).realmGet$proxyState().setRow$realm(table.getUncheckedRow(rowIndex));
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.AreaDataRealmProxy) realm.createObject(jp.yitt.bluetoothlowenergytest.model.AreaData.class, null);
                } else {
                    obj = (io.realm.AreaDataRealmProxy) realm.createObject(jp.yitt.bluetoothlowenergytest.model.AreaData.class, json.getLong("id"));
                }
            } else {
                obj = (io.realm.AreaDataRealmProxy) realm.createObject(jp.yitt.bluetoothlowenergytest.model.AreaData.class);
            }
        }
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                ((AreaDataRealmProxyInterface) obj).realmSet$id((long) json.getLong("id"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((AreaDataRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((AreaDataRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("height")) {
            if (json.isNull("height")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'height' to null.");
            } else {
                ((AreaDataRealmProxyInterface) obj).realmSet$height((double) json.getDouble("height"));
            }
        }
        if (json.has("width")) {
            if (json.isNull("width")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'width' to null.");
            } else {
                ((AreaDataRealmProxyInterface) obj).realmSet$width((double) json.getDouble("width"));
            }
        }
        if (json.has("time")) {
            if (json.isNull("time")) {
                ((AreaDataRealmProxyInterface) obj).realmSet$time(null);
            } else {
                ((AreaDataRealmProxyInterface) obj).realmSet$time((String) json.getString("time"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    public static jp.yitt.bluetoothlowenergytest.model.AreaData createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        jp.yitt.bluetoothlowenergytest.model.AreaData obj = realm.createObject(jp.yitt.bluetoothlowenergytest.model.AreaData.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((AreaDataRealmProxyInterface) obj).realmSet$id((long) reader.nextLong());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AreaDataRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((AreaDataRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("height")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'height' to null.");
                } else {
                    ((AreaDataRealmProxyInterface) obj).realmSet$height((double) reader.nextDouble());
                }
            } else if (name.equals("width")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'width' to null.");
                } else {
                    ((AreaDataRealmProxyInterface) obj).realmSet$width((double) reader.nextDouble());
                }
            } else if (name.equals("time")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AreaDataRealmProxyInterface) obj).realmSet$time(null);
                } else {
                    ((AreaDataRealmProxyInterface) obj).realmSet$time((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static jp.yitt.bluetoothlowenergytest.model.AreaData copyOrUpdate(Realm realm, jp.yitt.bluetoothlowenergytest.model.AreaData object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (jp.yitt.bluetoothlowenergytest.model.AreaData) cachedRealmObject;
        } else {
            jp.yitt.bluetoothlowenergytest.model.AreaData realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(jp.yitt.bluetoothlowenergytest.model.AreaData.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((AreaDataRealmProxyInterface) object).realmGet$id());
                if (rowIndex != TableOrView.NO_MATCH) {
                    realmObject = new io.realm.AreaDataRealmProxy(realm.schema.getColumnInfo(jp.yitt.bluetoothlowenergytest.model.AreaData.class));
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

    public static jp.yitt.bluetoothlowenergytest.model.AreaData copy(Realm realm, jp.yitt.bluetoothlowenergytest.model.AreaData newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (jp.yitt.bluetoothlowenergytest.model.AreaData) cachedRealmObject;
        } else {
            jp.yitt.bluetoothlowenergytest.model.AreaData realmObject = realm.createObject(jp.yitt.bluetoothlowenergytest.model.AreaData.class, ((AreaDataRealmProxyInterface) newObject).realmGet$id());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((AreaDataRealmProxyInterface) realmObject).realmSet$id(((AreaDataRealmProxyInterface) newObject).realmGet$id());
            ((AreaDataRealmProxyInterface) realmObject).realmSet$name(((AreaDataRealmProxyInterface) newObject).realmGet$name());
            ((AreaDataRealmProxyInterface) realmObject).realmSet$height(((AreaDataRealmProxyInterface) newObject).realmGet$height());
            ((AreaDataRealmProxyInterface) realmObject).realmSet$width(((AreaDataRealmProxyInterface) newObject).realmGet$width());
            ((AreaDataRealmProxyInterface) realmObject).realmSet$time(((AreaDataRealmProxyInterface) newObject).realmGet$time());
            return realmObject;
        }
    }

    public static long insert(Realm realm, jp.yitt.bluetoothlowenergytest.model.AreaData object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(jp.yitt.bluetoothlowenergytest.model.AreaData.class);
        long tableNativePtr = table.getNativeTablePointer();
        AreaDataColumnInfo columnInfo = (AreaDataColumnInfo) realm.schema.getColumnInfo(jp.yitt.bluetoothlowenergytest.model.AreaData.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((AreaDataRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((AreaDataRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
            if (primaryKeyValue != null) {
                Table.nativeSetLong(tableNativePtr, pkColumnIndex, rowIndex, ((AreaDataRealmProxyInterface) object).realmGet$id());
            }
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((AreaDataRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.heightIndex, rowIndex, ((AreaDataRealmProxyInterface)object).realmGet$height());
        Table.nativeSetDouble(tableNativePtr, columnInfo.widthIndex, rowIndex, ((AreaDataRealmProxyInterface)object).realmGet$width());
        String realmGet$time = ((AreaDataRealmProxyInterface)object).realmGet$time();
        if (realmGet$time != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.timeIndex, rowIndex, realmGet$time);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(jp.yitt.bluetoothlowenergytest.model.AreaData.class);
        long tableNativePtr = table.getNativeTablePointer();
        AreaDataColumnInfo columnInfo = (AreaDataColumnInfo) realm.schema.getColumnInfo(jp.yitt.bluetoothlowenergytest.model.AreaData.class);
        long pkColumnIndex = table.getPrimaryKey();
        jp.yitt.bluetoothlowenergytest.model.AreaData object = null;
        while (objects.hasNext()) {
            object = (jp.yitt.bluetoothlowenergytest.model.AreaData) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((AreaDataRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((AreaDataRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                    if (primaryKeyValue != null) {
                        Table.nativeSetLong(tableNativePtr, pkColumnIndex, rowIndex, ((AreaDataRealmProxyInterface) object).realmGet$id());
                    }
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$name = ((AreaDataRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.heightIndex, rowIndex, ((AreaDataRealmProxyInterface)object).realmGet$height());
                Table.nativeSetDouble(tableNativePtr, columnInfo.widthIndex, rowIndex, ((AreaDataRealmProxyInterface)object).realmGet$width());
                String realmGet$time = ((AreaDataRealmProxyInterface)object).realmGet$time();
                if (realmGet$time != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.timeIndex, rowIndex, realmGet$time);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, jp.yitt.bluetoothlowenergytest.model.AreaData object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(jp.yitt.bluetoothlowenergytest.model.AreaData.class);
        long tableNativePtr = table.getNativeTablePointer();
        AreaDataColumnInfo columnInfo = (AreaDataColumnInfo) realm.schema.getColumnInfo(jp.yitt.bluetoothlowenergytest.model.AreaData.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((AreaDataRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((AreaDataRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
            if (primaryKeyValue != null) {
                Table.nativeSetLong(tableNativePtr, pkColumnIndex, rowIndex, ((AreaDataRealmProxyInterface) object).realmGet$id());
            }
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((AreaDataRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.heightIndex, rowIndex, ((AreaDataRealmProxyInterface)object).realmGet$height());
        Table.nativeSetDouble(tableNativePtr, columnInfo.widthIndex, rowIndex, ((AreaDataRealmProxyInterface)object).realmGet$width());
        String realmGet$time = ((AreaDataRealmProxyInterface)object).realmGet$time();
        if (realmGet$time != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.timeIndex, rowIndex, realmGet$time);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.timeIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(jp.yitt.bluetoothlowenergytest.model.AreaData.class);
        long tableNativePtr = table.getNativeTablePointer();
        AreaDataColumnInfo columnInfo = (AreaDataColumnInfo) realm.schema.getColumnInfo(jp.yitt.bluetoothlowenergytest.model.AreaData.class);
        long pkColumnIndex = table.getPrimaryKey();
        jp.yitt.bluetoothlowenergytest.model.AreaData object = null;
        while (objects.hasNext()) {
            object = (jp.yitt.bluetoothlowenergytest.model.AreaData) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((AreaDataRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((AreaDataRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                    if (primaryKeyValue != null) {
                        Table.nativeSetLong(tableNativePtr, pkColumnIndex, rowIndex, ((AreaDataRealmProxyInterface) object).realmGet$id());
                    }
                }
                cache.put(object, rowIndex);
                String realmGet$name = ((AreaDataRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.heightIndex, rowIndex, ((AreaDataRealmProxyInterface)object).realmGet$height());
                Table.nativeSetDouble(tableNativePtr, columnInfo.widthIndex, rowIndex, ((AreaDataRealmProxyInterface)object).realmGet$width());
                String realmGet$time = ((AreaDataRealmProxyInterface)object).realmGet$time();
                if (realmGet$time != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.timeIndex, rowIndex, realmGet$time);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.timeIndex, rowIndex);
                }
            }
        }
    }

    public static jp.yitt.bluetoothlowenergytest.model.AreaData createDetachedCopy(jp.yitt.bluetoothlowenergytest.model.AreaData realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        jp.yitt.bluetoothlowenergytest.model.AreaData unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (jp.yitt.bluetoothlowenergytest.model.AreaData)cachedObject.object;
            } else {
                unmanagedObject = (jp.yitt.bluetoothlowenergytest.model.AreaData)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new jp.yitt.bluetoothlowenergytest.model.AreaData();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((AreaDataRealmProxyInterface) unmanagedObject).realmSet$id(((AreaDataRealmProxyInterface) realmObject).realmGet$id());
        ((AreaDataRealmProxyInterface) unmanagedObject).realmSet$name(((AreaDataRealmProxyInterface) realmObject).realmGet$name());
        ((AreaDataRealmProxyInterface) unmanagedObject).realmSet$height(((AreaDataRealmProxyInterface) realmObject).realmGet$height());
        ((AreaDataRealmProxyInterface) unmanagedObject).realmSet$width(((AreaDataRealmProxyInterface) realmObject).realmGet$width());
        ((AreaDataRealmProxyInterface) unmanagedObject).realmSet$time(((AreaDataRealmProxyInterface) realmObject).realmGet$time());
        return unmanagedObject;
    }

    static jp.yitt.bluetoothlowenergytest.model.AreaData update(Realm realm, jp.yitt.bluetoothlowenergytest.model.AreaData realmObject, jp.yitt.bluetoothlowenergytest.model.AreaData newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((AreaDataRealmProxyInterface) realmObject).realmSet$name(((AreaDataRealmProxyInterface) newObject).realmGet$name());
        ((AreaDataRealmProxyInterface) realmObject).realmSet$height(((AreaDataRealmProxyInterface) newObject).realmGet$height());
        ((AreaDataRealmProxyInterface) realmObject).realmSet$width(((AreaDataRealmProxyInterface) newObject).realmGet$width());
        ((AreaDataRealmProxyInterface) realmObject).realmSet$time(((AreaDataRealmProxyInterface) newObject).realmGet$time());
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
        AreaDataRealmProxy aAreaData = (AreaDataRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aAreaData.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aAreaData.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aAreaData.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
