package com.azvk.nationalhockeyteams.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.azvk.nationalhockeyteams.MyPresenter;
import com.azvk.nationalhockeyteams.R;
import com.azvk.nationalhockeyteams.activities.RegistrationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment {

    private  static final String TAG = LoginFragment.class.getSimpleName();

    MyPresenter presenter;
    @BindView(R.id.input_name_login)
    EditText inputName;
    @BindView(R.id.input_password_login)
    EditText inputPassword;

    public LoginFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView started");
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.login_button)
    void loginButtonClicked(View view){

        Log.i(TAG, "onLoginButtonClicked");
        presenter = new MyPresenter(this);

        if (isValid(inputName, inputPassword)){
            Log.i(TAG, "login and password are valid");
            presenter.loginUser(inputName.getText().toString(), inputPassword.getText().toString());
        }
        else{
            Log.i(TAG, "login and password are NOT valid");
        }
    }

    @OnClick(R.id.signup_button_login)
    void registration(View view){
        Log.i(TAG, "Running registration method");
        Intent intent = new Intent(getContext(), RegistrationActivity.class);
        startActivity(intent);
    }

    private boolean isValid(EditText inputName, EditText inputPassword) {
        return (!inputName.getText().toString().isEmpty() && !inputPassword.getText().toString().isEmpty());
    }

    public void userAuthSuccess(boolean user){
        if (user){
            Toast.makeText(getContext(), "User found", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getContext(), "User NOT found", Toast.LENGTH_SHORT).show();
        }
    }
}
