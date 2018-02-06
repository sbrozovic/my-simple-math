package com.example.sara.mysimplemath.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sara.mysimplemath.R;
import com.example.sara.mysimplemath.activity.LessonActivity;
import com.example.sara.mysimplemath.activity.MainActivity;

/**
 * Equations
 * Shows first screen of equations lessons
 */
public class EquationsFragment extends Fragment {
    Button btn_next;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle("Equations");
        View layout = inflater.inflate(R.layout.fragment_equations, container, false);
        btn_next = (Button) layout.findViewById(R.id.button_equations_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LessonActivity.class);
                intent.putExtra("Lesson_tip", "Equations");
                startActivity(intent);
            }
        });

        return layout;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
