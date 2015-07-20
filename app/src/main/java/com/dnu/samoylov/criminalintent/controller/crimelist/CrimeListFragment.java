package com.dnu.samoylov.criminalintent.controller.crimelist;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.dnu.samoylov.criminalintent.R;
import com.dnu.samoylov.criminalintent.model.Crime;
import com.dnu.samoylov.criminalintent.model.CrimeLab;

import java.util.ArrayList;

public class CrimeListFragment extends ListFragment {
    private static final String TAG = "CrimeListFragment";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);

        final CrimeLab mCrimeLab = CrimeLab.get(getActivity());
        setListAdapter(new CrimeAdapter(mCrimeLab.getCrimes()));

    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        final Crime c = (Crime) listView.getItemAtPosition(position);
        Log.d(TAG, c.getTitle() + " was clicked");
    }

    private class CrimeAdapter extends ArrayAdapter<Crime> {
        public CrimeAdapter(ArrayList<Crime> crimes) {
            super(getActivity(), 0, crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_crime, null);
            }

            final Crime crime = getItem(position);

            final TextView titleTextView =
                    (TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleTextView.setText(crime.getTitle());

            final TextView dateTextView =
                    (TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
            dateTextView.setText(crime.getDate().toString());

            final CheckBox solvedCheckBox =
                    (CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            solvedCheckBox.setChecked(crime.isSolved());

            return convertView;
        }
    }
}
