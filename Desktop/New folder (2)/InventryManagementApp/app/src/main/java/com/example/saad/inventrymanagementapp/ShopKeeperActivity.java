package com.example.saad.inventrymanagementapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ShopKeeperActivity extends AppCompatActivity {

    Button addItem;
    Button searchItem;
    Button updateItem;
    Button deleteAnItem;
    Button deleteAllItem;
    sql_Connection mySQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_keeper);

        mySQL = new sql_Connection(ShopKeeperActivity.this);

        addItem = (Button) findViewById(R.id.btnAddItem);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),NewItemAddActivity.class));
            }
        });

        searchItem = (Button) findViewById(R.id.btnSearchItem);
        searchItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SearchAnItemActivity.class));
            }
        });

        updateItem = (Button)findViewById(R.id.btnUpdateItem);
        updateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),UpdateAnItemActivity.class));
            }
        });
        deleteAnItem = (Button)findViewById(R.id.btnDeleteItem);
        deleteAnItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DeleteAnItemActivity.class));
            }
        });
        deleteAllItem = (Button)findViewById(R.id.btnDeleteAllItem);
        deleteAllItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySQL.deleteAllData();
                Toast.makeText(getApplicationContext(),"All Items Deleted!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
