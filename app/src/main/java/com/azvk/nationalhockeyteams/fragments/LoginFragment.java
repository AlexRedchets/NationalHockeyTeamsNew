package com.azvk.nationalhockeyteams.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.azvk.nationalhockeyteams.Navigator;
import com.azvk.nationalhockeyteams.activities.TeamInfoActivity;
import com.azvk.nationalhockeyteams.interfaces.UserInterface;
import com.azvk.nationalhockeyteams.presenters.LoginPresenter;
import com.azvk.nationalhockeyteams.R;
import com.azvk.nationalhockeyteams.activities.RegistrationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment implements UserInterface.LoginPresenterView {

    private  static final String TAG = LoginFragment.class.getSimpleName();
    @BindView(R.id.input_name_login)
    EditText inputName;
    @BindView(R.id.input_password_login)
    EditText inputPassword;

    public LoginFragment() {}

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

        if (isValid(inputName, inputPassword)){
            Log.i(TAG, "login and password are valid");
            Navigator navigator = new Navigator(getContext());
            if(navigator.isNetworkAvailable()){
                //if there is internet connection
                UserInterface.LoginViewPresenter viewPresenter = new LoginPresenter(this);
                viewPresenter.loginUser(inputName.getText().toString(), inputPassword.getText().toString());}
            else{
                //if there is not internet connection
                Log.i(TAG, "No internet connection");
                Snackbar.make(view, R.string.network_error,
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        }
        else{
            Log.i(TAG, "login and password are NOT valid");
            Snackbar.make(view, R.string.empty_error,
                    Snackbar.LENGTH_SHORT)
                    .show();
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
            Log.i(TAG, "Authorization: Success");
            Toast.makeText(getContext(), "User found", Toast.LENGTH_SHORT).show();

            //save username and password into shared preferences
            SharedPreferences sharedPref = getContext().getSharedPreferences(
                    "userInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("username", inputName.getText().toString());
            editor.putString("password", inputPassword.getText().toString());
            editor.apply();

            Intent intent = new Intent(getContext(), TeamInfoActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
        else {
            Log.i(TAG, "Authorization: User not found");
            Toast.makeText(getContext(), "User NOT found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void errorServer(String error) {
        Log.i(TAG, "Authorization: Server error");
        Toast.makeText(getContext(), "Enable to connect server. Try later", Toast.LENGTH_LONG).show();
    }
}
