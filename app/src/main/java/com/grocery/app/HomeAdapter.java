package com.grocery.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class HomeAdapter extends BaseAdapter {

    Context context;
    List<GroceryItem> items;

    public HomeAdapter(Context context, List<GroceryItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.homeitem, viewGroup, false);

        TextView name  = view.findViewById(R.id.main_activity_item_name);
        name.setText(items.get(i).getName());
        TextView price  = view.findViewById(R.id.main_activity_item_price);
        price.setText(items.get(i).getPrice());
        ImageView image  = view.findViewById(R.id.main_activity_item_imageView);
        image.setImageResource(items.get(i).getImage());

        Button button = view.findViewById(R.id.buy_button);

        button.setOnClickListener(View->{
//            Toast.makeText(context, "You clicked: "+items.get(i).getName()         , Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, PayActivity.class);
            intent.putExtra("PRODUCT_NAME", items.get(i).getName());
            intent.putExtra("PRODUCT_PRICE", items.get(i).getPrice());
            intent.putExtra("PRODUCT_IMAGE", items.get(i).getImage());
            context.startActivity(intent);

        });

        return view;
    }
}
