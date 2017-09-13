package com.itc.iblog.Services;

import android.app.DownloadManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import android.widget.Toast;

import com.google.gson.Gson;
import com.itc.iblog.models.PostRequestData;


import java.io.IOException;
/*
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
*/
/**
 * Created by student on 9/13/17.
 */

public class RequestService extends Service {
   // private static final String SERVER_KEY = "AAAA9zVO14U:APA91bGsY0Y8m6GvY4bc1eJ243OtS5stHMcgjw7lcv927MW9ZyGYyfKSwRyo3xrNthLx0LMO4Boi6Kq-bU4oztnUhyJ0vqpW6eTi7eqcNnwrkLB4LvYQdwb6PfiVaxBP2uB-ZFY15g6u";
    private PostRequestData postRequestData;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public RequestService(PostRequestData postRequestData) {
        this.postRequestData = postRequestData;
    }

    @Override
    public void onCreate() {
        super.onCreate();
     /*   Gson gson = new Gson();
        String json = gson.toJson(postRequestData);
        String url = "https://fcm.googleapis.com/fcm/send";
        final MediaType JSON = MediaType.parse("aplication/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "key=" + SERVER_KEY)
                .post(body)
                .build();
        Callback responseCallBack = new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Toast.makeText(RequestService.this, "Fail", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                Toast.makeText(RequestService.this, "Success", Toast.LENGTH_SHORT).show();
            }
        };
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        call.enqueue(responseCallBack);*/
    }
}
