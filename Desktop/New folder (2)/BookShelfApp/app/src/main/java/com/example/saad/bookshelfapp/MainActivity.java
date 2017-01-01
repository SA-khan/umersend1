package com.example.saad.bookshelfapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText book;
    EditText author;
    Button btn;
    String[] datasource = new String[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv);
        book = (EditText) findViewById(R.id.Book_Name);
        author = (EditText) findViewById(R.id.Book_Author);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Please Wait...");
                async myasync = new async();
                myasync.execute();



            }
        });
    }

    public String[] getData() {

        try {
            URL myurl = new URL("https://www.googleapis.com/books/v1/volumes?q=" + book.getText().toString() + "+" + author.getText().toString() + "&key=AIzaSyBN653q6xtUUrCBCvi49UiyHdLINVSQmqw");
            HttpURLConnection connection = (HttpURLConnection) myurl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String completeData = "";
            String tempData = null;
            while ((tempData = bufferedReader.readLine()) != null) {
                completeData += tempData;
            }
            Log.d("Data", "<><><> " + completeData);

            String[] result = parseJSON(completeData);
            return result;

        }
        catch (Exception ex) {
            Log.d("Exception3", " -> " + ex.getMessage());
            return null;
        }
    }

    public String[] parseJSON(String JsonString) {
        String[] data = new String[31];
        try {
            JSONObject obj = new JSONObject(JsonString);
            //JSONArray items = obj.getJSONArray("items");
            //JSONObject firstindex = items.getJSONObject(0);
            //data[0] = firstindex.getString("selflink");
            //JSONArray first = firstindex.getJSONArray("volumeInfo");
            //JSONObject f = first.getJSONObject(0);
            //data[1] = f.getString("title");
            data[0] = obj.getString("totalItems");
            JSONArray items = obj.getJSONArray("items");
            JSONObject firstobj = items.getJSONObject(0);
            data[1] = firstobj.getString("selfLink");
            JSONObject firstobjinside = firstobj.getJSONObject("volumeInfo");
            data[2] = firstobjinside.getString("title");
            JSONArray firstarrayinside = firstobjinside.getJSONArray("authors");
            data[3] = firstarrayinside.get(0).toString();

            JSONObject secondobj = items.getJSONObject(1);
            data[4] = secondobj.getString("selfLink");
            JSONObject secondobjinside = secondobj.getJSONObject("volumeInfo");
            data[5] = secondobjinside.getString("title");
            JSONArray secondarrayinside = secondobjinside.getJSONArray("authors");
            data[6] = secondarrayinside.get(0).toString();

            JSONObject thirdobj = items.getJSONObject(2);
            data[7] = thirdobj.getString("selfLink");
            JSONObject thirdobjinside = thirdobj.getJSONObject("volumeInfo");
            data[8] = thirdobjinside.getString("title");
            JSONArray thirdarrayinside = thirdobjinside.getJSONArray("authors");
            data[9] = thirdarrayinside.get(0).toString();

            JSONObject fourthobj = items.getJSONObject(3);
            data[10] = fourthobj.getString("selfLink");
            JSONObject fourthobjinside = fourthobj.getJSONObject("volumeInfo");
            data[11] = fourthobjinside.getString("title");
            JSONArray fourtharrayinside = fourthobjinside.getJSONArray("authors");
            data[12] = fourtharrayinside.get(0).toString();

            JSONObject fifthobj = items.getJSONObject(4);
            data[13] = fifthobj.getString("selfLink");
            JSONObject fifthobjinside = fifthobj.getJSONObject("volumeInfo");
            data[14] = fifthobjinside.getString("title");
            JSONArray fiftharrayinside = fifthobjinside.getJSONArray("authors");
            data[15] = fiftharrayinside.get(0).toString();

            JSONObject sixthobj = items.getJSONObject(5);
            data[16] = sixthobj.getString("selfLink");
            JSONObject sixthobjinside = sixthobj.getJSONObject("volumeInfo");
            data[17] = sixthobjinside.getString("title");
            JSONArray sixtharrayinside = sixthobjinside.getJSONArray("authors");
            data[18] = sixtharrayinside.get(0).toString();

            JSONObject seventhobj = items.getJSONObject(6);
            data[19] = seventhobj.getString("selfLink");
            JSONObject seventhobjinside = seventhobj.getJSONObject("volumeInfo");
            data[20] = seventhobjinside.getString("title");
            JSONArray seventharrayinside = seventhobjinside.getJSONArray("authors");
            data[21] = seventharrayinside.get(0).toString();

            JSONObject eighthobj = items.getJSONObject(7);
            data[22] = eighthobj.getString("selfLink");
            JSONObject eighthobjinside = eighthobj.getJSONObject("volumeInfo");
            data[23] = eighthobjinside.getString("title");
            JSONArray eightharrayinside = eighthobjinside.getJSONArray("authors");
            data[24] = eightharrayinside.get(0).toString();

            JSONObject ninethobj = items.getJSONObject(8);
            data[25] = ninethobj.getString("selfLink");
            JSONObject ninethobjinside = ninethobj.getJSONObject("volumeInfo");
            data[26] = ninethobjinside.getString("title");
            JSONArray ninetharrayinside = ninethobjinside.getJSONArray("authors");
            data[27] = ninetharrayinside.get(0).toString();

            JSONObject tenthobj = items.getJSONObject(9);
            data[28] = tenthobj.getString("selfLink");
            JSONObject tenthobjinside = tenthobj.getJSONObject("volumeInfo");
            data[29] = tenthobjinside.getString("title");
            JSONArray tentharrayinside = tenthobjinside.getJSONArray("authors");
            data[30] = tentharrayinside.get(0).toString();

            return data;

        }
        catch (Exception ex) {
            Log.d("Exception1", "" + ex.getMessage());
            return null;
        }
    }

    public class async extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            //Toast.makeText(getApplicationContext(),"Hello in doInBackground",Toast.LENGTH_SHORT).show();
            //a();

            try {
                Log.d("MainActivity", "Hello in doInBackground");

                String[] metaObject = getData();
                for(int i = 0 ; i <31 ; i++){
                    datasource[i] = metaObject[i];
                }


                return metaObject;
            }
            catch (Exception e) {
                Log.d("Exception2", " " + e.getMessage());
                return null;
            }
        }

        @Override
        protected void onPostExecute(String[] jsonObj) {
            super.onPostExecute(jsonObj);
            try {

                Toast.makeText(getApplicationContext(),"Hello in onPostExecute "+jsonObj[0],Toast.LENGTH_SHORT).show();
                datasource[0] = jsonObj[0];
                if(datasource[0] != null)
                    tv.setText("Total Records Are: "+ datasource[0].toString());

                ArrayList<Book> list = new ArrayList<Book>();
                list.add(new Book(jsonObj[2],jsonObj[3], jsonObj[1]));
                list.add(new Book(jsonObj[5],jsonObj[6], jsonObj[4]));
                list.add(new Book(jsonObj[8],jsonObj[9], jsonObj[7]));
                list.add(new Book(jsonObj[11],jsonObj[12], jsonObj[10]));
                list.add(new Book(jsonObj[14],jsonObj[15], jsonObj[13]));
                list.add(new Book(jsonObj[17],jsonObj[18], jsonObj[16]));
                list.add(new Book(jsonObj[20],jsonObj[21], jsonObj[19]));
                list.add(new Book(jsonObj[23],jsonObj[24], jsonObj[22]));
                list.add(new Book(jsonObj[26],jsonObj[27], jsonObj[25]));
                list.add(new Book(jsonObj[29],jsonObj[30], jsonObj[28]));

                bookAdapter adapter = new bookAdapter(MainActivity.this, list);
                ListView rootView = (ListView) findViewById(R.id.rootView);

                rootView.setAdapter(adapter);



            }
            catch (Exception e) {
                e.printStackTrace();
                Log.d("MainActivity", "Exception abc -- " + e.getMessage());
            }
        }
    }
}
