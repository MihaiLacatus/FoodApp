package com.mihaita.foodapp;

public class Foods {

    public static final String TABLE_NAME = "food_app";

    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_FOOD = "food_name";
    public static final String COLUMN_CALORIES = "calories";
    public static final String COLUMN_QUANTITY = "quantity";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_DATE + " LONG," +
                    COLUMN_FOOD + " TEXT," +
                    COLUMN_CALORIES + " INTEGER," +
                    COLUMN_QUANTITY + " INTEGER)";

    long date;
    String foodName;
    Integer calories;
    Integer quantity;

    public Foods(long date, String foodName, Integer calories, Integer quantity) {
        this.date = date;
        this.foodName = foodName;
        this.calories = calories;
        this.quantity = quantity;
    }

    public Foods() {
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
