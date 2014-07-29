package com.unknottedb.criminalintent;


import android.app.AlertDialog;
import android.app.Dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class DateTimeFragment extends DialogFragment {
    public static final String EXTRA_DATE = "com.unknottedb.android.criminalintent.date_time";
    private Date mDate;

    public static DateTimeFragment newInstance(Date date){
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_DATE, date);

        DateTimeFragment fragment = new DateTimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        mDate = (Date)getArguments().getSerializable(EXTRA_DATE);
        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_or_date_time, null);
        Button DateButton = (Button)v.findViewById(R.id.or_button_date);
        DateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstance(mDate);
                dialog.setTargetFragment(getTargetFragment(), CrimeFragment.REQUEST_DATE);
                dialog.show(fm, CrimeFragment.DIALOG_DATE);
            }
        });
        Button TimeButton = (Button)v.findViewById(R.id.or_button_time);
        TimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(mDate);
                dialog.setTargetFragment(getTargetFragment(), CrimeFragment.REQUEST_TIME);
                dialog.show(fm, CrimeFragment.DIALOG_TIME);
            }
        });
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.or_date_time_title)
                .create();
    }


}
