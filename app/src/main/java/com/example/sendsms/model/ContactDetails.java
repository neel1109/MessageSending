package com.example.sendsms.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by neel on 17/7/17.
 */

public class ContactDetails implements Parcelable{
    private String firstName, lastName,phoneNumber;


    public ContactDetails() {

    }

//    public ContactDetails(String firstName, String lastName, double phoneNumber) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phoneNumber = phoneNumber;
//    }

    public void Details(String firstName, String lastName, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    public ContactDetails(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        phoneNumber = in.readString();
    }

    public static final Creator<ContactDetails> CREATOR = new Creator<ContactDetails>() {
        @Override
        public ContactDetails createFromParcel(Parcel in) {
            return new ContactDetails(in);
        }

        @Override
        public ContactDetails[] newArray(int size) {
            return new ContactDetails[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(phoneNumber);
    }
}
