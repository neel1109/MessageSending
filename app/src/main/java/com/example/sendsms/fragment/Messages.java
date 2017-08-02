package com.example.sendsms.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sendsms.R;
import com.example.sendsms.activity.MainActivity;
import com.example.sendsms.adapter.MessageRecyclerAdapter;
import com.example.sendsms.model.MessageDetails;
import com.example.sendsms.model.ValueDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neel on 16/7/17.
 */

public class Messages extends Fragment {
    private RecyclerView idRecycler;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private List<MessageDetails> messages = new ArrayList<>();
    private String name, time, otp;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_messages, container, false);
        init(v);

        adapter = new MessageRecyclerAdapter(this, messages);

        layoutManager = new LinearLayoutManager(getContext());
        idRecycler.setLayoutManager(layoutManager);
        idRecycler.setHasFixedSize(true);
        idRecycler.setAdapter(adapter);
//        name = ((MainActivity) getActivity()).getdata().getName();
//        otp = ((MainActivity) getActivity()).getdata().getOtp();
//        time = ((MainActivity) getActivity()).getdata().getTime();

        MessageDetails messageDetails = new MessageDetails();
        messageDetails.Details(name, otp, time);
        messages.add(messageDetails);
        adapter.notifyDataSetChanged();
        return v;


    }


    private void init(View v) {
        idRecycler = (RecyclerView) v.findViewById(R.id.idRecycler);

    }


}