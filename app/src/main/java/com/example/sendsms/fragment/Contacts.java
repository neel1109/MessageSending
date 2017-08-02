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
import com.example.sendsms.adapter.RecyclerAdapter;
import com.example.sendsms.model.ContactDetails;
import com.example.sendsms.model.MessageDetails;
import com.example.sendsms.model.ValueDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neel on 16/7/17.
 */

public class Contacts extends Fragment {
    private RecyclerView idRecycler;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private String name, time, otp;
    private List<ContactDetails> contacts = new ArrayList<>();
    private String strJson = "{ \"Contacts\" :[{\"firstName\":\"Neel\",\"lastName\":\"Vyas\",\"phoneNumber\":\"56477382387\"}," +
            "{\"firstName\":\"neil\",\"lastName\":\"Jaiswal\",\"phoneNumber\":\"6748443\"}," +
            "{\"firstName\":\"dfd\",\"lastName\":\"Vytrghgh\",\"phoneNumber\":\"5455353\"}," +
            "{\"firstName\":\"fdghh\",\"lastName\":\"Vyetrr\",\"phoneNumber\":\"54534540\"}," +
            "{\"firstName\":\"Nhjrt\",\"lastName\":\"jmjhk\",\"phoneNumber\":\"54543345\"}," +
            "{\"firstName\":\"sdsad\",\"lastName\":\"qewer\",\"phoneNumber\":\"543453460\"}," +
            "{\"firstName\":\"mjhkhk\",\"lastName\":\"ghghfg\",\"phoneNumber\":\"9669869858\"}," +
            "{\"firstName\":\"werwe\",\"lastName\":\"ytytr\",\"phoneNumber\":\"0389484584\"}," +
            "{\"firstName\":\"uyiuad\",\"lastName\":\"rtthg\",\"phoneNumber\":\"545865689475\"}] }";

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                Bundle bundle = data.getExtras();
                if (bundle != null) {
                    MessageDetails messageDetails = bundle.getParcelable("message");
                    name = messageDetails.getName();
                    otp = messageDetails.getOtp();
                    time = messageDetails.getTime();
                    ValueDetails valueDetails = new ValueDetails();
                    valueDetails.setName(name);
                    valueDetails.setOtp(otp);
                    valueDetails.setTime(time);
                    ((MainActivity) getActivity()).setdata(valueDetails);
                    Toast.makeText(getContext(), name + otp + time, Toast.LENGTH_LONG).show();

                }
            }
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contacts, container, false);
        init(v);

        adapter = new RecyclerAdapter(this, contacts);
        layoutManager = new LinearLayoutManager(getContext());
        idRecycler.setLayoutManager(layoutManager);
        idRecycler.setHasFixedSize(true);
        idRecycler.setAdapter(adapter);
        putdata();

        return v;
    }

    private void putdata() {

        try {

            JSONObject jsonRootObject = new JSONObject(strJson);


            JSONArray jsonArray = jsonRootObject.optJSONArray("Contacts");


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String firstName = jsonObject.optString("firstName").toString();
                String lastName = jsonObject.optString("lastName").toString();
                String phoneNumber = jsonObject.optString("phoneNumber").toString();
                ContactDetails contactDetails = new ContactDetails();
                contactDetails.Details(firstName, lastName, phoneNumber);
                contacts.add(contactDetails);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void init(View v) {
        idRecycler = (RecyclerView) v.findViewById(R.id.idRecycler);
    }


}
