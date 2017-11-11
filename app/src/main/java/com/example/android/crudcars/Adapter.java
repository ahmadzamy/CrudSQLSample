package com.example.android.crudcars;

/**
 * Created by Ahmad Siafaddin on 11/2/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.crudcars.ContractClass.ContraCtontract.CAR_URI;
import static com.example.android.crudcars.ContractClass.ContraCtontract.ID;

/**
 * Created by Ahmad Siafaddin on 11/1/2017.
 */

public class Adapter extends ArrayAdapter<CarData> {
    Context context;
    int resourse;
    ArrayList<CarData> objects;

    public Adapter(@NonNull Context context, int resource, @NonNull ArrayList<CarData> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resourse = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resourse, null);
        }
        TextView name = convertView.findViewById(R.id.car_name);
        TextView theId = convertView.findViewById(R.id.the_id);
        TextView color = convertView.findViewById(R.id.car_color);
        TextView model = convertView.findViewById(R.id.car_model);
        TextView price = convertView.findViewById(R.id.car_Price);
        ImageButton delete = convertView.findViewById(R.id.delete);
        CardView Card = convertView.findViewById(R.id.card);

        final CarData datas = objects.get(position);

        name.setText(datas.getCarName());
        color.setText(datas.getCarColor());
        model.setText(String.valueOf(datas.getModel()));
        price.setText(String.valueOf(datas.getCarPrice()));
        theId.setText(String.valueOf(datas.getId()));


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperClass helperClass = new HelperClass(context);
                SQLiteDatabase write = helperClass.getWritableDatabase();


                String[] args = {String.valueOf(datas.getId())};
                getContext().getContentResolver().delete(CAR_URI, ID + "= ?", args);

                objects.remove(position);
                notifyDataSetChanged();

            }
        });

        Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtra(ID, datas.getId());

                getContext().startActivity(intent);
            }
        });


        return convertView;
    }


}
