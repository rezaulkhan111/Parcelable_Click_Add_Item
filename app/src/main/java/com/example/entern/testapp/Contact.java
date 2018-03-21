package com.example.entern.testapp;


import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;

import java.io.Serializable;

public class Contact implements Parcelable {
    private int Mobile_Number;
    private String Email;
    private String Address;
    private String Permanent_Address;

    protected Contact(){

    }
    protected Contact(Parcel in) {
        Mobile_Number = in.readInt();
        Email = in.readString();
        Address = in.readString();
        Permanent_Address = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public int getMobile_Number() {
        return Mobile_Number;
    }

    public void setMobile_Number(int mobile_Number) {
        Mobile_Number = mobile_Number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPermanent_Address() {
        return Permanent_Address;
    }

    public void setPermanent_Address(String permanent_Address) {
        Permanent_Address = permanent_Address;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Mobile_Number);
        dest.writeString(Email);
        dest.writeString(Address);
        dest.writeString(Permanent_Address);
    }
}
