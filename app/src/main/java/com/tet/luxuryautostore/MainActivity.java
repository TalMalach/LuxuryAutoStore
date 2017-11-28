package com.tet.luxuryautostore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button AboutButton;
    private Button loginButton;
    private Button signInButton;


    public void aboutButtonClicked()
    {
    AboutButton = (Button)findViewById(R.id.main_button_about);
        AboutButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            //finish();
            startActivity(intent);
        }
    });
    }

    public void registerButtonClicked()
    {
        loginButton = (Button)findViewById(R.id.login_register_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                //finish();
                startActivity(intent);
            }
        });
    }


    public void signInButtonClicked()
    {
        signInButton = (Button)findViewById(R.id.login_sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityLogin.class);
                //finish();
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aboutButtonClicked();
        registerButtonClicked();
        signInButtonClicked();
    {



    }
    }
}
