package com.tet.luxuryautostore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Member;

public class ActivityLogin extends AppCompatActivity {


    private Button signInButton;
    private Button signUpButton;






    public void signInButtonClicked()
    {
        signInButton = (Button)findViewById(R.id.login_sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityLogin.this, MemberInfoActivity.class);
                //finish();
                startActivity(intent);
            }
        });
    }

    public void signUpButtonClicked()
    {
        signUpButton = (Button)findViewById(R.id.login_sign_up_button);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityLogin.this, RegisterActivity.class);
                //finish();
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signInButtonClicked();
        signUpButtonClicked();
    }
}
