package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityResetPwdBinding;

/**
 * @author LGC
 */
public class ResetPwdActivity extends AppCompatActivity {
    public static  String phone;
    private ActivityResetPwdBinding mBinding;
    String  name, sex = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityResetPwdBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = mBinding.editPhone.getText().toString().trim();
                name = mBinding.editUserName.getText().toString().trim();

                String toast = null;
                if (phone.equals("")) {
                    toast = "请输入手机号";
                } else if (name.equals("")) {
                    toast = "请输入用户名";
                } else if (phone.length() != 11) {
                    toast = "请输入正确的手机号码";
                } else if (sex.equals("")) {
                    toast = "请选择性别";
                } else {
                    SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);
                    String error = "0";
                    String spPhone = sp.getString("phone_" + phone, error);
                    String spName = sp.getString("name_" + phone, error);
                    String spSex = sp.getString("sex_" + phone, error);
                    if (!spPhone.equals(phone) || !spName.equals(name) || !spSex.equals(sex)) {
                        toast = "很抱歉，信息不匹配，无法重置密码";
                    } else {
                        Intent intent = new Intent(ResetPwdActivity.this, UpdatePwdActivity.class);

                        startActivity(intent);
                        toast = "请输入新密码";
                    }
                }
                Toast.makeText(ResetPwdActivity.this, toast, Toast.LENGTH_LONG).show();
            }
        });

        mBinding.radioGroupSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_man) {
                    sex = mBinding.radioMan.getText().toString();
                } else {
                    sex = mBinding.radioWomon.getText().toString();
                }
            }
        });

    }
}