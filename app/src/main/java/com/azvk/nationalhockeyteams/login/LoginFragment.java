package com.azvk.nationalhockeyteams.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.azvk.nationalhockeyteams.Navigator;
import com.azvk.nationalhockeyteams.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment implements LoginInterface.View {

    @Inject
    LoginPresenter presenter;
    @BindView(R.id.input_name_login)
    EditText inputName;
    @BindView(R.id.input_password_login)
    EditText inputPassword;
    @BindView(R.id.login_progress_bar)
    ProgressBar progressBar;

    private  static final String TAG = LoginFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView started");
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);
        progressBar.setVisibility(ProgressBar.INVISIBLE);

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
                progressBar.setVisibility(ProgressBar.VISIBLE);
                presenter.loginUser(inputName.getText().toString(), inputPassword.getText().toString());}
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
        //Intent intent = new Intent(getContext(), RegistrationActivity.class);
        //startActivity(intent);
    }

    private boolean isValid(EditText inputName, EditText inputPassword) {
        return (!inputName.getText().toString().isEmpty() && !inputPassword.getText().toString().isEmpty());
    }

    public void userAuthSuccess(boolean user){
        if (user){
            progressBar.setVisibility(ProgressBar.INVISIBLE);
            Log.i(TAG, "Authorization: Success");
            Toast.makeText(getContext(), "User found", Toast.LENGTH_SHORT).show();

            //Intent intent = new Intent(getContext(), TeamInfoActivity.class);
            //startActivity(intent);
            getActivity().finish();
        }
        else {
            progressBar.setVisibility(ProgressBar.INVISIBLE);
            Log.i(TAG, "Authorization: User not found");
            Toast.makeText(getContext(), "User NOT found", Toast.LENGTH_SHORT).show();
        }
    }

    /*@Override
    public void errorServer(String error) {
        progressBar.setVisibility(ProgressBar.INVISIBLE);
        Log.i(TAG, "Authorization: Server error");
        Toast.makeText(getContext(), "Enable to connect server. Try later", Toast.LENGTH_LONG).show();
    }*/
}
