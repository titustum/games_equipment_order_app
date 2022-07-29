package com.grocery.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "grocery_database.db";
    private static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE orders (id INTEGER PRIMARY KEY AUTOINCREMENT, productname text, fullnames text, location text, phone text, amount text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS orders");
        onCreate(db);
    }

    public long insertOrder(String productname, String fullnames, String location, String phone, String amount){
        db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("productname", productname);
        contentValues.put("fullnames", fullnames);
        contentValues.put("location", location);
        contentValues.put("phone", phone);
        contentValues.put("amount", amount);
        return db.insert("orders", null, contentValues);
    }

    public List<OrderItem> getOrders(){
        List<OrderItem> orderItems = new ArrayList<>();
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM orders;", null);
        for (cursor.moveToFirst(); !cursor.isAfterLast();cursor.moveToNext()){
            orderItems.add(new OrderItem(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)));
        }
        return orderItems;
    }

}
