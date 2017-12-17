package com.example.ondra.fuelbook.activity;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Ondra on 17.12.2017.
 */

public class CarTouchListener implements RecyclerView.OnItemTouchListener {
    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
    private ClickListener clickListener;
    public CarTouchListener(final ClickListener clickListener)
    {
        this.clickListener = clickListener;
    }
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
       View child = rv.findChildViewUnder(e.getX(),e.getY());
       if(child != null && clickListener != null)
       {
           clickListener.onClick(child,rv.getChildPosition(child));
       }
       return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}