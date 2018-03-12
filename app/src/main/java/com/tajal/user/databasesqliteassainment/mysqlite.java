package com.tajal.user.databasesqliteassainment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 2/10/2018.
 */

public class mysqlite extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="mydatabase.db";
    private static final String TABLE_NAME="mytable";
    private static final String COULMN_1="ID";
    private static final String COULMN_2="FRIST_NAME";
    private static final String COULMN_3="LAST_NAME";
    private static final String COULMN_4="EMAIL";


    public mysqlite(Context context) {

        super(context, TABLE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    String quary;
    quary = " CREATE TABLE " + TABLE_NAME + "(" + COULMN_1 + " INTEGER PRIMARY KEY ," + COULMN_2 + " TEXT ," + COULMN_3 + " TEXT ," + COULMN_4 + " TEXT " +")";
    db.execSQL(quary);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate(db);

    }
    public boolean addtoTable (String ID,String Frist_Name,String Last_Name,String Email){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COULMN_1 ,ID);
        contentValues.put(COULMN_2 ,Frist_Name);
        contentValues.put(COULMN_3 ,Last_Name);
        contentValues.put(COULMN_4 ,Email);
        long checker=db.insert(TABLE_NAME,null,contentValues);
        if(checker==-1){
            return false;
        }
        else {
            return true;
        }

    }
   public Cursor display()
   {
     SQLiteDatabase db=getReadableDatabase();
     Cursor res;
     res=db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
     return res;

   }

}
