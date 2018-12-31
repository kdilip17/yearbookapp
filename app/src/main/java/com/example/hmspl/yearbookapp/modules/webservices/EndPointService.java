package com.example.hmspl.yearbookapp.modules.webservices;

import com.example.hmspl.yearbookapp.modules.dtos.CategoryListResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPointService {
    @GET("category/list")
    Call<CategoryListResponse> getCategoryListCall();

}
