package com.example.checkincheckout.Retrofit;

import com.example.checkincheckout.model.CheckOut;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Smart_Time {

    @GET("checkout/13")
    Call<CheckOut> getCheckout();
}
