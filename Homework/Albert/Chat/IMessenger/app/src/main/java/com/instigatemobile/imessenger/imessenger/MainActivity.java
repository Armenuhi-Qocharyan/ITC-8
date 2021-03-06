package com.instigatemobile.imessenger.imessenger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //The view objects
    private EditText editTextName, editTextEmail, editTextPassword;
    private Button buttonSubmit;
    //defining AwesomeValidation object
    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing awesomevalidation object
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //initializing view objects
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonSubmit = (Button) findViewById(R.id.btnRegister);

        //adding validation to edittexts
        awesomeValidation.addValidation(this, R.id.editTextName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.editTextEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.editTextPassword, "^(?=.*[0-9])(?=.*[a-z])[a-zA-Z0-9!@#$%^&*]{6,20}$", R.string.passworderror);

        buttonSubmit.setOnClickListener(this);
    }
    private void submitForm() {
        //first validate the form then move ahead
        //if this becomes true that means validation is successfull
        if (awesomeValidation.validate()) {
            Toast.makeText(this, "Registration Successfull", Toast.LENGTH_LONG).show();

            //process the data further
        }
    }
    @Override
    public void onClick(View view) {
        if (view == buttonSubmit) {
            submitForm();
        }
    }
}
