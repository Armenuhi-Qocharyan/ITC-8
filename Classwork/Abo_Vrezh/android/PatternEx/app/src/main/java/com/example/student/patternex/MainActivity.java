package com.example.student.patternex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText text;
    private Button createButton;
    private Button createWindows;
    private TextView result;
    private Factory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        createButton.setOnClickListener(this);
        createWindows.setOnClickListener(this);
    }

    private void initView() {
        text = (EditText) findViewById(R.id.input_os);
        createButton = (Button) findViewById(R.id.create_button);
        createWindows = (Button) findViewById(R.id.create_window);
        result = (TextView) findViewById(R.id.result);
    }


    @Override
    public void onClick(View view) {
        factory = FactoryOS.getFactory(text.getText().toString());
        if (view == createButton) {
            result.setText(factory.getButton().getButtonType());
        } else {
            result.setText(factory.getWindow().getWindowType());
        }
    }
}
