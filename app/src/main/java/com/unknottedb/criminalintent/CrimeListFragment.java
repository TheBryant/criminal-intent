package com.unknottedb.criminalintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.unknottedb.criminalintent.dummy.DummyContent;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.ArrayList;

public class CrimeListFragment extends ListFragment implements CrimeFragment.OnFragmentInteractionListener{

    private ArrayList<Crime> mCrimes;
    private static final String TAG = "CrimeListFragment";
    public CrimeListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);
        mCrimes = CrimeLab.get(getActivity()).getCrimes();

        CrimeAdapter adapter = new CrimeAdapter(mCrimes);
        setListAdapter(adapter);
    }
    @Override
    public void onResume(){
        super.onResume();
        ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Crime c = ((CrimeAdapter)getListAdapter()).getItem(position);
        Intent i = new Intent(getActivity(), CrimePagerActivity.class);
        i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getID());
        startActivity(i);
    }

    public class CrimeAdapter extends ArrayAdapter<Crime>{
        public CrimeAdapter(ArrayList<Crime> crimes){
            super(getActivity(), 0, crimes);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if (convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
            }
            Crime c = getItem(position);

            TextView titleTextView = (TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleTextView.setText(c.getTitle());
            TextView dateTextView = (TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
            String dateString = DateFormat.getDateTimeInstance().format(c.getDate());
            dateTextView.setText(dateString);
            CheckBox solvedCheckBox =  (CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            solvedCheckBox.setChecked(c.isSolved());

            return convertView;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri){
        Toast toast = Toast.makeText(getActivity(), "asd", Toast.LENGTH_SHORT);
        toast.show();
    }

}
