package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private String phone = "13380906674";
    private String pwd = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBinding.editPhone.getText().toString().equals(phone) && mBinding.editPwd.getText().toString().equals(pwd)) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);//上下文，目标activity的类
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "密码或者手机号错误", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
