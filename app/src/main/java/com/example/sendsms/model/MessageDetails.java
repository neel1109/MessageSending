package com.example.sendsms.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by neel on 18/7/17.
 */

public class MessageDetails implements Parcelable {
    private String name, time, otp;

    public MessageDetails() {
    }

    public void Details(String name, String time, String otp) {
        this.name = name;
        this.time = time;
        this.otp = otp;
    }

    public MessageDetails(Parcel in) {
        name = in.readString();
        time = in.readString();
        otp = in.readString();
    }

    public static final Creator<MessageDetails> CREATOR = new Creator<MessageDetails>() {
        @Override
        public MessageDetails createFromParcel(Parcel in) {
            return new MessageDetails(in);
        }

        @Override
        public MessageDetails[] newArray(int size) {
            return new MessageDetails[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(time);
        dest.writeString(otp);
    }
}
