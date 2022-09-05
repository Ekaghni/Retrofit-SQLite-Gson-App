package com.generic_corp.creinnovationsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class secondPage extends AppCompatActivity {
    ImageView imageView;
    db DB;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()== NetworkInfo.State.CONNECTED){
            Toast.makeText(this, "Connection Unavailable", Toast.LENGTH_SHORT).show();

        }
        else {

            workInDB();
        }

        String imgUrl = getIntent().getExtras().getString("imageLink");







        imageView = findViewById(R.id.secondImage);

        Picasso.get().load(imgUrl).into(imageView);





    }
    public void workInDB(){
        textView = findViewById(R.id.dbImageLink);
        String imgUrl = getIntent().getExtras().getString("imageLink");
        DB = new db(this);
        Boolean check = DB.insertData(imgUrl);
        if (check==true){
            Toast.makeText(this, "Image Stored Successfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Error in storing Image", Toast.LENGTH_SHORT).show();
        }



        /////////////////////



        Cursor res = DB.getData();
        if (res.getCount()==0){
            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show();

        }
        StringBuffer buffer = new StringBuffer();
        String xyz = null;
        while (res.moveToNext()){
            buffer.append("Image link-->"+res.getString(0)+"\n");
            xyz = "Image link-->"+res.getString(0)+"\n";
        }
        textView.setText(xyz);
    }
}