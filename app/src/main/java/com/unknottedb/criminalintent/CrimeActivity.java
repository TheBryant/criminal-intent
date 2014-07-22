package com.unknottedb.criminalintent;

import android.app.Fragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;


public class CrimeActivity extends SingleFragmentActivity implements CrimeFragment.OnFragmentInteractionListener {

    @Override
    protected Fragment createFragment(){
        return new CrimeFragment();
    }

    @Override
    public void onFragmentInteraction(Uri uri){
        Toast toast = Toast.makeText(this, "asd", Toast.LENGTH_SHORT);
        toast.show();
    }



}
