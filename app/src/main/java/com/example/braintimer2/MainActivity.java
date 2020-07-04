package com.example.braintimer2;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button go,b1,b2,b3,b4,playagain;
    TextView timer,points,question,answer;
    Random rand;
    Boolean time=true;
    GridLayout butt;
    int count1,count2;


    public void letsPlay(View view){
        time=true;
        count1=0;
        count2=0;
        playagain.setVisibility(View.INVISIBLE);
        go.setVisibility(View.INVISIBLE);
        timer.setVisibility(View.VISIBLE);
        points.setVisibility(View.VISIBLE);
        question.setVisibility(View.VISIBLE);
        butt.setVisibility(View.VISIBLE);
        answer.setVisibility(View.VISIBLE);
        answer.setText("");
        points.setText("0/0");
        new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int num=(int)millisUntilFinished/1000;
                timer.setText(Integer.toString(num)+"s");
            }
            @Override
            public void onFinish() {
                time=false;
                answer.setText("Done");
                int count1=0,count2=0;
                playagain.setVisibility(View.VISIBLE);
            }
        }.start();
        play();

    }
    public void play(){
        if(time) {
            String num1 = Integer.toString(rand.nextInt(29) + 1);
            String num2 = Integer.toString(rand.nextInt(29) + 1);
            question.setText(num1 + "+" + num2);
            int go = Integer.parseInt(num1) + Integer.parseInt(num2);
            random(go);
        };
    }
    public void random(int num){
        if(time) {
            count1++;
            int ex = rand.nextInt(4);
            String exe = Integer.toString(ex);
            String num1 = (String) b1.getTag();
            String num2 = (String) b2.getTag();
            String num3 = (String) b3.getTag();
            String num4 = (String) b4.getTag();
            if (num1.equals(exe)) {
                b1.setText(Integer.toString(num));
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        right();
                    }
                });
            } else {
                int n = rand.nextInt(50) + 1;
                b1.setText(Integer.toString(n));
                b1.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        wrong();
                    }
                }));
            }
            if (num2.equals(exe)) {
                b2.setText(Integer.toString(num));
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        right();
                    }
                });
            } else {
                int e = rand.nextInt(50) + 1;
                b2.setText(Integer.toString(e));
                b2.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        wrong();
                    }
                }));
            }
            if (num3.equals(exe)) {
                b3.setText(Integer.toString(num));
                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        right();
                    }
                });
            } else {
                int x = rand.nextInt(50) + 1;
                b3.setText(Integer.toString(x));
                b3.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        wrong();
                    }
                }));
            }
            if (num4.equals(exe)) {
                b4.setText(Integer.toString(num));
                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        right();
                    }
                });
            } else {
                int t = rand.nextInt(50) + 1;
                b4.setText(Integer.toString(t));
                b4.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        wrong();
                    }
                }));
            }
        }


    }
    public void right(){
        if(time) {
            count2++;
            answer.setText("Right:)");
            points.setText(Integer.toString(count2)+"/"+Integer.toString(count1));
            play();
        }
    }
    public void wrong(){
        if(time) {
            answer.setText("Wrong:(");
            points.setText(Integer.toString(count2)+"/"+Integer.toString(count1));
            play();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go=findViewById(R.id.button);
        points=findViewById(R.id.textView3);
        question=findViewById(R.id.textView4);
        timer=findViewById(R.id.textView);
        rand=new Random();
        butt=findViewById(R.id.coed);
        b1=findViewById(R.id.button5);
        b2=findViewById(R.id.button6);
        b3=findViewById(R.id.button7);
        b4=findViewById(R.id.button8);
        answer=findViewById(R.id.textView2);
        playagain=findViewById(R.id.button2);

    }
}