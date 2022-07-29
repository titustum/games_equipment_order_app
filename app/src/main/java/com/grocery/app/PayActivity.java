package com.grocery.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PayActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        DBHelper dbHelper = new DBHelper(this);

        TextView productName = findViewById(R.id.pay_product_name);
        TextView productPrice = findViewById(R.id.pay_product_price);
        ImageView productImage = findViewById(R.id.pay_product_image);

        Bundle bundle = getIntent().getExtras();
        productImage.setImageResource(bundle.getInt("PRODUCT_IMAGE"));
        productName.setText(bundle.getString("PRODUCT_NAME"));
        productPrice.setText(bundle.getString("PRODUCT_PRICE"));

        EditText fullnamesEdtx = findViewById(R.id.pay_full_names_edtx);
        EditText locationEdtx = findViewById(R.id.pay_location_edtx);
        EditText phoneEdtx = findViewById(R.id.pay_phone_edtx);
        EditText amountEdtx = findViewById(R.id.pay_amount_edtx);
        Button submitOrder = findViewById(R.id.pay_submit_order_btn);

        submitOrder.setOnClickListener(View->{

            String pname = bundle.getString("PRODUCT_NAME");
            String fullnames = fullnamesEdtx.getText().toString().trim();
            String phone = phoneEdtx.getText().toString().trim();
            String location = locationEdtx.getText().toString();
            String amount = amountEdtx.getText().toString().trim();

            if (fullnamesEdtx.getText().toString().trim().length() > 3 && locationEdtx.getText().toString().trim().length() > 3){
                dbHelper.insertOrder(pname, fullnames, location, phone, amount);
                Toast.makeText(this, "Order submitted successfully!", Toast.LENGTH_SHORT).show();

                fullnamesEdtx.setText("");
                phoneEdtx.setText("");
                locationEdtx.setText("");
                amountEdtx.setText("");
            }else{
                Toast.makeText(this, "PLease fill all the details first!", Toast.LENGTH_SHORT).show();
            }

        });

    }
}