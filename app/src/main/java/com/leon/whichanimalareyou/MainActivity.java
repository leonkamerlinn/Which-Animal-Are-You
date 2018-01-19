package com.leon.whichanimalareyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ListView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements ListAdapter.SpinnerListener {
    public static final String EXTRA_SELECTION = "extra_selection";
    public static final String EXTRA_CAPTION = "extra_caption";
    private ListView mListView;
    private int[] mSelection;
    private AppCompatButton mButton;
    private TextInputEditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.listView);
        ListAdapter adapter = new ListAdapter(this, R.layout.list_item, this);
        mListView.setAdapter(adapter);
        mButton = findViewById(R.id.submit);
        mEditText = findViewById(R.id.edit_text);
        mSelection = new int[adapter.getCount()];

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AnimalActivity.class);
                intent.putExtra(EXTRA_SELECTION, mSelection);
                intent.putExtra(EXTRA_CAPTION, mEditText.getText().toString());
                startActivity(intent);
            }
        });
    }


    @Override
    public void onSpinnerItemSelected(int questionPosition, int spinnerPosition) {
        mSelection[questionPosition] = spinnerPosition;
    }
}
