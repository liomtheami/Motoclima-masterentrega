package i005213com.motoclima;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;


import i005213com.motoclima.Helper.InputValidation;
import i005213com.motoclima.Views.ContainerActivity;
import i005213com.motoclima.Views.CreateAccountActivity;
import i005213com.motoclima.sql.DatabaseHelper;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private final AppCompatActivity activity = LoginActivity.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;

    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPasword;

    private AppCompatButton appCompatButtonLogin;

    private AppCompatTextView textViewLinkRegister;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        initViews();
        initListenners();
        initObjects();


    }

    private void  initViews(){


        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.id_tie_email);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.id_tier_password);

        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.id_tie_username);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.id_tie_password);

        appCompatButtonLogin = (AppCompatButton) findViewById(R.id.id_btn_login);

        textViewLinkRegister = (AppCompatTextView) findViewById(R.id.id_btn_joinUs);


    }

    private void initListenners(){
        appCompatButtonLogin.setOnClickListener(this);
        textViewLinkRegister.setOnClickListener(this);
    }

    private void initObjects(){
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.id_btn_login:
                verifyFromsSQLite();
                break;
            case R.id.id_btn_joinUs:
                Intent intentRegister = new Intent(getApplicationContext(), CreateAccountActivity.class);
                startActivity(intentRegister);
                break;

        }
    }


    private void  verifyFromsSQLite(){

        if(!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_password))){
            return;
        }

        if(!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_password))){
            return;
        }

        if(!inputValidation.isInputEditTextFilled(textInputEditTextPasword, textInputLayoutPassword, getString(R.string.error_password))){
            return;
        }

        if(databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim(). textInputEditTextPasword.getText().toString().trim())){
            Intent accountIntent = new Intent(activity, CreateAccountActivity.class)
        }

    }






    public void onShowAccount (View view) {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);

    }

    public void goCreateContainer(View view) {
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }

}
