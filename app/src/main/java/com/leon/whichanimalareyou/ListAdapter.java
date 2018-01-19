package com.leon.whichanimalareyou;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Leon on 9.1.2018..
 */

public class ListAdapter extends ArrayAdapter<String> {
    private final int mResource;
    private final SpinnerListener mSpinnerListener;

    public ListAdapter(@NonNull Context context, int resource, SpinnerListener spinnerListener) {
        super(context, resource);
        mResource = resource;
        mSpinnerListener = spinnerListener;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(mResource, null, false);
        }

        TextView textView = convertView.findViewById(R.id.textView);
        Spinner spinner = convertView.findViewById(R.id.spinner);

        textView.setText(Data.getQuestions().get(position));
        spinner.setSelection(2);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int index, long id) {
                mSpinnerListener.onSpinnerItemSelected(position, index);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return convertView;
    }

    @Override
    public int getCount() {
        return Data.getQuestions().size();
    }

    interface SpinnerListener {
        void onSpinnerItemSelected(int questionPosition, int spinnerPosition);
    }
}