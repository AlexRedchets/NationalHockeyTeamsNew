package com.azvk.nationalhockeyteams.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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

import com.azvk.nationalhockeyteams.activities.TeamInfoActivity;
import com.azvk.nationalhockeyteams.interfaces.UserInterface;
import com.azvk.nationalhockeyteams.R;
import com.azvk.nationalhockeyteams.presenters.RegistrationPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistrationFragment extends Fragment implements UserInterface.RegistrationPresenterView{

    private static final String TAG = RegistrationFragment.class.getSimpleName();

    @BindView(R.id.input_name_reg)
    EditText inputName;
    @BindView(R.id.input_password_reg)
    EditText inputPassword;
    @BindView(R.id.input_repassword_reg)
    EditText inputRePassword;

    UserInterface.RegistrationViewPresenter viewPresenter;

    public RegistrationFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.signup_button_reg)
    void signUp(View view){
        if (isNetworkAvailable()){
            //if there is internet connection
            switch (isValid(inputName, inputPassword, inputRePassword)){
                case 0:
                    Log.i(TAG, "login and password are NOT valid");
                    Snackbar.make(view, R.string.empty_error,
                            Snackbar.LENGTH_SHORT)
                            .show();
                    break;
                case 1:
                    Log.i(TAG, "passwords do not match");
                    Snackbar.make(view, R.string.passwords_error,
                            Snackbar.LENGTH_SHORT)
                            .show();
                    break;
                case 2:
                    Log.i(TAG, "Input info is valid");
                    viewPresenter = new RegistrationPresenter(this);
                    viewPresenter.registerUser(inputName.getText().toString(), inputPassword.getText().toString());
                    break;
            }
        }
        else{
            //if there is not internet connection
            Snackbar.make(view, R.string.network_error,
                    Snackbar.LENGTH_SHORT)
                    .show();
        }
    }

    private int isValid(EditText inputName, EditText inputPassword, EditText inputRePassword) {
        if (inputName.getText().toString().isEmpty()
                || inputPassword.getText().toString().isEmpty()
                || inputRePassword.getText().toString().isEmpty()){
            return 0;
        }
        else if (!inputPassword.getText().toString()
                .equals(inputRePassword.getText().toString())){
            return 1;
        }
        else
            return 2;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void registerAuthComplete(int result) {
        switch (result) {
            case 0:
                Log.i(TAG, "User exists");
                Toast.makeText(getContext(), "userExists", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Log.i(TAG, "Error on save");
                Toast.makeText(getContext(), "errorOnSave()", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Log.i(TAG, "User added");
                Toast.makeText(getContext(), "userAdded", Toast.LENGTH_SHORT).show();

                //save username and password into shared preferences
                SharedPreferences sharedPref = getContext().getSharedPreferences(
                        "userInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("username", inputName.getText().toString());
                editor.putString("password", inputPassword.getText().toString());
                editor.apply();

                Intent intent = new Intent(getContext(), TeamInfoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
