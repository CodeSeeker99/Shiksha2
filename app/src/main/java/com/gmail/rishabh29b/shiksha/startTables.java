package com.gmail.rishabh29b.shiksha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class startTables extends AppCompatActivity implements View.OnClickListener{

    EditText nameEditText,numEditText,maxEditText;
    String str,str1,str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_tables);


        Button submitBtn = (Button) findViewById(R.id.buttonSubmit1);
        nameEditText = (EditText)findViewById(R.id.editTextName);
        numEditText = (EditText) findViewById(R.id.editTextQuesNum);
        maxEditText = (EditText)findViewById(R.id.editTextMax);

        submitBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        str = nameEditText.getText().toString().trim();
        str1 = numEditText.getText().toString();
        str2 = maxEditText.getText().toString();

        Toast toast = Toast.makeText(this, "Please enter all the fields!", Toast.LENGTH_LONG);

        if(str.length() == 0 || str1.length() == 0 || str2.length() == 0)
            toast.show();
        else
        {
            int max = Integer.parseInt(str2);
            int num = Integer.parseInt(str1);

            if(max<2 || max>10) {
                toast = Toast.makeText(this,"You cannot give the test for this maximum value!", Toast.LENGTH_SHORT);
                toast.show();
            }
            else if(num < 1) {
                toast = Toast.makeText(this,"You cannot give the test for less that 1 question!!", Toast.LENGTH_SHORT);
                toast.show();
            }
            else if(num > 20) {
                toast = Toast.makeText(this,"You cannot give the test for more than 20 questions!", Toast.LENGTH_SHORT);
                toast.show();
            }
            else {
                Intent startMultiplication = new Intent(this, MultiplicationTables.class);
                startMultiplication.putExtra("com.gmail.rishabh29b.shiksha.num", num);
                startMultiplication.putExtra("com.gmail.rishabh29b.shiksha.maxVal", max);
                startMultiplication.putExtra("com.gmail.rishabh29b.shiksha.name", str);
                startActivity(startMultiplication);
            }
        }



    }
}
