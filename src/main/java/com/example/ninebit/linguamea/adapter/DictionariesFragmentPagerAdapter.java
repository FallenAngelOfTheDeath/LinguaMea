package com.example.ninebit.linguamea.adapter;

/////////////////////////////////////////OLD_DO_NOT_USING/////////////////////////////
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.ninebit.linguamea.fragment.dictionaries.OIDictionaryFragment;
import com.example.ninebit.linguamea.fragment.dictionaries.MainDictionaryFragment;
import com.example.ninebit.linguamea.fragment.dictionaries.CustomDictionaryFragment;

public class DictionariesFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] { "MAIN", "CUSTOM", "OI" };
    private Context context;

    public DictionariesFragmentPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int arg0) {
        Bundle data = new Bundle();
        switch(arg0){
            /** tab1 is selected */
            case 0:
                MainDictionaryFragment mainDictionaryFragment = new MainDictionaryFragment();
                return mainDictionaryFragment;
            /** tab2 is selected */
            case 1:
                OIDictionaryFragment OIDictionaryFragment = new OIDictionaryFragment();
                return OIDictionaryFragment;
            /** tab3 is selected */
            case 2:
                CustomDictionaryFragment customDictionaryFragment = new CustomDictionaryFragment();
                return customDictionaryFragment;
        }
        return null;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
