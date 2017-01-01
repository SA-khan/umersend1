package com.example.saad.newsfeedapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class newsList extends AppCompatActivity {
    TextView ab;
    String title;
    String category;
    String rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        ab = (TextView)findViewById(R.id.a);

        Intent myIntent = getIntent();
        myIntent.getData();
        title = myIntent.getStringExtra("title");
        category = myIntent.getStringExtra("category");
        rating = myIntent.getStringExtra("rating");


        ab.setText(title + " | " + category );

        saad myasync = new saad();
        myasync.execute();

    }
    public String[] getData(){
        //String[] result;

        try {
            URL myurl = new URL("https://newsapi.org/v1/articles?source="+title+"&sortBy="+category+"&apiKey=838c28ddf0fa469fac07755f7ae1cc97");
            HttpURLConnection connection = (HttpURLConnection) myurl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String completeData = "";
            String tempData = null;
            while ((tempData = bufferedReader.readLine())!= null){
                completeData += tempData;
            }
            Log.d("Data","<><><> "+completeData);
            String[] result = parseJSON(completeData);
            return result;

        }
        catch (Exception ex){
            Log.d("Exception" , " -> "+ex.getMessage());
            return null;

        }


    }
    public String[] parseJSON(String result){
        String[] data = new String[65];
        try{
            JSONObject jsonObject = new JSONObject(result);
                data[0] = jsonObject.getString("status");
                data[1] = jsonObject.getString("source");
                data[2] = jsonObject.getString("sortBy");
                JSONArray article = jsonObject.getJSONArray("articles");
                JSONObject article1 = article.getJSONObject(0);
                data[3] = article1.getString("title");
                data[4] = article1.getString("author");
                data[5] = article1.getString("description");
                if (article1.getString("url").isEmpty() == false)
                    data[6] = article1.getString("url");
                if (article1.getString("urlToImage").isEmpty() == false)
                    data[7] = article1.getString("urlToImage");
                if (article1.getString("publishedAt").isEmpty() == false)
                    data[8] = article1.getString("publishedAt");

                JSONObject article2 = article.getJSONObject(1);
                data[9] = article2.getString("title");
                data[10] = article2.getString("author");
                data[11] = article2.getString("description");
                if (article2.getString("url").isEmpty() == false)
                    data[12] = article2.getString("url");
                if (article2.getString("urlToImage").isEmpty() == false)
                    data[13] = article2.getString("urlToImage");
                if (article2.getString("publishedAt").isEmpty() == false)
                    data[14] = article2.getString("publishedAt");

                JSONObject article3 = article.getJSONObject(2);
                data[15] = article3.getString("title");
                data[16] = article3.getString("author");
                data[17] = article3.getString("description");
                if (article3.getString("url").isEmpty() == false)
                    data[18] = article3.getString("url");
                if (article3.getString("urlToImage").isEmpty() == false)
                    data[19] = article3.getString("urlToImage");
                if (article3.getString("publishedAt").isEmpty() == false)
                    data[20] = article3.getString("publishedAt");

                JSONObject article4 = article.getJSONObject(3);
                data[21] = article4.getString("title");
                data[22] = article4.getString("author");
                data[23] = article4.getString("description");
                if (article4.getString("url").isEmpty() == false)
                    data[24] = article4.getString("url");
                if (article4.getString("urlToImage").isEmpty() == false)
                    data[25] = article4.getString("urlToImage");
                if (article4.getString("publishedAt").isEmpty() == false)
                    data[26] = article4.getString("publishedAt");

                JSONObject article5 = article.getJSONObject(4);
                data[27] = article5.getString("title");
                data[28] = article5.getString("author");
                data[29] = article5.getString("description");
                if (article5.getString("url").isEmpty() == false)
                    data[30] = article5.getString("url");
                if (article5.getString("urlToImage").isEmpty() == false)
                    data[31] = article5.getString("urlToImage");
                if (article5.getString("publishedAt").isEmpty() == false)
                    data[32] = article5.getString("publishedAt");

                JSONObject article6 = article.getJSONObject(5);
                data[33] = article6.getString("title");
                data[34] = article6.getString("author");
                data[35] = article6.getString("description");
                if (article6.getString("url").isEmpty() == false)
                    data[36] = article6.getString("url");
                if (article6.getString("urlToImage").isEmpty() == false)
                    data[37] = article6.getString("urlToImage");
                if (article6.getString("publishedAt").isEmpty() == false)
                    data[38] = article6.getString("publishedAt");

                JSONObject article7 = article.getJSONObject(6);
                data[39] = article7.getString("title");
                data[40] = article7.getString("author");
                data[41] = article7.getString("description");
                if (article7.getString("url").isEmpty() == false)
                    data[42] = article7.getString("url");
                if (article7.getString("urlToImage").isEmpty() == false)
                    data[43] = article7.getString("urlToImage");
                if (article7.getString("publishedAt").isEmpty() == false)
                    data[44] = article7.getString("publishedAt");

                JSONObject article8 = article.getJSONObject(7);
                data[45] = article8.getString("title");
                data[46] = article8.getString("author");
                data[47] = article8.getString("description");
                if (article8.getString("url").isEmpty() == false)
                    data[48] = article8.getString("url");
                if (article8.getString("urlToImage").isEmpty() == false)
                    data[49] = article8.getString("urlToImage");
                if (article8.getString("publishedAt").isEmpty() == false)
                    data[50] = article8.getString("publishedAt");

                JSONObject article9 = article.getJSONObject(8);
                data[51] = article9.getString("title");
                data[52] = article9.getString("author");
                data[53] = article9.getString("description");
                if (article9.getString("url").isEmpty() == false)
                    data[54] = article9.getString("url");
                if (article9.getString("urlToImage").isEmpty() == false)
                    data[55] = article9.getString("urlToImage");
                if (article9.getString("publishedAt").isEmpty() == false)
                    data[56] = article9.getString("publishedAt");

                JSONObject article10 = article.getJSONObject(9);
                data[57] = article10.getString("title");
                data[58] = article10.getString("author");
                data[59] = article10.getString("description");
                if (article10.getString("url").isEmpty() == false)
                    data[60] = article10.getString("url");
                if (article10.getString("urlToImage").isEmpty() == false)
                    data[61] = article10.getString("urlToImage");
                if (article10.getString("publishedAt").isEmpty() == false)
                    data[62] = article10.getString("publishedAt");
            return data;

        }
        catch (Exception ex){
            Log.d("Exception","<><<>"+ex.getMessage());
            return null;
        }
    }

    public class saad extends AsyncTask<Void,Void,String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            //Toast.makeText(getApplicationContext(), "Processing", Toast.LENGTH_LONG).show();
            Log.d("MainActivity", "Hello in doInBackground");
            String[] metaObject = getData();
            return metaObject;

        }

        @Override
        protected void onPostExecute(String[] jsonObj) {
            super.onPostExecute(jsonObj);
            try {
                Toast.makeText(getApplicationContext(), "Done Processing with progress:"+jsonObj[0], Toast.LENGTH_LONG).show();

                ArrayList<New> list = new ArrayList<New>();
                list.add(new New(jsonObj[3], jsonObj[4],jsonObj[8]));
                list.add(new New(jsonObj[9], jsonObj[10],jsonObj[14]));
                list.add(new New(jsonObj[15], jsonObj[16], jsonObj[20]));
                list.add(new New(jsonObj[21], jsonObj[22], jsonObj[26]));
                list.add(new New(jsonObj[27], jsonObj[28], jsonObj[32]));
                list.add(new New(jsonObj[33], jsonObj[34], jsonObj[38]));
                list.add(new New(jsonObj[39], jsonObj[40], jsonObj[44]));
                list.add(new New(jsonObj[45], jsonObj[46], jsonObj[50]));
                list.add(new New(jsonObj[51], jsonObj[52], jsonObj[56]));
                list.add(new New(jsonObj[57], jsonObj[58], jsonObj[62]));

                NewAdapter adapter = new NewAdapter(newsList.this, list);
                ListView rootView = (ListView) findViewById(R.id.rootView);
                rootView.setAdapter(adapter);

            }
            catch (Exception e) {
                e.printStackTrace();
                Log.d("MainActivity", "Exception -- " + e.getMessage());
            }
        }
    }
}
