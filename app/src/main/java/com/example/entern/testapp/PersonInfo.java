package com.example.entern.testapp;



import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.File;
import java.io.Serializable;

public class PersonInfo implements Parcelable{
    private String Fast_Name;
    private String Last_Name;
    private String Father_Name;
    private String Mather_name;
    private String Barth_Of_Date;
    private int Age;
    private String Gender;
    private Contact Contact;
    private String Bank_Account;
    private Bitmap profileImage;

    protected PersonInfo(){

    }


    protected PersonInfo(Parcel in) {
        Fast_Name = in.readString();
        Last_Name = in.readString();
        Father_Name = in.readString();
        Mather_name = in.readString();
        Contact = in.readParcelable(com.example.entern.testapp.Contact.class.getClassLoader());
        Barth_Of_Date = in.readString();
        Age = in.readInt();
        Gender = in.readString();
        Bank_Account = in.readString();
        profileImage = in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Creator<PersonInfo> CREATOR = new Creator<PersonInfo>() {
        @Override
        public PersonInfo createFromParcel(Parcel in) {
            return new PersonInfo(in);
        }

        @Override
        public PersonInfo[] newArray(int size) {
            return new PersonInfo[size];
        }
    };

    public String getFast_Name() {
        return Fast_Name;
    }

    public void setFast_Name(String fast_Name) {
        Fast_Name = fast_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getFather_Name() {
        return Father_Name;
    }

    public void setFather_Name(String father_Name) {
        Father_Name = father_Name;
    }

    public String getMather_name() {
        return Mather_name;
    }

    public void setMather_name(String mather_name) {
        Mather_name = mather_name;
    }

    public String getBarth_Of_Date() {
        return Barth_Of_Date;
    }

    public void setBarth_Of_Date(String barth_Of_Date) {
        Barth_Of_Date = barth_Of_Date;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getBank_Account() {
        return Bank_Account;
    }

    public void setBank_Account(String bank_Account) {
        Bank_Account = bank_Account;
    }

    public com.example.entern.testapp.Contact getContact() {
        return Contact;
    }

    public void setContact(com.example.entern.testapp.Contact contact) {
        Contact = contact;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getAge() {
        return Age;
    }

    public Bitmap getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Bitmap profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Fast_Name);
        parcel.writeString(Last_Name);
        parcel.writeString(Father_Name);
        parcel.writeString(Mather_name);
        parcel.writeParcelable(Contact,i);
        parcel.writeString(Barth_Of_Date);
        parcel.writeInt(Age);
        parcel.writeString(Gender);
        parcel.writeString(Bank_Account);
        parcel.writeParcelable(profileImage, i);
    }
}
