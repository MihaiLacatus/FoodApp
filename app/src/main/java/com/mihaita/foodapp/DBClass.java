package com.mihaita.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

import java.util.ArrayList;
import java.util.List;

public class DBClass extends SQLiteOpenHelper {

    public static int DATABASE_VERSION = 1;
    public DBClass(Context context) {
        super(context, Foods.TABLE_NAME, null, DATABASE_VERSION);
    }

    public Foods addFood (Foods f)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Foods.COLUMN_DATE, f.getDate());
        values.put(Foods.COLUMN_FOOD, f.getFoodName());
        values.put(Foods.COLUMN_CALORIES, f.getCalories());
        values.put(Foods.COLUMN_QUANTITY, f.getQuantity());

        db.insert(Foods.TABLE_NAME,null,values);

        return f;
    }

    public List<Foods> getFoods(){
        SQLiteDatabase db = getReadableDatabase();

        String selectQuery = "select * from " + Foods.TABLE_NAME;

        Cursor c = db.rawQuery(selectQuery,null);

        List<Foods> foodsList = new ArrayList<>();

        if (c.moveToFirst()){

            do {
                Foods allFoods = new Foods();
                allFoods.date = c.getLong(c.getColumnIndex(Foods.COLUMN_DATE));
                allFoods.foodName = c.getString(c.getColumnIndex(Foods.COLUMN_FOOD));
                allFoods.calories = c.getInt(c.getColumnIndex(Foods.COLUMN_CALORIES));
                allFoods.quantity = c.getInt(c.getColumnIndex(Foods.COLUMN_QUANTITY));

                foodsList.add(allFoods);
            } while (c.moveToFirst());
        }

        db.close();
        return foodsList;

    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Foods.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
