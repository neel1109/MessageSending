package com.example.sendsms.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.sendsms.fragment.Contacts;
import com.example.sendsms.fragment.Messages;

/**
 * Created by neel on 16/7/17.
 */

public class SwipeAdapter extends FragmentStatePagerAdapter {

    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:

                return new Contacts();
            case 1:

                return new Messages();

        }


        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
