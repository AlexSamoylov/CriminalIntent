package com.dnu.samoylov.criminalintent.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.dnu.samoylov.criminalintent.R;
import com.dnu.samoylov.criminalintent.model.Crime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, parent, false);

        initTitleField(v);
        initSolvedCheckBox(v);
        initDateButton(v);



        return v;
    }

    private void initTitleField(View v) {
        mTitleField = (EditText)v.findViewById(R.id.crime_title);

        mTitleField.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(
                    CharSequence c, int start, int before, int count) {
                mCrime.setTitle(c.toString());
            }

            public void beforeTextChanged(
                    CharSequence c, int start, int count, int after) {
                //---
            }

            public void afterTextChanged(Editable c) {
                //---
            }
        });
    }

    private void initSolvedCheckBox(View v) {
        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });
    }

    private void initDateButton(View v) {
        mDateButton = (Button)v.findViewById(R.id.crime_date);
        final DateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
        mDateButton.setText(dateFormat.format(mCrime.getDate()));
        mDateButton.setEnabled(false);
    }
}
