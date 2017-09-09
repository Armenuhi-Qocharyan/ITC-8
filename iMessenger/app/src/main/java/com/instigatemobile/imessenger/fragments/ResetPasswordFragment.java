package com.instigatemobile.imessenger.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.instigatemobile.imessenger.R;

public class ResetPasswordFragment extends Fragment implements View.OnClickListener {
    private View view;
    private FragmentManager fragmentManager;
    private ProgressBar bar;
    private EditText editTextPassword;
    private EditText editTextComfirmPassword;
    private Button submit;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reset, container, false);
        initViews();
        setListeners();
        return view;
    }

    private void setListeners() {
        submit.setOnClickListener(this);
    }

    private void initViews() {
        fragmentManager = getActivity().getSupportFragmentManager();
        editTextPassword = (EditText) view.findViewById(R.id.editTextPassword);
        editTextComfirmPassword = (EditText) view.findViewById(R.id.editTextComfirmPassword);
        bar = (ProgressBar) view.findViewById(R.id.progressBar);
        submit = view.findViewById(R.id.btn_submit);
    }

    private void goLoginPage() {
        LoginFragment loginFragment = new LoginFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, loginFragment);
        fragmentTransaction.addToBackStack("Reset");
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(final View view) {
        if (view == view.findViewById(R.id.btn_submit)) {
            if (editTextPassword.getText().toString().trim().equals(editTextComfirmPassword.getText().toString().trim())) {
                FirebaseAuth.getInstance().confirmPasswordReset(editTextPassword.getText().toString(), editTextComfirmPassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Snackbar snackbar = Snackbar
                                            .make(view, "Password changed", Snackbar.LENGTH_LONG);
                                    snackbar.show();
                                    goLoginPage();
                                } else {
                                    Snackbar snackbar = Snackbar
                                            .make(view, "Failed to change password", Snackbar.LENGTH_LONG);
                                    snackbar.show();
                                }
                            }
                        });
            } else {

            }
        }
    }

    public void progressBarVisibility() {
        bar.setVisibility(ProgressBar.VISIBLE);
    }

    public void progressBarInvisibility() {
        bar.setVisibility(ProgressBar.INVISIBLE);
    }

    private class ProgressTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            bar.setVisibility(View.VISIBLE);
        }

        protected void onPostExecute(Void result) {
            bar.setVisibility(View.GONE);
        }
    }
}
