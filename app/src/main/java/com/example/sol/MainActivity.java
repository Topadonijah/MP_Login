package com.example.sol;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Activity");

        SharedPreferences pref = getSharedPreferences("Clients", MODE_PRIVATE);

        //로그인 --------------------------------------//
        Button login = (Button) findViewById(R.id.login);
        EditText inputid = (EditText) findViewById(R.id.idinput);
        EditText inputpw = (EditText) findViewById(R.id.pwinput);

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String id = inputid.getText().toString();
                String pw = inputpw.getText().toString();
                String array = pref.getString(id,null);

                TextView idlay = (TextView) findViewById(R.id.idv);
                if(array == null){
                    idlay.setVisibility(View.VISIBLE);
                } else {
                    JSONObject info = null;
                    try {
                        info = new JSONObject(array);
                        String copw = (String) info.get("pw"); //아이디에 유효한 비밀번호
                        if(pw.equals(copw)){
                             //pass to third
                             Toast.makeText(getApplicationContext(),"correct account!", Toast.LENGTH_SHORT).show();
                         }
                         else{
                             TextView pwlay = (TextView) findViewById(R.id.pwv);
                             pwlay.setVisibility(View.VISIBLE);
                         }
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        //로그인 끝 --------------------------------------//


        //회원가입 ----------------------------------------//
        Button signup =(Button) findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);
                startActivity(intent);
            }
        });
        //회원가입 끝 ----------------------------------//



    }

}
