package com.example.sara.mysimplemath.fragment;

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
 * Derivations
 * Shows first screen of derivations lessons
 */
public class DerivationsFragment extends Fragment {

    Button btn_next;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle("Derivations");
        View layout = inflater.inflate(R.layout.fragment_derivations, container, false);
        btn_next = (Button) layout.findViewById(R.id.button_derivations_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LessonActivity.class);
                intent.putExtra("Lesson_tip", "Derivations");
                startActivity(intent);
            }
        });

        return layout;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
