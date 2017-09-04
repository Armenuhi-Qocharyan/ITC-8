package com.instigatemobile.imessenger.profile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.instigatemobile.imessenger.R;
import com.instigatemobile.imessenger.data.Profile;
import com.instigatemobile.imessenger.models.DataBase;
import com.instigatemobile.imessenger.models.LoginRegister;

public class RegisterFragment extends Fragment implements View.OnClickListener {
    private View view;
    private Button register;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private ImageView chat_icon;
    private LinearLayout registerLayout;
    private FragmentManager fragmentManager;

    private LoginFragment loginFragment;
    private ProgressBar bar;
    private Profile profile;
    //private RegisterFragment registerFragment;

    //private AwesomeValidation awesomeValidation;
    //private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])[a-zA-Z0-9!@#$%^&*]{6,20}$";
    //private static final String NAME_PATTERN = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";

    public RegisterFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        bar = view.findViewById(R.id.progressBar);
        register = (Button) view.findViewById(R.id.btnRegister);
        initViews();

        //awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //awesomeValidation.addValidation(getActivity(), R.id.editTextName, NAME_PATTERN, R.string.nameerror);
        //awesomeValidation.addValidation(getActivity(), R.id.editTextEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        //awesomeValidation.addValidation(getActivity(), R.id.editTextPassword, PASSWORD_PATTERN, R.string.passworderror);
        setListeners();
        return view;
    }

    private void initViews() {
        loginFragment = new LoginFragment();
        //registerFragment = new RegisterFragment();
        fragmentManager = getActivity().getSupportFragmentManager();
        editTextEmail = (EditText) view.findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) view.findViewById(R.id.editTextPassword);
        editTextName = (EditText) view.findViewById(R.id.editTextName);
        register = (Button) view.findViewById(R.id.btnRegister);
        registerLayout = (LinearLayout) view.findViewById(R.id.register_layout);
    }

    private void setListeners() {
        register.setOnClickListener(this);
    }

    public void registerForm() {
        //if (this.awesomeValidation.validate()) {
        initProfile();
        DataBase dataBase = DataBase.initDataBase();
        dataBase.insertProfile(profile);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, loginFragment);
        fragmentTransaction.addToBackStack("Login");
        fragmentTransaction.commit();
        //}
    }

    @Override
    public void onClick(View view) {
        new ProgressTask().execute();
        if (view == register) {
            LoginRegister loginRegister =  LoginRegister.initLoginRegister();
            loginRegister.createAccount(editTextEmail.getText().toString(), editTextPassword.getText().toString(), this);
        }
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

    private void  initProfile() {
        profile = new Profile(editTextName.getText().toString(), editTextEmail.getText().toString(), " ", " ", 0, 0);
    }

    private void showMessage(String message) {
        Toast.makeText(this.getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    interface MyCallbackInterface {

        void onDownloadFinished(String result);
    }

}