package com.mihaita.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        long dateMillis;

        Button btnAdd = findViewById(R.id.btn_addNote);
        Button btnCancel= findViewById(R.id.btn_cancel);
        CalendarView calendar = findViewById(R.id.calendarView);

        //adding the date
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String selectedDate = year + "/" + month + "/" +dayOfMonth;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                try {
                    Date date = sdf.parse(selectedDate);
                    long dateMillis = date.getTime();

                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }
        });

        //adding all the records
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBClass dbc = new DBClass(getApplicationContext());


                EditText editFood = findViewById(R.id.edit_foodName_add);
                EditText editCalories = findViewById(R.id.edit_calories_add);
                EditText editQuantity = findViewById(R.id.edit_quantity_add);

                Foods newFood = new Foods(500,
                        editFood.getText().toString(),
                        Integer.valueOf(editCalories.getText().toString()),
                        Integer.valueOf(editQuantity.getText().toString()));

                dbc.addFood(newFood);

                Toast.makeText(getApplicationContext(),"Food Added",Toast.LENGTH_LONG).show();


            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),MainActivity.class);
                startActivity(i);
            }
        });


    }
}
