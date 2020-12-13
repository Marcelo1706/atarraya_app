package com.liceoatarraya.app.fragments;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.liceoatarraya.app.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}