package com.example.hmspl.yearbookapp.modules.webservices;

import android.support.annotation.NonNull;
import android.util.Log;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Random;


public class ModelHandler<T> implements Constants {

    private static final String TAG = "ModelHandler";

    private static ModelHandler sModelHandler = null;

    private HashMap<Integer, Call<T>> mCallList = new HashMap<>();
    private Random random = new Random();

    public static ModelHandler getInstance() {
        if (sModelHandler == null) {
            sModelHandler = new ModelHandler();
        }
        return sModelHandler;
    }


    public int enqueueTask(final ModelHandlerListener<T> modelHandlerListener, Call<T> call) {
        final int callId = generateCallId();
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {

              /*  ApiStatusDto apiStatusDto;
                int statusCode = response.code();
                if (response.isSuccessful()) {
                    apiStatusDto = (ApiStatusDto) response.body();
                    apiStatusDto.setStatusCode(response.code());
                } else {
                    apiStatusDto = new ApiStatusDto();
                    ResponseBody errorBody = response.errorBody();
                    apiStatusDto = getStatusCodeFromErrorResponse(errorBody);
                    apiStatusDto.setStatusCode(statusCode);
                }

                if (apiStatusDto.isResultOk() || (!TextUtils.isEmpty(apiStatusDto.getMessage()) && apiStatusDto.getMessage().equalsIgnoreCase(Constants.ApiKeys.SUCCESS))) {
                    modelHandlerListener.onSuccessApi((T) apiStatusDto);
                } else if (statusCode == ErrorCodes.SESSION_EXPIRED_1 || statusCode == ErrorCodes.SESSION_EXPIRED_2) {
                    removeAllCall();
                    Intent intent = new Intent(Constants.BroadcastKeys.UNAUTHORIZED);
                    intent.putExtra(Constants.BroadcastKeys.MESSAGE, apiStatusDto.getMessage());
                    HmLibrary.getHmLibrary().getContext().sendBroadcast(intent);
                } else {
                    if (!TextUtils.isEmpty(apiStatusDto.getMsg())) {
                        String msg = apiStatusDto.getMsg();
                        if (null != apiStatusDto.getStatus_code()) {
                            modelHandlerListener.onFailureApi(apiStatusDto.getStatus_code(), msg);
                        } else {
                            modelHandlerListener.onFailureApi(statusCode, msg);
                        }
                    }else if (!TextUtils.isEmpty(apiStatusDto.getMessage())) {
                        String msg = apiStatusDto.getMessage();
                        if (null != apiStatusDto.getStatus_code()) {
                            modelHandlerListener.onFailureApi(apiStatusDto.getStatus_code(), msg);
                        } else {
                            modelHandlerListener.onFailureApi(statusCode, msg);
                        }
                    } else {
                        modelHandlerListener.onFailureApi(statusCode, getUserMessageFromErrorResponse(response.errorBody()));
                    }
                }*/
                Log.d(TAG, "Api Response :: " + CodeSnippet.getJsonStringFromObject(response.body()));
                dequeueTask(callId);
            }

            @Override
            public void onFailure(Call<T> call, Throwable exception) {
                int errorCode = 0;
                String message = "";
                Log.d(TAG, "Api Response :: " + exception.getMessage());
                if (null != exception.getMessage() && (exception.getMessage().equals("Canceled")
                        || exception.getMessage().equals("Socket closed"))) {
                    errorCode = Constants.ErrorCodes.API_CALL_MANUALY_CANCELED;
                } else if (exception instanceof SocketTimeoutException) {
                    errorCode = ErrorCodes.TIME_OUT;
                    message = AlertMessages.TIME_OUT;
                } else if (exception instanceof ProtocolException) {
                    errorCode = ErrorCodes.SERVER_LOOP_ERROR_OCCURED;
//                    message = AlertMessages.SERVER_ERROR_OCCURED;
                } else if (exception instanceof JSONException) {
                    errorCode = ErrorCodes.JSON_PARSING;
                    message = AlertMessages.JSON_PARSING;
                } else if (exception instanceof UnknownHostException) {
                    errorCode = ErrorCodes.SERVER_CONNECTION_FAILED;
                    message = AlertMessages.SERVER_CONNECTION_FAILED;
                } else {
                    errorCode = ErrorCodes.SERVICE_UNAVAILABLE;
                    message = AlertMessages.UNKOWN_ERROR;
                }
                modelHandlerListener.onFailureApi(errorCode, message);
                dequeueTask(callId);
            }
        });
        saveApiCalls(callId, call);
        return callId;
    }

    /**
     * This method is mainly focused to get error message from server error response
     *
     * @param responseBody
     * @return user indication message if response body contains userMsg key with value otherwise will send value of Constants.Alerts.UNEXPECTED_ERROR
     */

    @NonNull
    public static String getUserMessageFromErrorResponse(ResponseBody responseBody) {

        String responseString;
        JSONObject jsonObject = null;
        try {
            responseString = responseBody.string();
            jsonObject = new JSONObject(responseString);
            android.util.Log.i(TAG, "User Message" + jsonObject.getString(Constants.ApiKeys.MESSAGE));
            return jsonObject.getString(Constants.ApiKeys.MESSAGE);
        } catch (IOException ioe) {
            return Constants.AlertMessages.TIME_OUT;
        } catch (JSONException e) {
            if (jsonObject != null) {
                try {
                    android.util.Log.i(TAG, "User Message" + jsonObject.getString(Constants.ApiKeys.ERROR));
                    return jsonObject.getString(Constants.ApiKeys.ERROR);
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        } catch (Exception e) {
            return Constants.AlertMessages.UNKOWN_ERROR;
        }
        return Constants.AlertMessages.UNKOWN_ERROR;
    }

   /* private ApiStatusDto getStatusCodeFromErrorResponse(ResponseBody responseBody) {

        String responseString;
        ApiStatusDto statusDto = null;
        try {
            responseString = responseBody.string();
            statusDto = CodeSnippet.getObjectFromJson(responseString, ApiStatusDto.class);
            return statusDto==null?new ApiStatusDto():statusDto;
        } catch (IOException ioe) {
            return new ApiStatusDto();
        } catch (Exception e) {
            return new ApiStatusDto();
        }
    }*/

    private void removeAllCall() {
        for (Call call : mCallList.values()) {
            call.cancel();
        }
    }

    public Response<T> enqueueNonAsyncTask(Call<T> call) {
        try {
            return call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getDateFromHeaders(Response<T> response) {
        return response.headers().get("Date");
    }

    private void saveApiCalls(int callId, Call<T> call) {
        mCallList.put(callId, call);
    }

    private void removeApiCalls(int callId) {
        if (mCallList.containsKey(callId)) {
            mCallList.remove(callId);
        }
    }

    public void dequeueTask(int... callIds) {
        if (callIds.length > 0) {
            for (int id : callIds) {
                clearApiCall(id);
            }
        }
    }

    private void clearApiCall(int callId) {
        if (mCallList.containsKey(callId)) {
            Call<T> call = mCallList.get(callId);
            call.cancel();
            removeApiCalls(callId);
        }
    }

    private int generateCallId() {
        int taskId = random.nextInt(100);
        if (mCallList.containsKey(taskId)) {
            return generateCallId();
        }
        return taskId;
    }

    public interface ModelHandlerListener<T> extends BaseModelHandlerListener<T> {
        void onAuthorizationFailed();
    }

    public interface BaseModelHandlerListener<T> {

        void onSuccessApi(T response);

        void onFailureApi(int errorCode, String errorMessage);
    }
}
