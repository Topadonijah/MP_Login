package com.example.sol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import org.w3c.dom.Text;

public class ThirdActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){



        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        TextView cinfo = (TextView) findViewById(R.id.cinfo);
        Button signup = (Button) findViewById(R.id.signup);
        if(id != null){
            signup.setText("회원 정보");
            cinfo.setText(id+" 님 환영합니다.");

            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent clientinfo = new Intent(getApplicationContext(),
                            Clientinfo.class);
                    clientinfo.putExtra("id", id);
                    startActivity(clientinfo);
                }
            });
        }
        else{
            signup.setVisibility(View.VISIBLE);
            cinfo.setText("비회원으로 사용중입니다.");

            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent register = new Intent(getApplicationContext(),
                            RegistQeustion.class);
                    startActivityForResult(register, 0);
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 0: // Third레이아웃으로 보냈던 요청
                if (resultCode == RESULT_OK) { // 결과가 OK
                    int result = data.getIntExtra("result", -1);
                    if( result == 0 ){
                        Intent move = new Intent(getApplicationContext(),
                                SecondActivity.class);
                        startActivity(move);
                        finish();
                    }
                }
                break;
        }
    }
}
