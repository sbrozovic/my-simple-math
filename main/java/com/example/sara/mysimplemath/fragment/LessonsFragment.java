package com.example.sara.mysimplemath.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sara.mysimplemath.R;
import com.example.sara.mysimplemath.activity.MainActivity;

/**
 * Lessons
 *
 * It is part of MainActivity
 */
public class LessonsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_lessons, container, false);
        ((MainActivity) getActivity()).setActionBarTitle("Lessons");
        return layout;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
