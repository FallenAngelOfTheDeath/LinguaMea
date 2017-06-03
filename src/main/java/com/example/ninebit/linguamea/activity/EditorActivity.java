package com.example.ninebit.linguamea.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.ninebit.linguamea.R;
import com.example.ninebit.linguamea.fragment.EditorFragment;

import java.util.UUID;


public class EditorActivity extends AppCompatActivity {

    public static final String EXTRA_LINMEA_ID = "com.example.ninebit.linguamea.linmea_id";
    public static final String EXTRA_EDITOR_ID = "com.example.ninebit.linguamea.editor_id";

    private Toolbar toolbar;

    public static Intent newIntent (Context packageContext, UUID linmeaID, Boolean editModID){
        Intent intent = new Intent(packageContext, EditorActivity.class);
        intent.putExtra(EXTRA_LINMEA_ID, linmeaID);
        intent.putExtra(EXTRA_EDITOR_ID, editModID);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        setGUI();

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.flContent);
        if (fragment == null) {
            fragment = new EditorFragment();
            fm.beginTransaction().add(R.id.flContent, fragment).commit();
        }

    }


    public void setGUI (){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
