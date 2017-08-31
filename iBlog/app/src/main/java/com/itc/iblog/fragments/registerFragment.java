package com.itc.iblog.fragments;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.itc.iblog.MainActivity;
import com.itc.iblog.R;

public class registerFragment extends Fragment{

    private Button buttonRegister;
    private EditText editTextEmailReg;
    private EditText editTextPassReg;
    private EditText editTextConfPassReg;
    private Activity main;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private Activity login;

    public registerFragment(Activity login) {
        super();
        this.login = login;

    }
    public registerFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(getActivity());
        main = new MainActivity();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        Animation scale = AnimationUtils.loadAnimation(super.getContext(), R.anim.scale);
        view.setAnimation(scale);

        editTextEmailReg = (EditText) view.findViewById(R.id.emailReg);
        editTextPassReg = (EditText) view.findViewById(R.id.passwordReg);
        editTextConfPassReg = (EditText) view.findViewById(R.id.confirm);
        buttonRegister = (Button) view.findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("register");
                if(v == buttonRegister) {
                    registerUser();
                }
            }
        });
        return view;
    }

    private void registerUser() {
        String email = editTextEmailReg.getText().toString().trim();
        String pass = editTextPassReg.getText().toString().trim();
        String passConf = editTextConfPassReg.getText().toString().trim();
        if(TextUtils.isEmpty(email)) {
            Toast.makeText(getActivity(), "Please enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)) {
            Toast.makeText(getActivity(),"Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(passConf)) {
            Toast.makeText(getActivity(),"Please confirm the password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!pass.equals(passConf)) {
            Toast.makeText(getActivity(),"Passwords are not match", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(getActivity(),"Registered successfully", Toast.LENGTH_SHORT).show();
                            progressDialog.cancel();

                            Intent intent = new Intent(login,
                                    MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(intent);
                            login.finish();
                        } else {
                            Toast.makeText(getActivity(),"Could not register. Please try again.", Toast.LENGTH_SHORT).show();
                            progressDialog.cancel();
                        }
                    }
                });
    }

}
