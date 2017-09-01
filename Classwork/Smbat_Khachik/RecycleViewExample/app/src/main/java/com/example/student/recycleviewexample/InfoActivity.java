package com.example.student.recycleviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        if(savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            Toast.makeText(this,extras.get("title").toString(), Toast.LENGTH_SHORT).show();
            TextView title = (TextView)findViewById(R.id.name);
            TextView genre = (TextView)findViewById(R.id.zanr);
            TextView year = (TextView)findViewById(R.id.year);
            title.setText(extras.get("title").toString());
            genre.setText(extras.get("genre").toString());
            year.setText(extras.get("year").toString());
            //((TextView)findViewById(R.id.name)).setText(extras.get("title").toString());
            //((TextView)findViewById(R.id.zanr)).setText(extras.get("genre").toString());
            //((TextView)findViewById(R.id.year)).setText(extras.get("year").toString());
        } else {
            Toast.makeText(this,"AAA", Toast.LENGTH_SHORT).show();
        }

    }
}
