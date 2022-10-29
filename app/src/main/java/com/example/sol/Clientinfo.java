package com.example.sol;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

public class Clientinfo extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.clientinfo);


            SharedPreferences infos = getSharedPreferences("Clients", MODE_PRIVATE);
            Intent intent = getIntent();
            String id = intent.getStringExtra("id");
            String array = infos.getString(id,null);


            try {
                JSONObject values = new JSONObject(array);
                TextView ids = (TextView) findViewById(R.id.id);
                TextView name = (TextView) findViewById(R.id.name);
                TextView number = (TextView) findViewById(R.id.number);
                TextView addr = (TextView) findViewById(R.id.addr);

                ids.setText("아이디: "+ id);
                name.setText("이름: "+values.getString("name").toString());
                number.setText("전화번호: "+values.getString("number").toString());
                addr.setText("주소:  "+values.getString("adddr").toString());

            } catch (JSONException e) {
                e.printStackTrace();
            }

            Button close = (Button) findViewById(R.id.close);

            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });



        }
    }
