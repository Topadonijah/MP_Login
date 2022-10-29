package com.example.sol;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class Products extends LinearLayout {

    public Products(Context context){
        super(context);

        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.product, this, true);
    }

}
