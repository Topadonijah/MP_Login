package com.example.sol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class RegistQeustion extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.register_request);

        Intent intent = getIntent();

        Button move = (Button) findViewById(R.id.move);
        Button notmove = (Button) findViewById(R.id.notmove);

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("result", 0);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        notmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("result", 1);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
