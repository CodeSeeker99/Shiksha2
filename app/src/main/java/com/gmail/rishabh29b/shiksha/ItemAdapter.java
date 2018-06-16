package com.gmail.rishabh29b.shiksha;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    private LayoutInflater mInflator;
    private String[] questions;
    private int[] result;

    public ItemAdapter(Context c, String[] q,int[] r) {
        questions = q;
        result = r;
        mInflator = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return questions.length;
    }

    @Override
    public Object getItem(int i) {
        return questions[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        View v = mInflator.inflate(R.layout.my_report_detail,null);
        TextView questionTextView = (TextView)v.findViewById(R.id.textViewQuestionName);
        TextView resultTextView = (TextView)v.findViewById(R.id.textViewResultName);

        String name = questions[i];
        int res = result[i];

        if(res == 1) {
            questionTextView.setBackgroundColor(Color.parseColor("#FF7CC95A"));
            resultTextView.setText("Correct!");
        }
        else {
            questionTextView.setBackgroundColor(Color.parseColor("#FFDE5C53"));
            resultTextView.setText("Incorrect.");
        }
        questionTextView.setText(name);


        return v;
    }
}
