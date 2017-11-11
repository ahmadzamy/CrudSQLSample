package com.example.android.crudcars;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.example.android.crudcars.ContractClass.AUTHORITY;
import static com.example.android.crudcars.ContractClass.ContraCtontract.CAR_COLOR;
import static com.example.android.crudcars.ContractClass.ContraCtontract.CAR_NAME;
import static com.example.android.crudcars.ContractClass.ContraCtontract.CAR_PRICE;
import static com.example.android.crudcars.ContractClass.ContraCtontract.ID;
import static com.example.android.crudcars.ContractClass.ContraCtontract.MODEL;
import static com.example.android.crudcars.ContractClass.ContraCtontract.TABLE_NAME;

/**
 * Created by Ahmad Siafaddin on 11/7/2017.
 */

public class provider extends ContentProvider {
    HelperClass helperClass;

    final static UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(AUTHORITY, TABLE_NAME, 1);
        URI_MATCHER.addURI(AUTHORITY, TABLE_NAME + "/#", 2);

    }

    @Override
    public boolean onCreate() {
        helperClass = new HelperClass(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        int code = URI_MATCHER.match(uri);
        String arg[] = {ID, CAR_NAME, CAR_COLOR, MODEL, CAR_PRICE};
        if (code == 1) {
            Cursor cursor = helperClass.getReadableDatabase().query(TABLE_NAME, arg, null, null, null, null, null);
            return cursor;
        } else if (code == 2) {
            long id = ContentUris.parseId(uri);
            Cursor cursor = helperClass.getReadableDatabase().query(TABLE_NAME, arg, ID + "=?", new String[]{String.valueOf(id)}, null, null, null);
            return cursor;
        }
        return null;

    }


    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        helperClass.getWritableDatabase().insert(TABLE_NAME, null, contentValues);
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        helperClass.getWritableDatabase().delete(TABLE_NAME, s, strings);
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        helperClass.getWritableDatabase().update(TABLE_NAME, contentValues, s, strings);
        return 0;
    }
}
