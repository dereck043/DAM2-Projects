package es.system.dereckecc.model.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.system.dereckecc.model.Zoo;
import es.system.dereckecc.model.contracts.ZooContract;

public class ZooDbHelper extends ComunDbHelper {
    public ZooDbHelper(Context context) {
        super(context);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + ZooContract.UserEntry.TABLE_NAME + " ("
                + ZooContract.UserEntry.IDZOO + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ZooContract.UserEntry.NOMBRE + "TEXT NOT NULL, "
                + ZooContract.UserEntry.DIMENSIONES + "INTEGER NOT NULL, "
                + ZooContract.UserEntry.CIUDAD + " TEXT NOT NULL,"
                + ZooContract.UserEntry.PAIS + " TEXT NOT NULL,"
                + ZooContract.UserEntry.PRESUPUESTOANUAL + "INTEGER NOT NULL)"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    public long save(Zoo zoo) {
        return super.save(ZooContract.UserEntry.TABLE_NAME,
                zoo.toContentValues());
    }

    public List<Zoo> getAll() {
        List<Zoo> zoo = null;
        Cursor cursor = null;

        try {
            cursor = super.getAll(ZooContract.UserEntry.TABLE_NAME,
                    null, null, null,
                    null, null, null);

            if(cursor.moveToFirst()){
                zoo = new ArrayList<>();
                do {
                    @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(ZooContract.UserEntry.NOMBRE));
                    @SuppressLint("Range") int dimensiones = cursor.getInt(cursor.getColumnIndex(ZooContract.UserEntry.DIMENSIONES));
                    @SuppressLint("Range") String ciudad = cursor.getString(cursor.getColumnIndex(ZooContract.UserEntry.CIUDAD));
                    @SuppressLint("Range") String pais = cursor.getString(cursor.getColumnIndex(ZooContract.UserEntry.PAIS));
                    @SuppressLint("Range") int presupuestoAnual = cursor.getInt(cursor.getColumnIndex(ZooContract.UserEntry.PRESUPUESTOANUAL));
                    Zoo zooEntries = new Zoo( nombre, pais, ciudad, dimensiones, presupuestoAnual);
                    zoo.add(zooEntries);
                } while (cursor.moveToNext());
                return zoo;
            }
        } catch (Exception exception) {}

        finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

        return Collections.emptyList();

    }

    public int delete(String id) {
        return super.delete(UserContract.UserEntry.TABLE_NAME,
                IdeaContract.IdeaEntry._ID + " = ?",
                new String[]{id});
    }

    public int update(Idea idea, String id) {
        return super.update(IdeaContract.IdeaEntry.TABLE_NAME,
                idea.toContentValues(),
                IdeaContract.IdeaEntry._ID + " = ?",
                new String[]{id});
    }
}
