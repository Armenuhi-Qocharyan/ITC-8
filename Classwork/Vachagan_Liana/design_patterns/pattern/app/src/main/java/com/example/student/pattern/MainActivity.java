package com.example.student.pattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Phone phone;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button samsung = (Button) findViewById(R.id.samsung);
        Button apple = (Button) findViewById(R.id.apple);
        imageView =(ImageView) findViewById(R.id.image);


        samsung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone = Factory.getFactory("Samsung").createPhone();
                imageView.setImageResource(phone.show());
            }
        });

        apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone = Factory.getFactory("Apple").createPhone();
                imageView.setImageResource(phone.show());
            }
        });
    }
}
