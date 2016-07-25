package com.example.gift.Model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.webkit.URLUtil;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by fenghui on 7/8/16.
 */
public class ImageDownloaderTask extends AsyncTask<String,Void,Bitmap> {
    private final WeakReference<ImageView> imageViewWeakReference;
    public ImageDownloaderTask(ImageView imageView){
        imageViewWeakReference=new WeakReference<ImageView>(imageView);
    }
    @Override
    protected Bitmap doInBackground(String...params){
        return downLoadBitmap(params[0]);
    }
    @Override
    protected void onPostExecute(Bitmap bitmap){
        if(isCancelled()){
            bitmap=null;
        }
        if(imageViewWeakReference!=null){
            ImageView imageView = imageViewWeakReference.get();
            if(imageView!=null&&bitmap!=null){
                imageView.setImageBitmap(bitmap);
            }
//            else{
//                imageView.setImageDrawable(imageView.getContext().getResources().getDrawable(R.drawable.list_placeholder));
//            }
        }
    }
    static Bitmap downLoadBitmap(String url){
        InputStream is=null;
        if(URLUtil.isValidUrl(url)){
            try{
                URL Url = new URL(url);
                HttpURLConnection urlConnection =(HttpURLConnection)Url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setDoInput(true);
                urlConnection.connect();
                is=urlConnection.getInputStream();
//                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
//                StringBuilder sb = new StringBuilder();
//                String line="";
//                while((line=reader.readLine())!=null){
//                    sb.append(line+"\n");
//                }
                final Bitmap bitmap= BitmapFactory.decodeStream(is);

                is.close();
                return bitmap;
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
