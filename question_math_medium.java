package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class question_math_medium extends AppCompatActivity {
    TextView tv;
    Button submitbutton,next;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    String questions[] = {
            "HCF of 26 and 91 is:",
            "The largest number that divides 70 and 125, which leaves the remainders 5 and 8, is:",
            "The least number that is divisible by all the numbers from 1 to 5 is:",
            "For any two positive integers a and b, HCF (a, b) × LCM (a, b) = ",
            "For some integer n, the odd integer is represented in the form of:"

    };
    String answers[] = {"13", "13", "60", "a*b", "2n+1"};
    String opt[] = {
            "15", "13", "19", "11",
            "65", "15", "13", "11",
            "70", "60", "80", "90",
            "1", "(a*b)/2", "a/b", "a*b",
            "n", "n+1", "2n+1", "2n-1"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_math_medium);
        next = findViewById(R.id.next);
        //submitbutton = findViewById(R.id.submit);
        tv = (TextView) findViewById(R.id.ques);
        radio_g = (RadioGroup) findViewById(R.id.rd);
        rb1 = (RadioButton) findViewById(R.id.o1);
        rb2 = (RadioButton) findViewById(R.id.o2);
        rb3 = (RadioButton) findViewById(R.id.o3);
        rb4 = (RadioButton) findViewById(R.id.o4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if (ansText.equals(answers[flag])) {
                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    correct++;
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    wrong++;
                }

                flag++;



                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag * 4]);
                    rb2.setText(opt[flag * 4 + 1]);
                    rb3.setText(opt[flag * 4 + 2]);
                    rb4.setText(opt[flag * 4 + 3]);
                } else {
                    next.setText("Submit");
                    marks = correct;
                    SharedPreferences sharedPreferences=getSharedPreferences("myshared",MODE_PRIVATE);
                    SharedPreferences.Editor myedit=sharedPreferences.edit();
                    myedit.putInt("correct",correct);
                    myedit.putInt("incorrect",wrong);
                    myedit.apply();
                    Intent in = new Intent(getApplicationContext(), analytics_page.class);
                    startActivity(in);
                }
                radio_g.clearCheck();

            }
        });
    }
}