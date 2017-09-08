package com.instigatemobile.imessenger.activities;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.instigatemobile.imessenger.R;
import com.instigatemobile.imessenger.fragments.RegisterFragment;

import org.w3c.dom.Text;

public class MessangerActivity extends AppCompatActivity  implements View.OnClickListener {

    private ImageView back_btn;
    private TextView contact_data;
    private EditText write_msg;
    private ImageView send_smile;
    private ImageView send_img;
    private ImageView send_msg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messanger);
        init();
        setListeners();
    }

    private void init() {
        back_btn = (ImageView) findViewById(R.id.back_btn);
        contact_data = (TextView) findViewById(R.id.contact_data);
        write_msg = (EditText) findViewById(R.id.write_msg);
        send_smile = (ImageView) findViewById(R.id.send_smile);
        send_img = (ImageView) findViewById(R.id.send_img);
        send_msg = (ImageView) findViewById(R.id.send_msg);

    }

    private void setListeners() {
        back_btn.setOnClickListener(this);
        send_smile.setOnClickListener(this);
        send_img.setOnClickListener(this);
        send_msg.setOnClickListener(this);
    }
    @Override
    public void onClick(final View view) {
        int id = view.getId();
        switch(id) {
            case R.id.back_btn:
                sayText("back");
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return;
            case R.id.send_smile:
                sayText("smile");
                return;
            case R.id.send_img:
                sayText("img");
                return;
            case R.id.send_msg:
                sayText("msg");
                return;
            default:
                sayText("other");
        }
    }

    private void sayText(String str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }
}
