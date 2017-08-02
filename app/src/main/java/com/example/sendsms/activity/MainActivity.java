package com.example.sendsms.activity;

import android.support.annotation.IdRes;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.sendsms.R;
import com.example.sendsms.adapter.SwipeAdapter;
import com.example.sendsms.model.ValueDetails;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private RadioGroup rgMain;
    private RadioButton rbContacts, rbMessages;

    ValueDetails valueDetails;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        onClick();
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdapter);
        Bundle bundle = getIntent().getExtras();


    }

    /**
     *
     */
    private void onClick() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final RadioGroup group, @IdRes final int checkedId) {
                if (checkedId == R.id.rbContacts) {
                    viewPager.setCurrentItem(0);
                }
                if (checkedId == R.id.rbMessages) {
                    viewPager.setCurrentItem(1);
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                if (position == 0) {
                    rbContacts.setChecked(true);
                }
                if (position == 1) {
                    rbMessages.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });
    }

    /**
     *
     */
    private void init() {
        viewPager = (ViewPager) findViewById(R.id.pager);
        rgMain = (RadioGroup) findViewById(R.id.rgMain);
        rbContacts = (RadioButton) findViewById(R.id.rbContacts);
        rbMessages = (RadioButton) findViewById(R.id.rbMessages);

    }


    public void setdata(ValueDetails valueDetails)

    {
        this.valueDetails = valueDetails;
    }

    public ValueDetails getdata() {
        return valueDetails;
    }
}
