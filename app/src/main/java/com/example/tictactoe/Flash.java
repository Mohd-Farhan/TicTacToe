package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Flash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        getSupportActionBar().hide();

        Thread thread = new Thread(){

            public void run(){
                try{
                    sleep(3000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally{
                    Intent intent=new Intent(Flash.this , homeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        };thread.start();

    }
}