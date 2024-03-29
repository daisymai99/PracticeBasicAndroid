package com.example.android.asyncTask;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.android.model.Location;
import com.example.android.model.ModelConnom;
import com.example.android.model.OverView;
import com.example.android.model.Today;
import com.example.android.model.Total;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class AsyncTaskService extends AsyncTask<String,Integer, ModelConnom> {

    ModelConnom datas = new ModelConnom();

    public void setData(ModelConnom data){
        datas = data;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected ModelConnom doInBackground(String... strings) {
        ModelConnom result=new ModelConnom();
        try {
            URL url = new URL(ServiceInfo.Base_URL+"data.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader inputStreamReader = new InputStreamReader(conn.getInputStream());
                BufferedReader reader = new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder = new StringBuilder();
                String temp;

                while ((temp = reader.readLine()) != null) {
                    stringBuilder.append(temp);
                }
                JSONObject resultObject= null;
                resultObject= new JSONObject(stringBuilder.toString());

                JSONObject total = resultObject.optJSONObject("total");
                JSONObject today = resultObject.optJSONObject("today");
                JSONArray overview = resultObject.optJSONArray("overview");
                JSONArray locations = resultObject.optJSONArray("locations");

                Gson gson = new Gson();
                JsonParser parser = new JsonParser();

                JsonElement mJson =  parser.parse(String.valueOf(total));
                Total objectTotal = gson.fromJson(mJson, Total.class);

                mJson =  parser.parse(String.valueOf(today));
                Today objectToday = gson.fromJson(mJson, Today.class);

                mJson =  parser.parse(String.valueOf(overview));
                OverView[] objectOverviewInfo = gson.fromJson(mJson, OverView[].class);
                ArrayList<OverView> overviewInfos= new ArrayList<>();
                Arrays.stream(objectOverviewInfo).forEach(overviewInfos::add);

                mJson =  parser.parse(String.valueOf(locations));
                Location[] objectLocation = gson.fromJson(mJson, Location[].class);

                ArrayList<Location> locationList= new ArrayList<>();
                Arrays.stream(objectLocation).forEach(locationList::add);

                result.setToday(objectToday);
                result.setTotal(objectTotal);
                result.setLocations(locationList);
                result.setOverViews(overviewInfos);
                return result;
            }else  {
                return null;
            }

        } catch (Exception  e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(ModelConnom modelCommom) {
        super.onPostExecute(modelCommom);
    }
}
