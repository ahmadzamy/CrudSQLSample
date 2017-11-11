package com.example.android.crudcars;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.Settings.NameValueTable.NAME;
import static com.example.android.crudcars.ContractClass.AUTHORITY;
import static com.example.android.crudcars.ContractClass.ContraCtontract.*;

public class EditActivity extends AppCompatActivity {
    Button editButton;
    EditText name;
    EditText color;
    EditText model;
    EditText price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Edidt Section");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editButton = findViewById(R.id.edit);


        name = findViewById(R.id.edit_name);
        color = findViewById(R.id.edit_color);
        model = findViewById(R.id.edit_model);
        price = findViewById(R.id.edit_price);

        final int id = getIntent().getIntExtra(ID,-1);
        Uri uri=Uri.parse("content://"+AUTHORITY+"/"+ TABLE_NAME+"/"+id);
        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        cursor.moveToNext();


       final int A = cursor.getInt(cursor.getColumnIndex(ID));
        String Name=cursor.getString(cursor.getColumnIndex(CAR_NAME));
        String Color=cursor.getString(cursor.getColumnIndex(CAR_COLOR));
        int Model=cursor.getInt(cursor.getColumnIndex(MODEL));
        String Price=cursor.getString(cursor.getColumnIndex(CAR_PRICE));



        name.setText(Name);
        color.setText(Color);
          model.setText(String.valueOf(Model));
        price.setText(Price);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                HelperClass helperClass = new HelperClass(EditActivity.this);
                SQLiteDatabase write = helperClass.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("CarName", name.getText().toString());
                contentValues.put("CarColor", color.getText().toString());
                contentValues.put("Model", model.getText().toString());
                contentValues.put("CarPrice", price.getText().toString());

                String[] args = {String.valueOf(A)};
               getContentResolver().update(CAR_URI,contentValues,ID + "= ?" , args);
                Toast.makeText(EditActivity.this, "The element  " + "(" + id + ")" +" is"+ " UpDated", Toast.LENGTH_SHORT).show();

             finish();

            }

        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }


}

