package com.instigatemobile.asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity extends Activity {

    // Set your Image URL into a string
    String URL = "http://www.intrawallpaper.com/static/images/HD-Wallpapers-646.jpg";
    ImageView image;
    Button button;
    ProgressDialog mProgressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the layout from image.xml
        setContentView(R.layout.activity_main);

        // Locate the ImageView in activity_main.xml
        image = (ImageView) findViewById(R.id.image);

        // Locate the Button in activity_main.xml
        button = (Button) findViewById(R.id.button);

        // Capture button click
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Execute DownloadImage AsyncTask
                new DownloadImage().execute(URL);
            }
        });
    }

    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(MainActivity.this);

            // Set progressdialog title
            mProgressDialog.setTitle("Download Image Tutorial");

            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);

            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... URL) {
            String imageURL = URL[0];
            Bitmap bitmap = null;
            try {
                // Download Image from URL
                InputStream input = new java.net.URL(imageURL).openStream();

                System.out.println("fffffffffffffffffffffffffffffff");
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // Set the bitmap into ImageView
            image.setImageBitmap(result);

            // Close progressdialog
            mProgressDialog.dismiss();
        }
    }
}
