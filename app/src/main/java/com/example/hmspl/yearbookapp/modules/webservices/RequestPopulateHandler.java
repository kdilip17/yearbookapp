package com.example.hmspl.yearbookapp.modules.webservices;

import com.example.hmspl.yearbookapp.modules.dtos.CategoryListResponse;
import retrofit2.Call;

public class RequestPopulateHandler {

    private static RequestPopulateHandler sRequestPopulateHandler = null;

    public static RequestPopulateHandler getInstance() {
        if (sRequestPopulateHandler == null) {
            sRequestPopulateHandler = new RequestPopulateHandler();
        }
        return sRequestPopulateHandler;
    }
    public Call<CategoryListResponse> getCategoryListResponse() {
        return ApiHandler.getEndPointService().getCategoryListCall();
    }


}
