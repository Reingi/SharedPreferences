package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private Button login;
    private CheckBox check;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        pass = findViewById(R.id.password);
        check = findViewById(R.id.check);

        login = findViewById(R.id.login);
        SharedPreferences saveddata = getSharedPreferences("User", Context.MODE_PRIVATE);
        System.out.println("--------Shared Preferences-------"+saveddata.getString("usernme",""));
        if(saveddata.getString("usernme","").isEmpty()){
            check.setChecked(false);
        }else{
            user.setText(saveddata.getString("usernme",""));
            pass.setText(saveddata.getString("password",""));
            check.setChecked(true);
        }
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(check.isChecked()){ String use = user.getText().toString();
                        String pss = pass.getText().toString();

                        sharedPreferences = getSharedPreferences("User",MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putString("usernme",use);
                        editor.putString("password",pss);
                        editor.commit();
                        Toast.makeText(MainActivity.this,"Check box checked",Toast.LENGTH_LONG).show();
                    }else{
                        sharedPreferences = getSharedPreferences("User",0);
                        sharedPreferences.edit().clear().commit();

                        Toast.makeText(MainActivity.this,"Check box not checked",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }


