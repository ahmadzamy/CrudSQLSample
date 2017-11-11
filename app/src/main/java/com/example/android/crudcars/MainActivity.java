package com.example.android.crudcars;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import static com.example.android.crudcars.ContractClass.*;
import static com.example.android.crudcars.ContractClass.ContraCtontract.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton addButton;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.add_Button);
        listView = findViewById(R.id.list_item);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
     listItems();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.item1:

                listItems();
                Toast.makeText(this, "Refreshing", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);

    }

    public void listItems() {
        Cursor cursor=getContentResolver().query(CAR_URI,null,null,null,null);

        ArrayList<CarData> Array=new ArrayList<>();

        while (cursor.moveToNext()){
            int id=cursor.getInt(cursor.getColumnIndex(ID));
            String CarName = cursor.getString(cursor.getColumnIndex(CAR_NAME));
            String CarColor = cursor.getString(cursor.getColumnIndex(CAR_COLOR));
            int Model = cursor.getInt(cursor.getColumnIndex(MODEL));
            int CarPrice = cursor.getInt(cursor.getColumnIndex(CAR_PRICE));

            CarData datas = new CarData(id, CarName, CarColor, Model, CarPrice);
            Array.add(datas);

        }
        cursor.close();
        Adapter adapter = new Adapter(this, R.layout.items_car, Array);
        listView.setAdapter(adapter);

    }

}
