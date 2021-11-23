package com.example.vovmusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vovmusic.R;
import com.example.vovmusic.service.HttpUtils;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class DangNhapActivity extends AppCompatActivity {
    TextInputEditText tv_dnhap_username;
    TextInputEditText tv_dnhap_pass;
    Button btn_dnhap;
    TextView btn_dky;
    TextInputLayout layout_dnhap_username;
    TextInputLayout layout_dnhap_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        tv_dnhap_username = findViewById(R.id.dnhap_username);
        tv_dnhap_pass = findViewById(R.id.dnhap_pass);
        btn_dnhap = findViewById(R.id.button_sign);
        btn_dky = findViewById(R.id.text_signup);
        layout_dnhap_pass = findViewById(R.id.layout_password);
        layout_dnhap_username = findViewById(R.id.layout_username);

        tv_dnhap_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                layout_dnhap_username.setBackground(getResources().getDrawable(R.drawable.bg_corner_dnhap));
                layout_dnhap_username.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tv_dnhap_pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                layout_dnhap_pass.setBackground(getResources().getDrawable(R.drawable.bg_corner_dnhap));
                layout_dnhap_pass.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btn_dnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = tv_dnhap_username.getText().toString();
                String password = tv_dnhap_pass.getText().toString();

                if (email.length() == 0 && password.length() == 0) {
                    layout_dnhap_username.setBackground(getResources().getDrawable(R.drawable.bg_warning));
                    layout_dnhap_pass.setBackground(getResources().getDrawable(R.drawable.bg_warning));
                    layout_dnhap_username.setError("Vui lòng điền username");
                    layout_dnhap_pass.setError("Vui lòng điền mật khẩu");
                } else if (email.length() == 0) {
                    layout_dnhap_username.setBackground(getResources().getDrawable(R.drawable.bg_warning));
                    layout_dnhap_username.setError("Vui lòng điền username");
                } else if (password.length() == 0) {
                    layout_dnhap_pass.setBackground(getResources().getDrawable(R.drawable.bg_warning));
                    layout_dnhap_pass.setError("Vui lòng điền mật khẩu");
                } else {
                    JSONObject jsonParams = new JSONObject();
                    try {
                        jsonParams.put("Email", email);
                        jsonParams.put("Password", password);
                        StringEntity entity = new StringEntity(jsonParams.toString());
                        HttpUtils.post(v.getContext(), "user/find", entity, new JsonHttpResponseHandler() {
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                try {
                                    JSONArray listuser = response.getJSONArray("user");
                                    if (listuser != null) {
                                        JSONObject user = listuser.getJSONObject(0);
                                        Intent intent = new Intent(DangNhapActivity.this, Home.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            @Override
                            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                                layout_dnhap_username.setBackground(getResources().getDrawable(R.drawable.bg_warning));
                                layout_dnhap_pass.setBackground(getResources().getDrawable(R.drawable.bg_warning));
                                layout_dnhap_username.setError("Username hoặc mật khẩu không đúng");
                                layout_dnhap_pass.setError("Username hoặc mật khẩu không đúng");
                            }
                        });
                    } catch (JSONException | UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        btn_dky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhapActivity.this, Register.class);
                startActivity(intent);
            }
        });
    }
}
