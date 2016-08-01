package com.azvk.nationalhockeyteams.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.azvk.nationalhockeyteams.MyPresenter;
import com.azvk.nationalhockeyteams.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistrationFragment extends Fragment{

    @BindView(R.id.input_name_reg)
    EditText inputName;
    @BindView(R.id.input_password_reg)
    EditText inputPassword;
    @BindView(R.id.input_repassword_reg)
    EditText inputRePassword;

    MyPresenter presenter;

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
    public void signUp(View view){

    }
}
