package com.example.sol;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;

import org.w3c.dom.Text;
import java.util.ArrayList;

public class Myadapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<Products> products;

    public Myadapter(Context context, ArrayList<Products> data) {
        mContext = context;
        products = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public long getItemId(int position) {
        return position;

    }

    @Override
    public Products getItem(int position) {
        return products.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = mLayoutInflater.inflate(R.layout.product, null);

        ImageView imageView = (ImageView)view.findViewById(R.id.image);
        TextView productName = (TextView)view.findViewById(R.id.title);
        Button pos = (Button)view.findViewById(R.id.delete);
        pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext.getApplicationContext(), "123", Toast.LENGTH_SHORT).show();
            }
        });
        imageView.setImageResource(products.get(position).getImage());
        productName.setText(products.get(position).getName());
        return view;
    }



}