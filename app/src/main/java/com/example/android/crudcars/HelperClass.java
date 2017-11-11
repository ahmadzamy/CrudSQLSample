package com.example.android.crudcars; /**
 * Created by Ahmad Siafaddin on 11/2/2017.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.android.crudcars.ContractClass.ContraCtontract.*;

/**
 * Created by Ahmad Siafaddin on 11/1/2017.
 */

public class HelperClass extends SQLiteOpenHelper {
    public HelperClass(Context context){
        super(context,"Car.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(" + ID +" INTEGER PRIMARY KEY, " + CAR_NAME +" TEXT, " + CAR_COLOR +" TEXT," + MODEL + " INTEGER," + CAR_PRICE + " INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
