package com.example.android.crudcars;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.android.crudcars.ContractClass.ContraCtontract.CAR_URI;

public class AddActivity extends AppCompatActivity {

    Button add;
    EditText name;
    EditText color;
    EditText model;
    EditText price;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Section");
        setContentView(R.layout.activity_add_edit);

        add = findViewById(R.id.add_button);
        name = findViewById(R.id.edit_name);
        color = findViewById(R.id.edit_color);
        model = findViewById(R.id.edit_model);
        price = findViewById(R.id.edit_price);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperClass helperClass = new HelperClass(AddActivity.this);
                SQLiteDatabase write = helperClass.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("CarName", name.getText().toString());
                contentValues.put("CarColor", color.getText().toString());
                contentValues.put("Model", model.getText().toString());
                contentValues.put("CarPrice", price.getText().toString());

                getContentResolver().insert(CAR_URI, contentValues);
                Toast.makeText(AddActivity.this, "you Added An element", Toast.LENGTH_SHORT).show();

                finish();

            }

        });

      /*  save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HelperClass helperClass = new HelperClass(AddActivity.this);
                SQLiteDatabase read = helperClass.getReadableDatabase();

                String fields[] = {"id", "CarName", "CarColor", "Model", "CarPrice"};

                Cursor cursor = read.query("Car", fields, null, null, null, null, null);

                ArrayList<CarData> Array = new ArrayList<>();
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(0);
                    String CarName = cursor.getString(1);
                    String CarColor = cursor.getString(2);
                    int Model = cursor.getInt(3);
                    int CarPrice = cursor.getInt(4);


                    CarData datas = new CarData(id, CarName, CarColor, Model, CarPrice);
                    Array.add(datas);

                }
                Intent intent=new Intent(AddActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }*/
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
