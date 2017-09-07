package com.itc.iblog.fragments;


import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.itc.iblog.activities.MainActivity;
import com.itc.iblog.R;

public class LoginFragment extends Fragment {
    private Activity login;
    private FirebaseAuth firebaseAuth;
    private EditText editTextEmail;
    private EditText editTextPass;
    private static final String Tag = "EmailPassword";
    private ProgressBar progressBar;

    public LoginFragment() {
    }

    public LoginFragment(Activity login) {
        this.login = login;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Animation scale = AnimationUtils.loadAnimation(super.getContext(), R.anim.scale);
        view.setAnimation(scale);
        firebaseAuth = FirebaseAuth.getInstance();
        Button register = (Button) view.findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new RegisterFragment(login);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.contentFragment, fragment);
                transaction.addToBackStack(null).commit();
            }
        });
        editTextEmail = (EditText) view.findViewById(R.id.editText);
        editTextPass =  (EditText) view.findViewById(R.id.editText2);
        Button login = (Button) view.findViewById(R.id.buttonLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password =  editTextPass.getText().toString().trim();
                signIn(email, password);
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        progressBar =  getActivity().findViewById(R.id.progressBar_cyclic_login);
        progressBar.setVisibility(View.INVISIBLE);
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            Intent intent = new Intent(login,
                    MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            login.finish();
        }
    }

    private void signIn(String email, String password) {
        if (TextUtils.isEmpty(password)) {
            editTextPass.setError("Password is required");
            return;
        }

        if (TextUtils.isEmpty(email)) {
            editTextEmail.setError("Email is required");
            return;
        }
        Log.d(Tag, "signIn:" + email);
        progressBar.setVisibility(View.VISIBLE);
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(Tag, "SignInWithEmail:success");
                            Toast.makeText(getActivity(),"Login successfully", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            Log.w(Tag, "SignInWithEmail:failure", task.getException());
                            Toast.makeText(getActivity(), "Authentication failed", Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
    }

}