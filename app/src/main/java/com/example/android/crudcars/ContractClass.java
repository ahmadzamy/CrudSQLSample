package com.example.android.crudcars;

import android.net.Uri;
import android.provider.BaseColumns;


/**
 * Created by Ahmad Siafaddin on 11/7/2017.
 */

public class ContractClass  {

    public ContractClass() {
    }
    public static final String AUTHORITY="com.example.android.crudcars";

    public static class ContraCtontract implements BaseColumns{


        public static final String TABLE_NAME ="Car";
        public static final String ID="id";
        public static  final String CAR_NAME="CarName";
        public static  final String CAR_COLOR="CarColor";
        public static  final String MODEL="Model";
        public static  final String CAR_PRICE="CarPrice";

        public static final Uri CAR_URI=Uri.parse("content://"+AUTHORITY+"/"+ TABLE_NAME);

    }
}
