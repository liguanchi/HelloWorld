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
    private String pwd,pwdOK,phone;

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
                pwdOK = mBinding.editPwdOk.getText().toString();
                String toast;
                if (pwd.equals("")){
                    toast = "密码不能为空";
                }else if (pwd.length() != 6){
                    toast = "密码长度为6位";
                }else if (!pwdOK.equals(pwd)){
                    toast = "密码不一致";
                }else{
                    SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("pwd_"+phone,pwd);
                    editor.apply();
                    Intent intent = new Intent(UpdatePwdActivity.this, MainActivity.class);
                    startActivity(intent);
                    toast = "修改成功";
                    finish();
                }
                Toast.makeText(UpdatePwdActivity.this,toast,Toast.LENGTH_LONG).show();
            }
        });

    }
}