package com.example.saad.inventrymanagementapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewItemAddActivity extends AppCompatActivity {
    Button btn;
    Button addItemButton;
    EditText id;
    EditText name;
    EditText type;
    EditText pictureID;
    EditText manufacturer;
    EditText cost;
    EditText sell;
    EditText isAvailable;
    EditText numbers;

    sql_Connection sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item_add);

        sql = new sql_Connection(NewItemAddActivity.this);

        id = (EditText)findViewById(R.id.addID1);
        name = (EditText)findViewById(R.id.addName1);
        type = (EditText)findViewById(R.id.addType1);
        pictureID = (EditText)findViewById(R.id.addPicture1);
        manufacturer = (EditText)findViewById(R.id.addManufacturer1);
        cost = (EditText)findViewById(R.id.addCostPrice1);
        sell = (EditText)findViewById(R.id.addSellPrice1);
        isAvailable = (EditText)findViewById(R.id.addIsAvailable1);
        numbers = (EditText)findViewById(R.id.addNumbers1);
        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();

                try {
                    boolean a = sql.insertData(Integer.parseInt(id.getText().toString()), name.getText().toString(), type.getText().toString(), Integer.parseInt(pictureID.getText().toString()), manufacturer.getText().toString(), Double.parseDouble(cost.getText().toString()), Double.parseDouble(sell.getText().toString()), isAvailable.getText().toString(), Integer.parseInt(numbers.getText().toString()));
                    if(a == false){
                        Toast.makeText(getApplicationContext(),"Error in saving dada",Toast.LENGTH_LONG).show();
                    }
                    else {
                        // AlertDialog dialog = new AlertDialog(NewItemAddActivity.this);
                        // dialog.setCancelable(true);
                        // dialog.setTitle("Access Granted");
                        // dialog.setMessage("Data Successfully Saved.");
                        Toast.makeText(getApplicationContext(),"Data saved Successfully",Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception ex){
                    Log.d("In NewITemAddActivity","Exception: "+ex.getMessage());
                    Toast.makeText(getApplicationContext(),"Exception: "+ex.getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

}
