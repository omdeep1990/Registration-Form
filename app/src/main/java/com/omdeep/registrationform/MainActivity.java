package com.omdeep.registrationform;

import androidx.annotation.NonNull;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.omdeep.registrationform.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends BaseActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnReset.setVisibility(View.INVISIBLE);

        //TODO: Initialization of Validation Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //TODO: Add validation for First Name
        awesomeValidation.addValidation(this, R.id.et_fname, RegexTemplate.NOT_EMPTY, R.string.invalid_name);

        //TODO: Add validation for Last Name
        awesomeValidation.addValidation(this, R.id.et_lname, RegexTemplate.NOT_EMPTY, R.string.invalid_name);

        //TODO: Validation for mobile number
        awesomeValidation.addValidation(this, R.id.et_number, "[5-9]{1}[0-9]{9}", R.string.invalid_number);

        //TODO: Validation for Email Id
        awesomeValidation.addValidation(this, R.id.et_email, Patterns.EMAIL_ADDRESS, R.string.invalid_Address);

        binding.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnReset.setVisibility(View.INVISIBLE);
                binding.btnSubmit.setVisibility(View.VISIBLE);
                binding.etFname.setText(null);
                binding.etLname.setText(null);
                binding.etNumber.setText(null);
                binding.etEmail.setText(null);
                binding.rbGroup.clearCheck();
                binding.cbItem1.setChecked(false);
                binding.cbItem2.setChecked(false);
                binding.cbItem3.setChecked(false);
                binding.cbItem4.setChecked(false);
                binding.cbItem5.setChecked(false);
                binding.cbItem6.setChecked(false);
                binding.cbItem7.setChecked(false);
                binding.cbItem8.setChecked(false);
                binding.cbItem9.setChecked(false);
            }
        });
        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
                int id = view.getId();
                switch (view.getId()) {
                    case R.id.btn_submit:
                        binding.btnSubmit.setVisibility(View.GONE);
                        binding.btnReset.setVisibility(View.VISIBLE);

                        //TODO: Check Validation
                        if (awesomeValidation.validate()) {

                            //TODO: On Success
                            Toast.makeText(getApplicationContext(), "Form submitted Successfully....", Toast.LENGTH_SHORT).show();
                        } else {
                            binding.btnSubmit.setVisibility(View.VISIBLE);
                            binding.btnReset.setVisibility(View.INVISIBLE);
                            Toast.makeText(getApplicationContext(), "Please check the details carefully", Toast.LENGTH_SHORT).show();
                        }
                        if(binding.rbGroup.getCheckedRadioButtonId()==-1){
                            binding.btnReset.setVisibility(View.INVISIBLE);
                            binding.btnSubmit.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Please select your gender", Toast.LENGTH_SHORT).show();
                            return;}
                        break;
                }
            }

            private void sendData() {
                String name1 = binding.etFname.getText().toString().toUpperCase(Locale.ROOT).trim();
                String name2 = binding.etLname.getText().toString().toUpperCase(Locale.ROOT).trim();
                String mobile = binding.etNumber.getText().toString().trim();
                String email = binding.etEmail.getText().toString().trim();
               // String gender = binding.rbGroup.getTransitionName().trim();


                Intent intent = new Intent(MainActivity.this, RegisteredData.class);

                intent.putExtra(RegisteredData.Name1, name1);
                intent.putExtra(RegisteredData.Name2, name2);
                intent.putExtra(RegisteredData.Mobile, mobile);
                intent.putExtra(RegisteredData.Email, email);
                //intent.putExtra(RegisteredData.Gender, gender);


                startActivity(intent);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }


    @Override
    public void onBackPressed() {
        myAlert(MainActivity.this);
    }

    private void myAlert(Context mContext) {
        new AlertDialog.Builder(mContext)
                .setIcon(R.drawable.ic_exit)
                .setTitle("Exit?")
                .setMessage("Do you want to exit my app?")
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);
                    }
                })
                .setNegativeButton("Cancel",null)
                .show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Registration selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Courses selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem1:
                Toast.makeText(this, "Android Studio selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem2:
                Toast.makeText(this, "Java selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem3:
                Toast.makeText(this, "Python selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem4:
                Toast.makeText(this, "Kotlin selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem5:
                Toast.makeText(this, "JavaScript selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "About Us selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                Toast.makeText(this, "BMI selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item5:
                Toast.makeText(this, "Exit selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
