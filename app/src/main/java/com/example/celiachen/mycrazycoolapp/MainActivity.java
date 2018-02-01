package com.example.celiachen.mycrazycoolapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // variables
    // hold information retrieved from the activities

    private Context mContext; // context of the activity
    private Activity mActivity;
    private ConstraintLayout mConstraintLayout; // layout of our main activity
    // views from the activity?
    // button
    // editText
    // textView
    private Button mButton;
    private EditText mEditText;
    private TextView mTextView;
    // popup window
    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. get the app context
        mContext = getApplicationContext();

        // 2. get the activity
        mActivity = MainActivity.this;

        // 3. get the widgets reference from your xml layout
        mConstraintLayout = (ConstraintLayout) findViewById(R.id.cl);
        mButton = findViewById(R.id.button);
        mTextView = (TextView) findViewById(R.id.textView);
        mEditText = (EditText)findViewById(R.id.editText);

        // set a click listener for the button
        // 1. change textview
        // 2. popup window

        mButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                // change textview
                mTextView.setText(mEditText.getText() + ", welcome back!");

                // popup window
                // initialize a new instance of layoutinflater service
                LayoutInflater inflater = (LayoutInflater)mContext
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                // inflate the layout - popup_layout
                View customView = inflater.inflate(R.layout.popup_layout, null);

                // create a popup window
                // View, width, height
                mPopupWindow = new PopupWindow(customView,
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
                // set an evaluation value for popup calls because it requires API 21
                if (Build.VERSION.SDK_INT >= 21){ // how you check API level
                    mPopupWindow.setElevation(0.5f);
                }
                // get a reference for the close button
                ImageButton closeButton = customView.findViewById(R.id.imageButton);
                // on click listener for close button

                closeButton.setOnClickListener( new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        // close the view
                        mPopupWindow.dismiss();
                    }

                });

                // find a location to display the popup window
                // center of the screen

                mPopupWindow.showAtLocation(mConstraintLayout, Gravity.CENTER, 0, 0);
            }

        });




    }
}
