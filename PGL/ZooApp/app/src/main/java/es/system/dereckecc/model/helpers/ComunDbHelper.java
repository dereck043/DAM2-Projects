package es.system.dereckecc.model.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class ComunDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "zoo.db";

    public ComunDbHelper(Context context) {
        super(context, DATABASE_NAME,
                null, DATABASE_VERSION);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public ComunDbHelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {}

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    public long save(String table, ContentValues values) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                table,
                null,
                values);
    }

    public Cursor getAll(String table,
                         String[] columns,
                         String selection,
                         String[] selectionArgs,
                         String groupBy,
                         String having,
                         String orderBy) {

        return getReadableDatabase()
                .query(
                        table,
                        columns,
                        selection,
                        selectionArgs,
                        groupBy,
                        having,
                        orderBy
                );
    }

    public int delete(String table,
                      String clausulaWhere,
                      String[] whereCampos) {

        return getWritableDatabase().delete(
                table,
                clausulaWhere,
                whereCampos
        );
    }

    public int update(String table,
                      ContentValues contentValues,
                      String clausulaWhere,
                      String[] whereCampos) {

        return getWritableDatabase().update(
                table,
                contentValues,
                clausulaWhere,
                whereCampos
        );
    }
}

