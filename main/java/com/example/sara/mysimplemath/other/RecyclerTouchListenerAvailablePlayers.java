package com.example.sara.mysimplemath.other;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Sara on 13.4.2017..
 */

public class RecyclerTouchListenerAvailablePlayers implements RecyclerView.OnItemTouchListener {
    private GestureDetector gestureDetector;
    private OnItemClickListener mListener;

    //for disabling recycler view when item is selected
    public boolean touch = false;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public RecyclerTouchListenerAvailablePlayers(Context context, OnItemClickListener listener) {
        mListener = listener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener != null && gestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
        }
        return touch;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {}

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {}
}
