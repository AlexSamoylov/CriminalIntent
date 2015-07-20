package com.dnu.samoylov.criminalintent.controller.crime;

import android.support.v4.app.Fragment;

import com.dnu.samoylov.criminalintent.controller.SingleFragmentActivity;


public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }

}
