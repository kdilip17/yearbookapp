package com.example.hmspl.yearbookapp.modules.webservices;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class ApiHandler {
    public static final String BASE_URL="http://app.yearbook.tk/";
    private static EndPointService sEndPointService = null;
//    private static CdnPointService sCdnPointService = null;


    public static EndPointService getEndPointService() {
        if (sEndPointService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(getClient())
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            sEndPointService = retrofit.create(EndPointService.class);
        }
        return sEndPointService;
    }

   /* public static CdnPointService getCdnPointService() {
        if (sCdnPointService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(getClient())
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            sCdnPointService = retrofit.create(CdnPointService.class);
        }
        return sCdnPointService;
    }*/

    public static MultipartBody.Part getImageBody(String filePath) {

        try {
            File file = new File(filePath);
            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("multipart/form-data"), file);
            return MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        } catch (Exception e) {
            return null;
        }
    }

    private static OkHttpClient getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        // Can be Level.BASIC, Level.HEADERS, or Level.BODY
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                .connectTimeout(50, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS);
        builder.addNetworkInterceptor(interceptor);
       // builder.addInterceptor(new BasicAuthInterceptor(BuildConfig.USER_NAME, BuildConfig.PASSWORD));

        return builder.build();
    }

    public static class BasicAuthInterceptor implements Interceptor {

        private String credentials;

        public BasicAuthInterceptor(String user, String password) {
            this.credentials = Credentials.basic(user, password);
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request authenticatedRequest = request.newBuilder()
                    .header("Authorization", credentials).build();
            return chain.proceed(authenticatedRequest);
        }
    }

}
