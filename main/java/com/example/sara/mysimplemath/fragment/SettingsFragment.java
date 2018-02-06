package com.example.sara.mysimplemath.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.example.sara.mysimplemath.R;
import com.example.sara.mysimplemath.activity.MainActivity;

/**
 * Settings
 *
 * It is part of MainActivity
 */
public class SettingsFragment extends Fragment {
    public Spinner spin_sound;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_settings, container, false);
        ((MainActivity) getActivity()).setActionBarTitle("Settings");
        spin_sound= (Spinner) layout.findViewById(R.id.spinner_sound);
        return layout;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}