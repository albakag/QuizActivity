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

public class MainActivity extends AppCompatActivity {

    Button btnTrue, btnFals;
    TextView tvShowWords, tvShowResultsOnline;
    final String space = " ";

    int mCounter = 0;
    int mTotalCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTrue = (Button) findViewById(R.id.btn_true_btn);
        btnFals = (Button) findViewById(R.id.btn_false_btn);
        tvShowWords = (TextView) findViewById(R.id.tv_words_here);
        tvShowResultsOnline = findViewById(R.id.tv_amount_answers);
        tvShowWords.setText(wordFinder());

        View.OnClickListener onClickListener = view -> {
            tvShowWords.setText(wordFinder());
            StringBuffer strBuffer = new StringBuffer();
            switch (view.getId()) {
                case (R.id.btn_true_btn): Toast.makeText(MainActivity.this, R.string.right_answer, Toast.LENGTH_SHORT).show();
                    tvShowResultsOnline.setText(strBuffer.append(getString(R.string.true_amout_answers)).
                            append(space).append(++mCounter).
                            append(space).append(getString(R.string.total_amount_answers)).
                            append(space).append(++mTotalCounter));
                    break;
                case (R.id.btn_false_btn): Toast.makeText(MainActivity.this, R.string.unright, Toast.LENGTH_SHORT).show();
                    tvShowResultsOnline.setText(strBuffer.append(getString(R.string.true_amout_answers)).
                            append(space).append(mCounter).
                            append(space).append(getString(R.string.total_amount_answers)).
                            append(space).append(++mTotalCounter));
                    break;
            }
        };

        btnTrue.setOnClickListener(onClickListener);
        btnFals.setOnClickListener(onClickListener);
    }

    final String abc = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    char [] alphabit = abc.toCharArray();
    List<Character> numbers = new ArrayList<>();
    String answer;

    public String wordFinder() {
        for (int i = 0; i < alphabit.length; i++) {
            numbers.add(alphabit[i]);
        }
        answer = numbers.get((int) (Math.random()*33)).toString();
        return answer;
    }

}