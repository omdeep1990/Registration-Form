package com.omdeep.registrationform;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisteredData extends BaseActivity {
//    public static final String Name1 = "FIRST NAME";
//    public static final String Name2 = "LAST NAME";
//    public static final String Mobile = "MOBILE NUMBER";
//    public static final String Email = "EMAIL ID";
//    public static final String Gender = "GENDER";

    private TextView etFname1, etLname2, etNumber3, etEmail4,etGender;
    private String nm1, nm2, mn, eml, mal, femal, gndr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_data);

        etFname1 = findViewById(R.id.name12);

        etNumber3 = findViewById(R.id.mobile1);
        etEmail4 = findViewById(R.id.email);
        //etGender = findViewById(R.id.gender);


        Intent intent = getIntent();
        nm1 = intent.getStringExtra(Name1);
        nm2 = intent.getStringExtra(Name2);
        mn = intent.getStringExtra(Mobile);
        eml = intent.getStringExtra(Email);
        //gndr = intent.getStringExtra(Gender);


        etFname1.setText("Name: " +nm1 + " "+nm2);
        etNumber3.setText("Mobile No.: " +mn);
        etEmail4.setText("Email Id: "+eml);
        //etGender.setText("Gender: "+gndr);



}}