package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityUpdatePwdBinding;

/**
 * @author LGC
 */
public class UpdatePwdActivity extends AppCompatActivity {
    private ActivityUpdatePwdBinding mBinding;
    private String pwd, okPwd,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityUpdatePwdBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = ResetPwdActivity.phone;
                pwd = mBinding.editPwd.getText().toString();
                okPwd = mBinding.editPwdOk.getText().toString();
                String toast;

                SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);
                String error = "0";
                String spPwd = sp.getString("pwd_"+phone,error);
                if ("".equals(pwd) || "".equals(okPwd)){
                    toast = "密码不能为空";
                }else if (pwd.length() != 6){
                    toast = "密码长度为6位";
                }else if (!okPwd.equals(pwd)){
                    toast = "密码不一致";
                }else if (pwd.equals(spPwd)){
                    toast = "新密码不能时近期使用过的密码";
                }else{
                    sp.edit().putString("pwd_"+phone,pwd).apply();
                    toast = "修改成功";
                    finish();
                }
                Toast.makeText(UpdatePwdActivity.this,toast,Toast.LENGTH_LONG).show();
            }
        });

    }
}