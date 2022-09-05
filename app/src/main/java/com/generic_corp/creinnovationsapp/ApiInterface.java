package com.generic_corp.creinnovationsapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("api/users?page=2")
    Call<final_outer_class> getListData();
}
