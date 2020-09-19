package com.liceoatarraya.app;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class configuraciones extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}