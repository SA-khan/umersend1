package com.example.saad.inventrymanagementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateAnItemActivity extends AppCompatActivity {

    Button btn;
    EditText id;
    EditText name;
    EditText type;
    EditText pictureID;
    EditText manufacturer;
    EditText cost;
    EditText sell;
    EditText isAvailable;
    EditText numbers;

    sql_Connection mySQL = new sql_Connection(UpdateAnItemActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_an_item);

        id = (EditText)findViewById(R.id.updateID1);
        name = (EditText)findViewById(R.id.updateName1);
        type = (EditText)findViewById(R.id.updateType1);
        pictureID = (EditText)findViewById(R.id.updatePicture1);
        manufacturer = (EditText)findViewById(R.id.updateManufacturer1);
        cost = (EditText)findViewById(R.id.updateCostPrice1);
        sell = (EditText)findViewById(R.id.updateSellPrice1);
        isAvailable = (EditText)findViewById(R.id.updateIsAvailable1);
        numbers = (EditText)findViewById(R.id.updateNumbers1);
        btn = (Button)findViewById(R.id.updatebtn);

        id.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                btn.setEnabled(true);
                return false;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                int updateId = Integer.parseInt(id.getText().toString());
                String updateName = name.getText().toString();
                String updateType = type.getText().toString();
                int updatePictureId = Integer.parseInt(pictureID.getText().toString());
                String updateManufacturer = manufacturer.getText().toString();
                double updateCost = Double.parseDouble(cost.getText().toString());
                double updateSell = Double.parseDouble(sell.getText().toString());
                String updateIsAvailable = isAvailable.getText().toString();
                int updateNumbers = Integer.parseInt(numbers.getText().toString());
                boolean a = mySQL.updateData(updateId, updateName, updateType, updatePictureId, updateManufacturer, updateCost, updateSell, updateIsAvailable, updateNumbers );
                if(a){
                    Toast.makeText(getApplicationContext(),"Data Successfully updated",Toast.LENGTH_SHORT).show();
                }
                }
                catch (Exception ex){
                    Log.d("ex"," "+ex.getMessage());
                }

            }
        });

    }
}
