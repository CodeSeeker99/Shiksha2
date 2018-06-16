package com.gmail.rishabh29b.shiksha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {

    String[] questions;
    int[] result;
    String name;

    private ListView reportListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        if( getIntent().hasExtra("com.gmail.rishabh29b.shiksha.questions")) {
            questions = getIntent().getStringArrayExtra("com.gmail.rishabh29b.shiksha.questions");
            result = getIntent().getIntArrayExtra("com.gmail.rishabh29b.shiksha.results");
            name = getIntent().getStringExtra("com.gmail.rishabh29b.shiksha.name");
        }

        reportListView = (ListView) findViewById(R.id.listViewReport);
        TextView nameTextView = (TextView)findViewById(R.id.textViewTitleName);
        nameTextView.setText(name+"'s Report");
        ItemAdapter itemAdapter = new ItemAdapter(this, questions, result);
        reportListView.setAdapter(itemAdapter);

    }
}
