package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class homeActivity extends AppCompatActivity {
    public static final String player1="homeActivity.player1";
    public static final String player2="homeActivity.player2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

    }

    public void Start(View view){
        Intent intent=new Intent(this,MainActivity.class);
        EditText editText1=findViewById(R.id.editText1);
        EditText editText2=findViewById(R.id.editText2);
        String p1=editText1.getText().toString();
        String p2=editText2.getText().toString();
        intent.putExtra(player1,p1);
        intent.putExtra(player2,p2);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Do you want to exit?")
        .setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                homeActivity.super.onBackPressed();


            }
        })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();

    }
}