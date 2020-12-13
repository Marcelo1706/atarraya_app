package com.liceoatarraya.app.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.liceoatarraya.app.ChatActivity;
import com.liceoatarraya.app.R;
import com.liceoatarraya.app.adapters.MessageAdapter;
import com.liceoatarraya.app.adapters.NotificationAdapter;
import com.liceoatarraya.app.models.MessageSingleton;
import com.liceoatarraya.app.models.NotificationSingleton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mensajes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mensajes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ListView messageList;
    MessageAdapter messageAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public mensajes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mensajes.
     */
    // TODO: Rename and change types and number of parameters
    public static mensajes newInstance(String param1, String param2) {
        mensajes fragment = new mensajes();
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
        View view = inflater.inflate(R.layout.fragment_mensajes, container, false);
        messageList = view.findViewById(R.id.messageList);
        MessageSingleton data = MessageSingleton.getInstance();
        messageAdapter = new MessageAdapter(getActivity(), data.getMessages());
        messageList.setAdapter(messageAdapter);
        messageList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), ChatActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}