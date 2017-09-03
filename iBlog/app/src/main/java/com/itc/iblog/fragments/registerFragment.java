package com.itc.iblog.fragments;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.itc.iblog.MainActivity;
import com.itc.iblog.R;
import com.itc.iblog.models.UserModel;

public class registerFragment extends Fragment{

    private Button buttonRegister;
    private EditText editTextEmailReg;
    private EditText editTextPassReg;
    private EditText editTextConfPassReg;
    private Activity main;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private Activity login;
    private EditText editTextSelectedAge;
    private EditText editTextUsername;
    private FirebaseDatabase database;
    private FirebaseUser user;
    private ProgressBar progressBar;
    //private DatabaseReference mDatabase;


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
        database =  FirebaseDatabase.getInstance();
        user =  firebaseAuth.getCurrentUser();
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_register, container, false);
        Animation scale = AnimationUtils.loadAnimation(super.getContext(), R.anim.scale);
        view.setAnimation(scale);
        editTextEmailReg = (EditText) view.findViewById(R.id.emailReg);
        editTextEmailReg.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String email = editTextEmailReg.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(TextUtils.isEmpty(email)) {
                    editTextEmailReg.setError("Email is required");
                }
                if (!email.matches(emailPattern)) {
                    editTextEmailReg.setError("Invalid Email address");
                }
            }
        });
        editTextPassReg = (EditText) view.findViewById(R.id.passwordReg);
        editTextPassReg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String pass = editTextPassReg.getText().toString().trim();
                String passPattern = "^(?=.*[0-9])(?=.*[a-z]).{6,}";
                if (TextUtils.isEmpty(pass)) {
                    editTextPassReg.setError("Password is required");
                }
                if (!pass.matches(passPattern)) {
                    editTextPassReg.setError("Password should contain minimum 6 symbols at last one letter and one number");
                }
            }
        });
        editTextConfPassReg = (EditText) view.findViewById(R.id.confirm);
        editTextConfPassReg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String pass = editTextPassReg.getText().toString().trim();
                String passConf = editTextConfPassReg.getText().toString().trim();
                if(TextUtils.isEmpty(passConf)) {
                    editTextConfPassReg.setError("Confirm password is required");
                }
                if(!pass.equals(passConf)) {
                    editTextConfPassReg.setError("Passwords doesn't match");
                }
            }
        });
        editTextSelectedAge = (EditText) view.findViewById(R.id.age);
        editTextSelectedAge.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                String age = editTextSelectedAge.getText().toString().trim();
                if(TextUtils.isEmpty(age)) {
                    editTextSelectedAge.setError("Age is required");
                }

            }
        });
        editTextUsername = (EditText) view.findViewById(R.id.name);
        editTextUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String name = editTextUsername.getText().toString().trim();
                if(TextUtils.isEmpty(name)) {
                    editTextUsername.setError("Name is required");
                }
            }
        });

        buttonRegister = (Button) view.findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("register");
                if(v == buttonRegister) {
                    registerUser(view);
                }
            }
        });
        return view;
    }

    public void onStart () {
        super.onStart();
        progressBar = getActivity().findViewById(R.id.progressBar_cyclic);
        progressBar.setVisibility(View.INVISIBLE);
    }

    private void registerUser(View view) {
        String email = editTextEmailReg.getText().toString().trim();
        String pass = editTextPassReg.getText().toString().trim();
        String passConf = editTextConfPassReg.getText().toString().trim();
        String age = editTextSelectedAge.getText().toString().trim();
        String name = editTextUsername.getText().toString().trim();
        String passPattern = "^(?=.*[0-9])(?=.*[a-z]).{6,}";
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(TextUtils.isEmpty(email)) {
            editTextEmailReg.setError("Email is required");
            return;
        }


        if(!email.matches(emailPattern)) {
            editTextEmailReg.setError("Incorrect Email");
            return;
        }

        if(TextUtils.isEmpty(pass)) {
            editTextPassReg.setError("Password is required");
            return;
        }
        if(TextUtils.isEmpty(passConf)) {
            editTextConfPassReg.setError("Confirm password is required");
            return;
        }

        if(TextUtils.isEmpty(age)) {
            editTextSelectedAge.setError("Age is required");
            return;
        }

        if(TextUtils.isEmpty(name)) {
            editTextUsername.setError("Name is required");
            return;
        }

        if(!pass.equals(passConf)) {
            editTextConfPassReg.setError("Passwords doesn't match");
            return;
        }

        if (!pass.matches(passPattern)) {
            editTextConfPassReg.setError("Passwords doesn't match");
        }
        progressBar.setVisibility(View.VISIBLE);
        firebaseAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(getActivity(),"Registered successfully", Toast.LENGTH_SHORT).show();
                            user = firebaseAuth.getCurrentUser();
                            registerUserInfo();
                            Intent intent = new Intent(login,
                                    MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(intent);
                            login.finish();
                        } else {
                            Toast.makeText(getActivity(),"Could not register. Please try again.", Toast.LENGTH_SHORT).show();
                        }
                        progressBar.setVisibility(View.INVISIBLE);

                    }
                });
    }

    public void registerUserInfo() {
        String userId = user.getUid();
        UserModel userModel = new UserModel(this.editTextUsername.getText().toString().trim(), this.editTextEmailReg.getText().toString().trim(), Integer.parseInt(this.editTextSelectedAge.getText().toString()));
        DatabaseReference mRef =  database.getReference().child("Users").child(userId);
        mRef.setValue(userModel);
    }
}
