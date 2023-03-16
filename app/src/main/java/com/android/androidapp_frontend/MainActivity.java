package com.android.androidapp_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.androidapp_frontend.retrofit.MemberVO;
import com.android.androidapp_frontend.retrofit.MemberVOApi;
import com.squareup.moshi.Moshi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    Button btnSignIn;
    EditText signInId, signInPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInId = (EditText) findViewById(R.id.signInId);
        signInPw = (EditText) findViewById(R.id.signInPw);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = signInId.getText().toString();
                String pw = signInPw.getText().toString();

                MemberVO loginInfo = new MemberVO();
                loginInfo.setId(id);
                loginInfo.setPw(pw);

                Moshi moshi = new Moshi.Builder().build();

                // Retrofit 객체 생성 및 MoshiConverter 추가
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.0.218:9008/")
                        .addConverterFactory(MoshiConverterFactory.create(moshi)).build();

                MemberVOApi api = retrofit.create(MemberVOApi.class);

                Call<Boolean> call = api.postUser(loginInfo);
                call.enqueue(new Callback<Boolean>() {
                    // Controller에서 response.isSuccessful 응답 성공(또는 실패) 시 처리할 프로세스 정의
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    if(response.isSuccessful()){
                        boolean userExists = response.body();

                        if (userExists){
                            Intent intent = new Intent(getApplicationContext(), LogInSuccess.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "아이디 혹은 비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Log.d(TAG, "Status Code : " + response.code());
                    }
                    }
                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                    Log.d(TAG, "Fail msg : " + t.getMessage());
                    }
                });
            }
        });
    }
}