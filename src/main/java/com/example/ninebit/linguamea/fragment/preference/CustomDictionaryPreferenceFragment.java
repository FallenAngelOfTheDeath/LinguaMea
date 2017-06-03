package com.example.ninebit.linguamea.fragment.preference;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.example.ninebit.linguamea.R;
import com.takisoft.fix.support.v7.preference.PreferenceFragmentCompat;

public class CustomDictionaryPreferenceFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferencesFix(@Nullable Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.custom_dictionary_preference);
    }
}
