package com.tet.luxuryautostore;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class RegisterActivity extends AppCompatActivity {


    private EditText usernameView;
    private EditText firstnameView;
    private EditText lastnameView;
    private EditText cityView;
    private EditText streetView;
    private EditText passwordView;
    private EditText confirmPasswordView;


    private Button signupButton;

    private FirebaseAuth mAuth;


    public void signUpButtonClicked()
    {
        signupButton = (Button)findViewById(R.id.register_sign_up_btn);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, ActivityLogin.class);
                //finish();
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        usernameView = (EditText)findViewById(R.id.register_username);
        firstnameView = (EditText) findViewById(R.id.register_firstname);
        lastnameView = (EditText)findViewById(R.id.register_last_name);
        streetView =  (EditText)findViewById(R.id.register_street);
        cityView =  (EditText)findViewById(R.id.register_city);
        passwordView =  (EditText)findViewById(R.id.register_password);

        confirmPasswordView =  (EditText)findViewById(R.id.register_confirm_password);
        signUpButtonClicked();

        // Keyboard sign in action
        confirmPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.register_sign_up_btn || id == EditorInfo.IME_NULL) {
                    attemptRegistration();
                    return true;
                }
                return false;
            }
        });





        mAuth = FirebaseAuth.getInstance();
    }





    private void createFireBaseUser()
    {
        String username = usernameView.getText().toString();
        String firstname = firstnameView.getText().toString();
        String lastname =  lastnameView.getText().toString();
        String street =  streetView.getText().toString();
        String password =  passwordView.getText().toString();


        mAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("LuxuryCarsApp", "createUser onComplete: " + task.isSuccessful());

                        if(!task.isSuccessful()){
                            Log.d("LuxuryCarsApp", "user creation failed");
                            //showErrorDialog("Registration attempt failed");
                        } else {
                            //saveDisplayName();
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            finish();
                            startActivity(intent);
                        }
                    }
                });

    }
    private void attemptRegistration() {

        // Reset errors displayed in the form.
        usernameView.setError(null);
        passwordView.setError(null);

        // Store values at the time of the login attempt.
        String email = usernameView.getText().toString();
        String password = passwordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            // passwordView.setError(getString(R.string.error_invalid_password));
            focusView = passwordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            //usernameView.setError(getString(R.string.error_field_required));
            focusView = usernameView;
            cancel = true;
        }
        //else if (!usernameView(email)) {
        //usernameView.setError(getString(R.string.error_invalid_email));
        //focusView = usernameView;
        //cancel = true;

        //else if (cancel) {
        // There was an error; don't attempt login and focus the first
        // form field with an error.
        //    focusView.requestFocus();
   // }
        else {
            // TODO: Call create FirebaseUser() here
            createFireBaseUser();

        }
    }

    public void signUp(View v) {
        attemptRegistration();
    }

    private boolean isPasswordValid(String password) {
        //TODO: Add own logic to check for a valid password
        String confirmPassword = confirmPasswordView.getText().toString();
        return confirmPassword.equals(password) && password.length() > 4;
    }


    }



