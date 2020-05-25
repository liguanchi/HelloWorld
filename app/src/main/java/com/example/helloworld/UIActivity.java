package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class UIActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, RatingBar.OnRatingBarChangeListener {
    private TextView mTextView;
    private Button mButtonLeft, mButtonRight, mButtonOk;
    private Switch mSwitch;
    private ProgressBar mProgressBar;
    private EditText mEditTextNumber;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButtonAndroid, mRadioButtonApple, mRadioButtonAli;
    private ImageView mImageView;
    private SeekBar mSeekBar;
    private CheckBox mCheckBoxAndroid, mCheckBoxBoxJava, mCheckBoxSQL;
    private RatingBar mRatingBar;
    private String android = "", java = "", sql = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_i);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉Activity上面的状态栏
        mTextView = findViewById(R.id.text_view);
        mButtonLeft = findViewById(R.id.button_left);
        mButtonRight = findViewById(R.id.button_rigth);
        mButtonOk = findViewById(R.id.button_ok);
        mSwitch = findViewById(R.id.button_switch);
        mProgressBar = findViewById(R.id.progress_bar);
        mEditTextNumber = findViewById(R.id.edit_number);
        mRadioGroup = findViewById(R.id.radio_group);
        mRadioButtonAndroid = findViewById(R.id.radio_android);
        mRadioButtonApple = findViewById(R.id.radio_apple);
        mRadioButtonAli = findViewById(R.id.radio_ali);
        mImageView = findViewById(R.id.image_view);
        mSeekBar = findViewById(R.id.seek_bar);
        mCheckBoxAndroid = findViewById(R.id.check_android);
        mCheckBoxBoxJava = findViewById(R.id.check_java);
        mCheckBoxSQL = findViewById(R.id.check_sql);
        mRatingBar = findViewById(R.id.rating_bar);

        mButtonLeft.setOnClickListener(this);
        mButtonRight.setOnClickListener(this);
        mButtonOk.setOnClickListener(this);
        mSwitch.setOnCheckedChangeListener(this);
        mRadioGroup.setOnCheckedChangeListener(this);
        mSeekBar.setOnSeekBarChangeListener(this);
        mCheckBoxAndroid.setOnCheckedChangeListener(this);
        mCheckBoxBoxJava.setOnCheckedChangeListener(this);
        mCheckBoxSQL.setOnCheckedChangeListener(this);
        mRatingBar.setOnRatingBarChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_left:
                mTextView.setText(R.string.button_left);
                break;
            case R.id.button_rigth:
                mTextView.setText(R.string.button_right);
                break;
            case R.id.button_ok:
//                String s = mEditTextNumber.getText().toString();
//                int a = Integer.parseInt(s);
//                mProgressBar.setProgress(a);
                String a = mEditTextNumber.getText().toString();
                if (a.equals("")) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.please), Toast.LENGTH_LONG).show();
                } else {
                    int temp;
                    try {
                        temp = Integer.parseInt(a);//转换为整数数字
                    } catch (NumberFormatException e) {
                        temp = 100;
                    }
                    mProgressBar.setProgress(temp);//设置进度
                    mSeekBar.setProgress(temp);
                    mTextView.setText(a);
                    if (temp <= 30) {
                        mRadioButtonAndroid.setChecked(true);
                    } else if (temp <= 60) {
                        mRadioButtonApple.setChecked(true);
                    } else {
                        mRadioButtonAli.setChecked(true);
                    }
                    break;
                }
            default:
                break;


        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()) {
            case R.id.button_switch:
                mTextView.setText(isChecked ? getResources().getString(R.string.open) : getResources().getString(R.string.close));
                break;
            case R.id.check_android:
                if (isChecked) {
                    android = getResources().getString(R.string.radio_android);
                } else {
                    android = "";
                }
                mTextView.setText(android + java + sql);
                break;
            case R.id.check_java:
                if (isChecked) {
                    java = getResources().getString(R.string.java);
                } else {
                    java = "";
                }
                mTextView.setText(android + java + sql);
                break;
            case R.id.check_sql:
                if (isChecked) {
                    sql = getResources().getString(R.string.sql);
                } else {
                    sql = "";
                }
                mTextView.setText(android + java + sql);
                break;

        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radio_android:
                mImageView.setImageResource(R.drawable.android);
                break;
            case R.id.radio_apple:
                mImageView.setImageResource(R.drawable.apple);
                break;
            case R.id.radio_ali:
                mImageView.setImageResource(R.drawable.ia_100000018);
                break;
            default:
                break;
        }


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //当进度发生变化时调用
        mTextView.setText(String.valueOf(progress));
        mEditTextNumber.setText(String.valueOf(progress));
        mProgressBar.setProgress(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

        Toast.makeText(getApplicationContext(), rating + getResources().getString(R.string.evaluate), Toast.LENGTH_LONG).show();
    }
}