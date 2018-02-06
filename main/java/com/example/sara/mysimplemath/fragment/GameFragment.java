package com.example.sara.mysimplemath.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.sara.mysimplemath.R;
import com.example.sara.mysimplemath.activity.MainActivity;

/**
 * Game
 *
 * It is part of MainActivity
 */
public class GameFragment extends Fragment{
    public EditText edit_text_player;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle("Game");
        View layout = inflater.inflate(R.layout.fragment_game, container, false);


        edit_text_player = (EditText) layout.findViewById(R.id.editText_name);

        return layout;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}