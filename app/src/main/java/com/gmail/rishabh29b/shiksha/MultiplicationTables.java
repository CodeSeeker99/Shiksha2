package com.gmail.rishabh29b.shiksha;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MultiplicationTables extends AppCompatActivity implements View.OnClickListener{

    private int x,y,ans,max,min,max_Length,questionNum,currentQ;
    private String str,name;
    private Button submitBtn, nextBtn;
    private Button _1Btn, _2Btn,_3Btn,_4Btn,_5Btn,_6Btn,_7Btn,_8Btn,_9Btn,_0Btn, ClearBtn, ACBtn;
    private TextView resultTextView,questionTextView, answerTextView,currentQTextView;
    private String[] questions;
    private int[] res;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication_tables);

        if( getIntent().hasExtra("com.gmail.rishabh29b.shiksha.maxVal") )
            max = getIntent().getExtras().getInt("com.gmail.rishabh29b.shiksha.maxVal");

        if( getIntent().hasExtra("com.gmail.rishabh29b.shiksha.num") )
            questionNum = getIntent().getExtras().getInt("com.gmail.rishabh29b.shiksha.num");

        if( getIntent().hasExtra("com.gmail.rishabh29b.shiksha.name") )
            name = getIntent().getExtras().getString("com.gmail.rishabh29b.shiksha.name");
        currentQ = 1;

        //Name unused

        min = 1;
        max_Length = 9;
        questions = new String[questionNum];
        res = new int[questionNum];

        currentQTextView = (TextView) findViewById(R.id.textViewQuestionState);
        resultTextView = (TextView) findViewById(R.id.textViewResult);
        questionTextView = (TextView) findViewById(R.id.textViewQuestion);
        answerTextView = (TextView)findViewById(R.id.textViewAnswer);

        submitBtn = (Button) findViewById(R.id.buttonSubmit1);
        nextBtn = (Button) findViewById(R.id.buttonNext);
        _1Btn = (Button)findViewById(R.id.button1);
        _2Btn = (Button)findViewById(R.id.button2);
        _3Btn = (Button)findViewById(R.id.button3);
        _4Btn = (Button)findViewById(R.id.button4);
        _5Btn = (Button)findViewById(R.id.button5);
        _6Btn = (Button)findViewById(R.id.button6);
        _7Btn = (Button)findViewById(R.id.button7);
        _8Btn = (Button)findViewById(R.id.button8);
        _9Btn = (Button)findViewById(R.id.button9);
        _0Btn = (Button)findViewById(R.id.button0);
        ClearBtn = (Button) findViewById(R.id.buttonClear);
        ACBtn = (Button) findViewById(R.id.buttonAllClear);



        x = (int)(Math.random()*(max-min+1))+min;
        y = (int)(Math.random()*(max-min+1))+min;

        currentQTextView.setText("Question : " + currentQ + " of " + questionNum);
        questionTextView.setText(x + " x " + y + " ?");


        submitBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
        _1Btn.setOnClickListener(this);
        _2Btn.setOnClickListener(this);
        _3Btn.setOnClickListener(this);
        _4Btn.setOnClickListener(this);
        _5Btn.setOnClickListener(this);
        _6Btn.setOnClickListener(this);
        _7Btn.setOnClickListener(this);
        _8Btn.setOnClickListener(this);
        _9Btn.setOnClickListener(this);
        _0Btn.setOnClickListener(this);
        ClearBtn.setOnClickListener(this);
        ACBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        str = answerTextView.getText().toString();

        switch (v.getId()) {
            case R.id.buttonSubmit1:
                if (str.length() != 0)
                    ans = Integer.parseInt(str);
                else
                    ans = -1;

                questions[currentQ-1] =  x + " x " + y;
                if(x*y == ans)
                {
                    resultTextView.setText("Correct!");
                    resultTextView.setBackgroundColor(Color.parseColor("#FF7CC95A"));
                    res[currentQ-1] = 1;
                    Toast toast = Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT);
                    toast.show();
                    //nextBtn.setEnabled(true);
                }
                else {
                    resultTextView.setBackgroundColor(Color.parseColor("#FFDE5C53"));
                    resultTextView.setText("Incorrect!");
                    res[currentQ-1] = 0;
                    Toast toast = Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT);
                    toast.show();
                }

                if(currentQ < questionNum) {
                    x = (int)(Math.random()*(max-min+1))+min;
                    y = (int)(Math.random()*(max-min+1))+min;
                    currentQ++;
                    questionTextView.setText(x + " x " + y + " ?");
                    currentQTextView.setText("Question : " + currentQ + " of " + questionNum);
                    resultTextView.setText(" ");
                    resultTextView.setBackgroundColor(Color.parseColor("#f8d671"));
                    str = "";

                }
                else
                {
                    resultTextView.setText( resultTextView.getText().toString() + " Click next to finish");
                    str = "";
                    submitBtn.setEnabled(false);
                    nextBtn.setEnabled(true);
                }
                break;
            case R.id.buttonNext:
                Intent startResult = new Intent(this, resultActivity.class);
                startResult.putExtra("com.gmail.rishabh29b.shiksha.name", name);
                startResult.putExtra("com.gmail.rishabh29b.shiksha.questions", questions);
                startResult.putExtra("com.gmail.rishabh29b.shiksha.results", res);

                startActivity(startResult);
                break;
            case R.id.button0:
                str = str + "0";
                break;
            case R.id.button1:
                str = str +"1";
                break;
            case R.id.button2:
                str = str + "2";
                break;
            case R.id.button3:
                str = str + "3";
                break;
            case R.id.button4:
                str = str + "4";
                break;
            case R.id.button5:
                str = str + "5";
                break;
            case R.id.button6:
                str = str + "6";
                break;
            case R.id.button7:
                str = str + "7";
                break;
            case R.id.button8:
                str = str + "8";
                break;
            case R.id.button9:
                str = str + "9";
                break;
            case R.id.buttonClear:
                if(str.length()!=0)
                    str = str.substring(0,str.length()-1);
                break;
            case R.id.buttonAllClear:
                str = "";
                break;

            default:
                Toast toast = Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT);
                toast.show();
        }

        if(str.length() >= max_Length)
        {
            answerTextView.setText(str.substring(1));
        }
        else
            answerTextView.setText(str);
    }
}
