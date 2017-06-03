package com.example.ninebit.linguamea.interfaces;

import android.view.View;

/**
 * Created by NineB on 4/16/2017.
 */

public interface ClickListener {
    public void onItemClicked(View view, int position);
    public void onOptionsClicked(View view, int position);
    public boolean onItemLongClicked(View view, int position);
}
