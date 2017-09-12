package com.instigatemobile.appnotifications;

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by student on 9/12/17.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("Test", "Refreshed token: " + refreshedToken);

        //sendRegistrationToServer(refreshedToken);
    }
}
