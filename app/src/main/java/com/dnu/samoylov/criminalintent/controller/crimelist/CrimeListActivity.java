package com.dnu.samoylov.criminalintent.controller.crimelist;

import android.support.v4.app.Fragment;

import com.dnu.samoylov.criminalintent.controller.SingleFragmentActivity;

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
