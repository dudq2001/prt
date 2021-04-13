package com.example.doquangdu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doquangdu.database.AppDatabase;
import com.example.doquangdu.database.ProductEntity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText Name, Qty;
    private Button Add,View;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getAppDatabase(this);
        initview();
    }
    private void initview(){
        Name =(EditText) findViewById(R.id.name);
        Qty = (EditText) findViewById(R.id.quantity);
        Add = (Button) findViewById(R.id.add);
        View = (Button) findViewById(R.id.view);
        Add.setOnClickListener(this);
    }
    private void onAdd(){
        if(Name.getText().toString().isEmpty()){
            Toast.makeText(this,"Please enter product",Toast.LENGTH_LONG).show();
            return;
        }
        if(Qty.getText().toString().isEmpty()){
            Toast.makeText(this,"Please enter quantity",Toast.LENGTH_LONG).show();
            return;
        }
        ProductEntity product = new ProductEntity();
        product.name = Name.getText().toString();
        int qty = Integer.valueOf(Qty.getText().toString());
        product.quantity = qty;
        db.productDao().insertProduct(product);
        Toast.makeText(getApplicationContext(),"Data Save",Toast.LENGTH_LONG).show();
        Name.setText("");
        Qty.setText("");
    }
    private void onView(){
        Intent intent = new Intent(MainActivity.this,ListProduct.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if(v == Add){
            onAdd();
        }
        if(v == View){
            onView();
        }
    }
}