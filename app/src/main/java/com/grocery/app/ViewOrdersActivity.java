package com.grocery.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ViewOrdersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_orders);

        DBHelper dbHelper = new DBHelper(this);
        List<OrderItem> items = dbHelper.getOrders();


        String fulltext = "";

        for(OrderItem item: items){
            String rowText = "";
            rowText += item.getFullnames()+"\n";
            rowText += item.getLocation()+"\n";
            rowText += item.getPhone()+"\n";
            rowText += item.getProductname()+"\n";
            rowText += item.getAmount()+"\n\n";

            fulltext += rowText;

        }

        TextView textView = findViewById(R.id.view_orders_listView);
        textView.setText(fulltext);
    }
}