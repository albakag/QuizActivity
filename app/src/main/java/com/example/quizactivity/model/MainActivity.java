package com.example.quizactivity.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizactivity.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnTrue, btnfals;
    TextView showWords, counter, totalAmount;

    private final int currentIndex = 0;
    int mCounter = 0;
    int mTotalCounter = 1;
    String mScounter = String.valueOf(mCounter);
    String mStotalCounter = String.valueOf(mTotalCounter);
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTrue = (Button) findViewById(R.id.true_btn);
        btnfals = (Button) findViewById(R.id.false_btn);
        showWords = (TextView) findViewById(R.id.words_here);
        counter = (TextView) findViewById(R.id.counter);
        totalAmount = (TextView) findViewById(R.id.total_amount);

        counter.setText(mScounter);
        totalAmount.setText(mStotalCounter);

        wordFinder();
        String abc = String.valueOf(wordFinder());
        showWords.setText(abc);
//        showWords.setText(words[(int) (Math.random()*10)]);

        View.OnClickListener onClickListener = view -> {
//            showWords.setText(words[(int) (Math.random()*10)]);
            wordFinder();
            String adfb = String.valueOf(wordFinder());
            showWords.setText(adfb);
            switch (view.getId()) {
                case R.id.true_btn: Toast.makeText(MainActivity.this, R.string.right_answer, Toast.LENGTH_SHORT).show();
                mCounter++;
                mTotalCounter++;
                mScounter = String.valueOf(mCounter);
                counter.setText(mScounter);
                mStotalCounter = String.valueOf(mTotalCounter);
                totalAmount.setText(mStotalCounter);
                    break;
                case R.id.false_btn: Toast.makeText(MainActivity.this, R.string.unright, Toast.LENGTH_SHORT).show();
                mTotalCounter++;
                mStotalCounter = String.valueOf(mTotalCounter);
                totalAmount.setText(mStotalCounter);
                break;
            }
        };
        btnTrue.setOnClickListener(onClickListener);
        btnfals.setOnClickListener(onClickListener);
    }
    public int wordFinder() {
        int a;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add((int) (Math.random()*100));
        }
        return a = numbers.get((int) (Math.random()*100));
    }

}