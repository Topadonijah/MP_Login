package com.example.sol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ThirdActivity extends Activity{
    ArrayList<Products> productDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        //상품정보 바인딩 --------------------------------------------------//
        this.InitializeProductData();

        ListView listView = (ListView) findViewById(R.id.listView);
        final Myadapter myAdapter = new Myadapter(getApplicationContext(), productDataList);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
        //상품정보 바인딩 끝--------------------------------------------------//

        //회원정보 창 ---------------------------------------------//
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
                            RegistQuestion.class);
                    startActivityForResult(register, 0);
                }
            });
        }
    }
    //회원정보 창 끝 ---------------------------------------------//
    public void InitializeProductData(){ //리스트뷰에 추가할 항목들을 초기화 해줌
        productDataList = new ArrayList<Products>();
        productDataList.add(new Products(R.drawable.carrot, "당근"));
        productDataList.add(new Products(R.drawable.cat, "고양이"));
        productDataList.add(new Products(R.drawable.pie, "안드로이드"));
        productDataList.add(new Products(R.drawable.dog, "강아지"));
        productDataList.add(new Products(R.drawable.rabbit, "토끼"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 0: // 비회원일시 회원가입 여부를 물어봄
                if (resultCode == RESULT_OK) { // 결과가 OK
                    int result = data.getIntExtra("result", -1);
                    if( result == 0 ){
                        Intent move = new Intent(getApplicationContext(),
                                SecondActivity.class);
                        startActivity(move);
                        finish();
                    }
                }
        }
    }
}