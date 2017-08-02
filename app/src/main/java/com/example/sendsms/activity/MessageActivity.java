package com.example.sendsms.activity;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sendsms.R;
import com.example.sendsms.fragment.Messages;
import com.example.sendsms.model.MessageDetails;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.Date;
import java.util.Random;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvMessage, tvOtp;
    private String name;
    int random;
    private Button btnSendMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        init();
        name = getIntent().getStringExtra("name");
        Random r = new Random();
        random = r.nextInt(999999 - 100000 + 1) + 100000;
        tvOtp.setText("" + random);


        btnSendMessage.setOnClickListener(this);

    }

    private void init() {

        tvMessage = (TextView) findViewById(R.id.tvMessage);
        tvOtp = (TextView) findViewById(R.id.tvOtp);
        btnSendMessage = (Button) findViewById(R.id.btnSendMessage);
    }


    @Override
    public void onClick(View v) {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        dateFormatter.setLenient(false);
        Date today = new Date();
        String s = dateFormatter.format(today);
        sendSMS("+919971792703", tvMessage.getText().toString() + tvOtp.getText().toString(), s, name);
    }

    private void sendSMS(String phonenumber, String message, String dateandtime, String name) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phonenumber, null, message, null, null);


        MessageDetails messageDetails = new MessageDetails();
        messageDetails.setName(name);
        messageDetails.setTime(dateandtime);
        messageDetails.setOtp(message);
        Bundle bundle = new Bundle();
        bundle.putParcelable("message", messageDetails);
        Intent intent = new Intent();
        intent.putExtras(bundle);

        setResult(Activity.RESULT_OK, intent);
        finish();
        Toast.makeText(this, "Message is sent" , Toast.LENGTH_LONG).show();
    }
}
