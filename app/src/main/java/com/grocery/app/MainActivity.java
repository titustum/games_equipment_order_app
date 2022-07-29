package com.grocery.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.mainActvityGridView);
        List<GroceryItem> items = new ArrayList<>();

        items.add(new GroceryItem("Antennas", "@Ksh 2500", R.drawable.antennas));
        items.add(new GroceryItem("Volleybal Net", "@Ksh 4000", R.drawable.volleyball_net));
        items.add(new GroceryItem("Soccer Ball", "@Ksh 900", R.drawable.football));
        items.add(new GroceryItem("Soccer Net", "@Ksh 4000", R.drawable.football_net));
        items.add(new GroceryItem("lawn Tennis net", "@Ksh 7000", R.drawable.lwan_tennis_net));
        items.add(new GroceryItem("Whistle", "@Ksh 300", R.drawable.whistle2));
        items.add(new GroceryItem("Scorecard Volleyball", "@Ksh 2000", R.drawable.scorecard));
        items.add(new GroceryItem("Volleyball", "@Ksh 750", R.drawable.volleyball));

        HomeAdapter adapter = new HomeAdapter(this, items);
        gridView.setAdapter(adapter);

        FloatingActionButton floatingActionButton = findViewById(R.id.floating_button);
        floatingActionButton.setOnClickListener(View->{
            Intent intent = new Intent(MainActivity.this, ViewOrdersActivity.class);
            startActivity(intent);
        });
    }
}