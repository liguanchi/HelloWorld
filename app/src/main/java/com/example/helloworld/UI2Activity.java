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

import com.example.helloworld.databinding.ActivityUI2Binding;

public class UI2Activity extends AppCompatActivity {
    private ActivityUI2Binding mBinding;
//    private TextView mTextView;
//    private Button mButtonLeft, mButtonRight, mButtonOk;
//    private Switch mSwitch;
//    private ProgressBar mProgressBar;
//    private EditText mEditTextNumber;
//    private RadioGroup mRadioGroup;
//    private RadioButton mRadioButtonAndroid, mRadioButtonApple, mRadioButtonAli;
//    private ImageView mImageView;
//    private SeekBar mSeekBar;
//    private CheckBox mCheckBoxAndroid, mCheckBoxBoxJava, mCheckBoxSQL;
//    private RatingBar mRatingBar;
    private String android = "", java = "", sql = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityUI2Binding.inflate(getLayoutInflater());

        setContentView(mBinding.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉Activity上面的状态栏

//        mTextView = findViewById(R.id.text_view);
//        mButtonLeft = findViewById(R.id.button_left);
//        mButtonRight = findViewById(R.id.button_rigth);
//        mButtonOk = findViewById(R.id.button_ok);
//        mSwitch = findViewById(R.id.button_switch);
//        mProgressBar = findViewById(R.id.progress_bar);
//        mEditTextNumber = findViewById(R.id.edit_number);
//        mRadioGroup = findViewById(R.id.radio_group);
//        mRadioButtonAndroid = findViewById(R.id.radio_android);
//        mRadioButtonApple = findViewById(R.id.radio_apple);
//        mRadioButtonAli = findViewById(R.id.radio_ali);
//        mImageView = findViewById(R.id.image_view);
//        mSeekBar = findViewById(R.id.seek_bar);
//        mCheckBoxAndroid = findViewById(R.id.check_android);
//        mCheckBoxBoxJava = findViewById(R.id.check_java);
//        mCheckBoxSQL = findViewById(R.id.check_sql);
//        mRatingBar = findViewById(R.id.rating_bar);

//        text t = new text();
//        mButtonLeft.setOnClickListener(t);
        //左按钮
        mBinding.buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.textView.setText(R.string.button_left);
            }
        });
        //右按钮
        mBinding.buttonRigth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.textView.setText(R.string.button_right);
            }
        });
        //ok按钮
        mBinding.buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = mBinding.editNumber.getText().toString();
                if (a.equals("")) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.please), Toast.LENGTH_LONG).show();
                } else {
                    int temp;
                    try {
                        temp = Integer.parseInt(a);//转换为整数数字
                    } catch (NumberFormatException e) {
                        temp = 100;
                    }
                    mBinding.progressBar.setProgress(temp);//设置进度
                    mBinding.seekBar.setProgress(temp);
                    mBinding.textView.setText(a);
                    if (temp <= 30) {
                        mBinding.radioAndroid.setChecked(true);
                    } else if (temp <= 60) {
                        mBinding.radioApple.setChecked(true);
                    } else {
                        mBinding.radioAli.setChecked(true);
                    }
                }
            }
        });
        //开关
        mBinding.buttonSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mBinding.textView.setText(isChecked ? getResources().getString(R.string.open) : getResources().getString(R.string.close));
            }
        });
        //android复选框
        mBinding.checkAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    android = getResources().getString(R.string.radio_android);
                } else {
                    android = "";
                }
                mBinding.textView.setText(android + java + sql);
            }
        });
        //java复选框
        mBinding.checkJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    java = getResources().getString(R.string.java);
                } else {
                    java = "";
                }
                mBinding.textView.setText(android + java + sql);
            }
        });
        //sql复选框
        mBinding.checkSql.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sql = getResources().getString(R.string.sql);
                } else {
                    sql = "";
                }
                mBinding.textView.setText(android + java + sql);
            }
        });
        //单选按钮组
        mBinding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_android:
                        mBinding.imageView.setImageResource(R.drawable.android);
                        break;
                    case R.id.radio_apple:
                        mBinding.imageView.setImageResource(R.drawable.apple);
                        break;
                    case R.id.radio_ali:
                        mBinding.imageView.setImageResource(R.drawable.ia_100000018);
                        break;
                    default:
                        break;
                }
            }
        });
        //拖拽进度条
        mBinding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //当进度发生变化时调用
                mBinding.textView.setText(String.valueOf(progress));
                mBinding.editNumber.setText(String.valueOf(progress));
                mBinding.progressBar.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //星评价
        mBinding.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(), rating + getResources().getString(R.string.evaluate), Toast.LENGTH_LONG).show();
            }
        });


    }
}
