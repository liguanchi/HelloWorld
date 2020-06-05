package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = mBinding.editPhone.getText().toString();
                String pwd = mBinding.editPwd.getText().toString();
                SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);
                String tempPhone = sp.getString("phone_" + phone, "error");
                String tempPwd = sp.getString("pwd_" + phone, "-1");
                if (phone.equals(tempPhone) && pwd.equals(tempPwd)) {
                    Bundle bundle = new Bundle();
                    String userName = sp.getString("name_" + phone, "0");
                    String userSex = sp.getString("sex_" + phone, "0");
                    String userSms = sp.getString("sms_" + phone, "0").equals("1") ? " 接受" : " 不接受";
                    UserInfo u = new UserInfo(userName, pwd, userSex, phone, userSms);
                    bundle.putSerializable("userInfo",u);

                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);//上下文，目标activity的类
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "密码或者手机号错误", Toast.LENGTH_LONG).show();
                }

            }
        });

        mBinding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
