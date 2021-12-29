package com.quyen.gamebubble;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Random r = new Random();
    ObjectAnimator animator;
    RelativeLayout relativeLayout;
    ViewGroup.LayoutParams params;
    Button btn3, btn6, btn9;
    int diem =0;
    TextView txtScore ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addcontrol();
        addEvent();
    }

    private void addEvent() {
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = r.nextInt(3);
                for ( int i =0; i <=n ; i++){
                    processAnim();
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = r.nextInt(6)+1;
                for ( int i =0; i <=n ; i++){

                    processAnim();
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = r.nextInt(9)+2;
                for ( int i =0; i <=n ; i++){
                    processAnim();
                }
            }
        });
    }

    private void processAnim() {
        ImageView img = new ImageView(this);

        img.setX(r.nextInt(1000));
        img.setBackground(getDrawable());

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relativeLayout.removeView(view);

                txtScore.setText("Score : "+(diem+=3));
            }
        });

        animator = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this,
                R.animator.animator);
        //set Thoi gian hieu ung chay ngau nhien
        animator.setDuration(r.nextInt(3000));
        animator.setTarget(img);
        relativeLayout.addView(img,params);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                relativeLayout.removeAllViews();
                diem = 0;
                Toast.makeText(MainActivity.this,"Game over",Toast.LENGTH_SHORT).show();
                txtScore.setText("Score : 0");

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.start();


    }

    private void addcontrol() {
        btn3 = findViewById(R.id.btn3);
        btn6 = findViewById(R.id.btn6);
        btn9 = findViewById(R.id.btn9);
        relativeLayout = findViewById(R.id.linearLayout);
        txtScore = findViewById(R.id.txt);


        params =new ViewGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    private Drawable getDrawable() {
        Drawable drawable;
        int i = r.nextInt(6);
        switch (i){
            case 0:
                drawable = getResources().getDrawable(R.drawable.bubble0001);
                break;
            case 1:
                drawable = getResources().getDrawable(R.drawable.bubble0002);
                break;
            case 2:
                drawable = getResources().getDrawable(R.drawable.bubble0003);
                break;
            case 3:
                drawable = getResources().getDrawable(R.drawable.bubble0004);
                break;
            case 4:
                drawable = getResources().getDrawable(R.drawable.bubble0005);
                break;
            case 5:
                drawable = getResources().getDrawable(R.drawable.bubble0006);
                break;

            default:
                drawable = getResources().getDrawable(R.drawable.bubble0001);
                break;
        }
        return drawable;
    }
}