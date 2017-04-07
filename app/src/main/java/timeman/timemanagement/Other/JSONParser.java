package timeman.timemanagement.Other;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONParser {
    static JSONArray jarray = null;
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public JSONArray getJSONFromUrl(String url) throws MalformedURLException {
        String builder = null;
        StringBuilder sb = new StringBuilder();
        InputStream is = null;

        try {
            URL urlObj = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) urlObj.openConnection();
            is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            int status = urlConnection.getResponseCode();
            jarray=new JSONArray(String.valueOf(sb));

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jarray;
    }
    public JSONArray loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("java_topics.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        try {
            return new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    public JSONArray getInfoFromJSON(String jSONArrayName,JSONObject jsonObj,String[] stringNames){
        int stringArrLen=stringNames.length;
        JSONArray m_jArry = null;
        try {
             m_jArry = jsonObj.getJSONArray(jSONArrayName);
            for(int i =0;i<m_jArry.length();i++){
                JSONObject jObj=m_jArry.getJSONObject(i);

            }

        } catch (JSONException e) {
            e.printStackTrace();

        }
        return m_jArry;
    }
}