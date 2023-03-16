package com.android.androidapp_frontend.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MemberVOApi {
    @POST("/signin")
    Call<Boolean> postUser(@Body MemberVO memberVO);

}
