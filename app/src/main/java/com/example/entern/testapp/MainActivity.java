package com.example.entern.testapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    PersonInfo personInfo;
    Contact contact;
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ImageView mProfile_Picture;
    EditText mFast_Name,
            mLast_Name,
            mFather_Name,
            mMather_name,
            mBarth_Of_Date,
            mGender,
            mBank_Account,
            mAge,
            mMobil_Number,
            mEmail,
            mAddress,
            mPermanent_Address;
            Bitmap photo;

    TextView mmessageEditText;
    Button mSave_Button;



    static final int REQUEST_IMAGE_CAPTURE = 1;
 ArrayList<PersonInfo> personInfoItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mmessageEditText=findViewById(R.id.tv_Message);

        Initialization_EditText();

        mSave_Button.setOnClickListener(this);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");
            mProfile_Picture.setImageBitmap(photo);
        }
    }

    @Override
    public void onClick(View view) {
            personInfoItem = new ArrayList<>();
            try {
                Initialization_PersonInfo_Contact_Field();


                Intent sendIntent=new Intent(MainActivity.this,TowActivity.class);
                 sendIntent.putParcelableArrayListExtra("Message",  personInfoItem);
                startActivity(sendIntent);

            }catch (Exception e){
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }finally
            {
                Check_All_Edit_Text();
            }




    }
    public void captureImage(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }
    private void Initialization_EditText(){
        mProfile_Picture=findViewById(R.id.iv_profile_picture);

        mFast_Name=findViewById(R.id.et_fast_name);
        mLast_Name=findViewById(R.id.et_last_name);
        mFather_Name=findViewById(R.id.et_father_name);
        mMather_name=findViewById(R.id.et_mather_name);
        mBarth_Of_Date=findViewById(R.id.et_barth_of_date);
        mGender=findViewById(R.id.et_gender);
        mBank_Account=findViewById(R.id.et_bank_account);
        mAge=findViewById(R.id.et_age);
        mMobil_Number=findViewById(R.id.et_mobile_number);
        mEmail=findViewById(R.id.et_email);
        mAddress=findViewById(R.id.et_address);
        mPermanent_Address=findViewById(R.id.et_permanent_address);
        mSave_Button=findViewById(R.id.bt_save);
    }
    private void Initialization_PersonInfo_Contact_Field(){

        contact=new Contact();
        contact.setMobile_Number(Integer.parseInt(mMobil_Number.getText().toString()));
        contact.setEmail(mEmail.getText().toString());
        contact.setAddress(mAddress.getText().toString());
        contact.setPermanent_Address(mPermanent_Address.getText().toString());

        personInfo =new PersonInfo();
        personInfo.setProfileImage(photo);
        personInfo.setFast_Name(mFast_Name.getText().toString());
        personInfo.setLast_Name(mLast_Name.getText().toString());
        personInfo.setFather_Name(mFather_Name.getText().toString());
        personInfo.setMather_name(mMather_name.getText().toString());
        personInfo.setBarth_Of_Date(mBarth_Of_Date.getText().toString());
        personInfo.setBank_Account(mBank_Account.getText().toString());
        personInfo.setGender(mGender.getText().toString());
        personInfo.setAge(Integer.parseInt(mAge.getText().toString()));
        personInfo.setContact(contact);
        personInfoItem.add(personInfo);
    }
    private void Check_All_Edit_Text(){

        if(mFast_Name.getText().toString().equals("")){
            String Message="Fast Name is Empty";
            Toast.makeText(getApplicationContext(),Message,Toast.LENGTH_LONG).show();
        }
       else if(mLast_Name.getText().toString().equals("")){
           String Message="Last Name is Empty";
           Toast.makeText(getApplicationContext(),Message,Toast.LENGTH_LONG).show();
       }
       else if(mFather_Name.getText().toString().equals("")){
           String Message="Father Name is Empty";
           Toast.makeText(getApplicationContext(),Message,Toast.LENGTH_LONG).show();
       }
       else if(mMather_name.getText().toString().equals("")){
           String Message="Mather Name is Empty";
           Toast.makeText(getApplicationContext(),Message,Toast.LENGTH_LONG).show();
       }
       else if(mBarth_Of_Date.getText().toString().equals("")){
           String Message="Barth Of Date is Empty";
           Toast.makeText(getApplicationContext(),Message,Toast.LENGTH_LONG).show();
       }
       else if(mAge.getText().toString().equals("")){
           String Message="Age is Empty";
           Toast.makeText(getApplicationContext(),Message,Toast.LENGTH_LONG).show();
       }
       else if(mEmail.getText().toString().equals("")){
           String Message="Email is Empty";
           Toast.makeText(getApplicationContext(),Message,Toast.LENGTH_LONG).show();
       }
       else if(mAddress.getText().toString().equals("")){
           String Message="Address is Empty";
           Toast.makeText(getApplicationContext(),Message,Toast.LENGTH_LONG).show();
       }
       else if(mMobil_Number.getText().toString().equals("")){
           String Message="Mobil Number is Empty";
           Toast.makeText(getApplicationContext(),Message,Toast.LENGTH_LONG).show();
       }
       else if(mPermanent_Address.getText().toString().equals("")){
           String Message="Permanent Address is Empty";
           Toast.makeText(getApplicationContext(),Message,Toast.LENGTH_LONG).show();
       }
       else {

           String Message="S";
           Toast.makeText(getApplicationContext(),Message,Toast.LENGTH_LONG).show();
       }


   }

}
