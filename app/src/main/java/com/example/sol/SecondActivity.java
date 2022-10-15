package com.example.sol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {

    @Override
    protected  void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Intent inIntent = getIntent();
        final String Namevalue = inIntent.getStringExtra("이름");

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(),
                        MainActivity.class);
                outIntent.putExtra("Name", Namevalue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });

    }


}
