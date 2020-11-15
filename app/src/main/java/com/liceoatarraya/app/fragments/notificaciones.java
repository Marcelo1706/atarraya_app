package com.liceoatarraya.app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.liceoatarraya.app.R;
import com.liceoatarraya.app.adapters.NotificationAdapter;
import com.liceoatarraya.app.models.NotificationSingleton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link notificaciones#newInstance} factory method to
 * create an instance of this fragment.
 */
public class notificaciones extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ListView notificationList;
    NotificationAdapter notificationAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public notificaciones() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment notificaciones.
     */
    // TODO: Rename and change types and number of parameters
    public static notificaciones newInstance(String param1, String param2) {
        notificaciones fragment = new notificaciones();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notificaciones, container, false);
        notificationList = view.findViewById(R.id.notificationList);
        NotificationSingleton data = NotificationSingleton.getInstance();
        notificationAdapter = new NotificationAdapter(getActivity(), data.getNotifications());
        notificationList.setAdapter(notificationAdapter);
        return view;
    }


}