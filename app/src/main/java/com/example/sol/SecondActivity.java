package com.example.sol;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class SecondActivity extends Activity {
    String id_result = "";
    int idOk = 0;
    int pwOk = 0;
    int checkOk = 0;

    @Override
    protected  void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Intent inIntent = getIntent();
        final String Namevalue = inIntent.getStringExtra("이름");


        //중복 확인 버튼 ----------------------------------------------//
        Button overlap = (Button) findViewById(R.id.overlap);
        overlap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText newid = (EditText) findViewById(R.id.newid);
                String input = newid.getText().toString();
                LinearLayout hidden = (LinearLayout) findViewById(R.id.overlap_result);

                SharedPreferences check = getSharedPreferences("Clients",MODE_PRIVATE);
                String id_check1 = check.getString(input, null);
                TextView a = (TextView) findViewById(R.id.id_overlap);

                if(input.length() == 0){
                    a.setText("아이디를 입력해 주세요");
                }
                else if(id_check1 != null){
                    a.setText("중복된 아이디 입니다.");
                }
                else{
                    Toast.makeText(getApplicationContext(),input,Toast.LENGTH_SHORT).show();
                    a.setText("사용가능한 아이디 입니다.");
                    idOk = 1;
                    id_result = input; //사용할 아이디를 미리 저장
                }

                hidden.setVisibility(View.VISIBLE);
            }
        });
        //중복 확인 버튼 끝--------------------------------------//

        //비밀번호가 유효한지 확인 --------------------//
        EditText pweditText = (EditText) findViewById(R.id.pwedit);
        TextView pwcheck = (TextView) findViewById(R.id.pwcheck);

        pweditText.addTextChangedListener(new TextWatcher() {

            String pretext, nowtext;
            @Override

            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                pretext = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.equals(pretext)){return;} //변함 없다면 메소드 종료

                int length = 0; int upper = 0; int special = 0; int ascii = 0;
                int index = 0;
                nowtext = charSequence.toString();

                if(nowtext.length() > 7){
                    length = 1;
                }

                while(index < nowtext.length()){
                    ascii = (int)nowtext.charAt(index);
                    if(ascii <= 90 && ascii >= 65){
                        upper = 1;
                    }
                    else if (ascii >=33 && ascii <=47){
                        special = 1;
                    }
                    else if (ascii >=58 && ascii<=64){
                        special= 1;
                    }
                    else if (ascii >= 91 && ascii <= 96){
                        special = 1;
                    }
                    else if (ascii >= 123 && ascii <= 126){
                        special = 1;
                    }
                    index++;
                }

                if (length + upper + special == 3){ //세 조건을 모두 만족한다면
                    pwcheck.setText("사용가능한 비밀번호 입니다.");
                    pwcheck.setTextColor(Color.parseColor("#FF00FFFF"));
                    pwOk = 1;
                }
                else{
                    pwcheck.setText("8자리 이상 대문자, 특수문자 포함");
                    pwcheck.setTextColor(Color.parseColor("#FFFF0000"));
                    pwOk = 0;
                }

            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        //비밀번호가 유효한지 확인 끝---------------//


        //체크버튼 -------------------------------------------//
        RadioGroup group = (RadioGroup) findViewById(R.id.radiogroup);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.decline){
                    Toast.makeText(getApplicationContext(), "약관에 동의하셔야 회원가입이 가능합니다..",Toast.LENGTH_SHORT).show();
                    checkOk = 0;
                }
                else if(i == R.id.accept){
                    checkOk = 1;
                }
            }
        });
        //체크버튼 끝 ----------------------------------------//


        //회원가입 버튼---------------------------------------//
        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(idOk + pwOk+ checkOk == 3) {
                    Intent outIntent = new Intent(getApplicationContext(),
                            MainActivity.class);
                    setResult(RESULT_OK, outIntent);
                    finish();
                }
                else if(idOk == 0){
                    Toast.makeText(getApplicationContext(),"아이디 중복검사를 해주세요",Toast.LENGTH_SHORT).show();
                }
                else if(pwOk == 0){
                        Toast.makeText(getApplicationContext(),"비밀번호가 적절하지 않습니다.",Toast.LENGTH_SHORT).show();
                }
                else if(checkOk == 0){
                    Toast.makeText(getApplicationContext(),"개인정보 약관에 동의해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //회원가입 버튼 끝----------------------------------------//

    }


}
