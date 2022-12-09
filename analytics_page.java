package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class analytics_page extends AppCompatActivity {

    TextView scre, corr,incrr,accuracyAns,attempted;
    int correct,wrong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics_page);
        scre=findViewById(R.id.scoreAns);
        corr=findViewById(R.id.correct);
        incrr=findViewById(R.id.incorrect);
        accuracyAns=findViewById(R.id.accuracyAns);


        SharedPreferences sharedPreferences=getSharedPreferences("myshared",MODE_PRIVATE);
        int s1=sharedPreferences.getInt("correct",correct);
        int s2=sharedPreferences.getInt("incorrect",wrong);
        int s3=s1+s2;
        float acc = (((float)s1/5)*100);
        accuracyAns.setText(String.valueOf(acc)+"%");
        scre.setText(String.valueOf(s1));
        incrr.setText(String.valueOf(s2));
        corr.setText(String.valueOf(s1));
    }
}