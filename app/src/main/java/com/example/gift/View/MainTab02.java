package com.example.gift.View;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.gift.Model.ImageDownloaderTask;
import com.example.gift.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by fenghui on 6/11/16.
 */
public class MainTab02 extends Fragment {
    private ArrayList<String> str = null;
    private ImageView icon;
    private HttpURLConnection urlConnection;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View newsLayout = inflater.inflate(R.layout.main_tab_02,viewGroup,false);
        icon = (ImageView) newsLayout.findViewById(R.id.AmazonPic);
        String url = "http://ec2-54-173-25-145.compute-1.amazonaws.com:8080/users";
        new DownloadFilesTask().execute(url);
        return newsLayout;
    }
    private class DownloadFilesTask extends AsyncTask<String,Void,Void> {

        @Override
        protected Void doInBackground(String...params){
            String url = params[0];
            JSONObject json = getJsonFromUrl(url);
            parseJson(json);
            return null;
        }
//        @Override
//        protected void doProgressUpdate(Void values){
//
//        }
        @Override
        protected void onPostExecute(Void result){
            update();
        }
        public JSONObject getJsonFromUrl(String Url){
            InputStream is;
            String json = null;
            JSONObject jObj=null;


            try{
                URL url = new URL(Url);
                urlConnection = (HttpURLConnection)url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setDoInput(true);
                urlConnection.connect();
                is = urlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line="";
                while((line=reader.readLine())!=null){
                    sb.append(line+"\n");
                }
//                Log.e("sb's length",sb.length()+"");
                is.close();
//                Log.e("Get sb","sb get!!");
                json=sb.toString();
//                Log.e("Get Json","Json get!!");
            }catch (IOException e){
                e.printStackTrace();
            }
            try{

                jObj = new JSONObject(json);

            }catch (JSONException e){
                Log.e("JSON PARSER","Error parsing data"+e.toString());
            }
            return jObj;
        }
        public void parseJson(JSONObject json){
            try{
                StringBuilder test = new StringBuilder();
                test.append(urlConnection.getResponseCode())
                        .append(" ")
                        .append(urlConnection.getResponseMessage())
                        .append("\n");
                Log.e("Connection condition",""+test.toString());
                JSONArray gets = json.getJSONArray("message");
                str=new ArrayList<String>();
                for(int i=0;i<gets.length();i++){
//                    String s =null;
                    JSONObject get = (JSONObject)gets.getJSONObject(i);
                    String s=get.getString("name");
                    str.add(s);
                }
                Log.e("Image URL","All have been added"+" "+str.get(2));


            }catch (JSONException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public void update(){
//            ImageView icon = (ImageView) findViewById(R.id.AmazonPic);
//        Log.e("Catch update","update get!");
        new ImageDownloaderTask(icon).execute(str.get(2));
//        Log.e("Catch image","image get!");
    }

}
