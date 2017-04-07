package timeman.timemanagement.Other;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

import timeman.timemanagement.BaseActivity;
import timeman.timemanagement.InnerListActivity;
import timeman.timemanagement.R;

/**
 * Created by manisha on 3/4/17.
 */
public class TaskGridActivity extends BaseActivity{
    String apiURL="https://sheetsu.com/apis/v1.0/65990e4ef673";
    public static final String TAG_TOPIC = "topic";
    private GridView gridView;
    private ArrayList<HashMap<String, String>> topics;
    JSONArray jsonArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_grid_layout);
         gridView= (GridView) findViewById(R.id.gridview);

        topics=new ArrayList<>();
        new GetJSONDataAsync().execute();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent =new Intent(TaskGridActivity.this, InnerListActivity.class);
                startActivity(intent);
            }
        });

    }



    class GetJSONDataAsync extends AsyncTask<String, Void, JSONArray> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected JSONArray doInBackground(String... params) {

                JSONParser jsonParser=new JSONParser();
                try {
                    jsonArray = jsonParser.getJSONFromUrl("https://sheetsu.com/apis/v1.0/65990e4ef673");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                topics = new ArrayList<HashMap<String,String>>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonobj = jsonArray.getJSONObject(i);
                        String topic=jsonobj.getString("Topic");
                        HashMap<String,String> map=new HashMap<>();
                        map.put("topic",topic);
                        topics.add(map);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                return jsonArray;
            }

            @Override
    protected void onPostExecute(JSONArray s) {
        super.onPostExecute(s);

        gridView.setAdapter(new TopicAdaptor(TaskGridActivity.this,topics,0));
    }
}
}
