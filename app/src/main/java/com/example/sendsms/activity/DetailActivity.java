package com.example.sendsms.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sendsms.R;
import com.example.sendsms.fragment.Messages;
import com.example.sendsms.model.ContactDetails;
import com.example.sendsms.model.MessageDetails;

import static java.security.AccessController.getContext;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvFirstName, tvLastName, tvPhoneNumber;
    private String lastName, firstName, phoneNumber;
    private Button btnSendMessage;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                Bundle bundle = data.getExtras();
                if (bundle != null) {

                    MessageDetails messageDetails = bundle.getParcelable("message");

                    Bundle bundle1 = new Bundle();
                    bundle1.putParcelable("message", messageDetails);
                    Intent i = new Intent();
                    i.putExtras(bundle1);

                    setResult(Activity.RESULT_OK, i);
                    finish();
//
                    // bundle.putString("edttext", "From Activity");


                } else {
                    Toast.makeText(this, "null Bundle", Toast.LENGTH_LONG).show();
                }

            }
        }
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        init();
        Bundle bundle = getIntent().getExtras();
        ContactDetails contactDetails = bundle.getParcelable("contact");

        firstName = contactDetails.getFirstName().toString();

        lastName = contactDetails.getLastName().toString();

        phoneNumber = contactDetails.getPhoneNumber();

        tvFirstName.setText(firstName);
        tvLastName.setText(lastName);
        tvPhoneNumber.setText(phoneNumber);
        btnSendMessage.setOnClickListener(this);
    }

    private void init() {
        tvFirstName = (TextView) findViewById(R.id.tvFirtName);
        tvLastName = (TextView) findViewById(R.id.tvLastName);
        tvPhoneNumber = (TextView) findViewById(R.id.tvPhoneNumber);
        btnSendMessage = (Button) findViewById(R.id.btnSendMessage);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MessageActivity.class);
        intent.putExtra("name", firstName + lastName);
        startActivityForResult(intent, 1);
    }
}

