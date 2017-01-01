package com.example.saad.inventrymanagementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteAnItemActivity extends AppCompatActivity {

    Button btn;
    EditText itemID;
    sql_Connection mySQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_an_item);

        itemID = (EditText)findViewById(R.id.deleteItem1);
        btn = (Button)findViewById(R.id.btnDeleteItem);
        mySQL = new sql_Connection(DeleteAnItemActivity.this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = mySQL.deleteAnItem(Integer.parseInt(itemID.getText().toString()));
                if(result > 0){
                    Toast.makeText(getApplicationContext(),"Item Successfully Deleted!",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
