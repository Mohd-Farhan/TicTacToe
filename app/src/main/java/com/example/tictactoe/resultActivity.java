package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Thread thread = new Thread(){

            public void run(){
                try{
                    Intent intent=getIntent();
                    String result=intent.getStringExtra(MainActivity.result);
                    TextView winner = findViewById(R.id.textView3);
                    winner.setText(result);
                    sleep(2000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally{
                    Intent intent=new Intent( resultActivity.this , homeActivity.class);
                   startActivity(intent);
                   finish();
                }
            }

        };thread.start();
    }
}