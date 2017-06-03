package com.example.ninebit.linguamea.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ninebit.linguamea.R;
import com.example.ninebit.linguamea.fragment.preference.CustomDictionaryPreferenceFragment;

public class PreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_settings);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.prefs_content, new CustomDictionaryPreferenceFragment())
                .commit();
    }
}
