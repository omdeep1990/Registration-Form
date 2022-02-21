package com.omdeep.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;

public class BaseActivity extends AppCompatActivity {

    //Data of RegisteredData.java
    public static final String Name1 = "FIRST NAME";
    public static final String Name2 = "LAST NAME";
    public static final String Mobile = "MOBILE NUMBER";
    public static final String Email = "EMAIL ID";
    public static final String Gender = "GENDER";

//    private TextView etFname1, etLname2, etNumber3, etEmail4;
//    private String nm1, nm2, mn, eml, mal, femal;

    //Data of MainActivity.java including 30th line
    AwesomeValidation awesomeValidation;
    Context context;
    private String gender = "", cbItemsText = "", name1, name2, mobile, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        context = this;
    }

    public void showShortToast(String msg){
        Toast.makeText(context,  msg, Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

//    public void showCustomToast(int resourceId, String msg){
////        View view = getLayoutInflater().inflate(R.layout.layout_custom_toast, findViewById(R.id.relative_layout));
////        TextView textView = view.findViewById(R.id.tv_msg);
////        ImageView imageView = view.findViewById(R.id.image_view);
////        textView.setText(msg);
////        imageView.setImageResource(resourceId);
//
//        Toast toast = new Toast(context);
//        toast.setGravity(Gravity.BOTTOM, 0, 0);
//        toast.setDuration(Toast.LENGTH_LONG);
//        toast.setView(view);
//        toast.show();
//
//    }
}