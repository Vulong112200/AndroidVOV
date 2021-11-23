package com.example.vovmusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vovmusic.R;
import com.example.vovmusic.model.User;
import com.example.vovmusic.service.Api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText email_login;
    private EditText password_login;
    private Button btnlogin;
    private List<User> mListUser;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        email_login=(EditText) findViewById(R.id.dnhap_username);
        password_login=(EditText) findViewById(R.id.dnhap_pass);
        btnlogin=(Button) findViewById(R.id.button_sign);

        mListUser=new ArrayList<>();
        getListUsers();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLogin();
            }
        });
    }

    private void clickLogin() {
        String str_email=email_login.getText().toString().trim();
        String str_pass=password_login.getText().toString().trim();

        if(mListUser==null ||mListUser.isEmpty()){
            return;
        }
        boolean isHasUser =false;
        for (User user: mListUser){
            if(str_email.equals(user.getMail()) ||str_pass.equals(user.getPass())){
                isHasUser= true;
                mUser = user;
                break;
            }
        }
        if(isHasUser){
            Intent intent =new Intent(LoginActivity.this,Home.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(LoginActivity.this,"Email or password invalid",Toast.LENGTH_SHORT).show();
        }

    }

    private void getListUsers() {
        Api.api.allUser()
                .enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        mListUser = response.body();
                        Log.e("List Users",mListUser.size()+"");
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        Toast.makeText(LoginActivity.this,"Call api error",Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
