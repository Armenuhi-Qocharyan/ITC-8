package com.itc.iblog.Services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;
import com.itc.iblog.R;

/**
 * Created by student on 9/12/17.
 */

public class IBlogFirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        final Intent emptyIntent = new Intent();
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, emptyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        System.out.println("pendingIntent =========================== " + pendingIntent);
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new  NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_action_name)
                .setContentTitle(remoteMessage.getData().get("title"))
                .setContentText(remoteMessage.getData().get("title"))
                .setContentIntent(pendingIntent)
                .setColor(R.color.colorAccent)
                .setPriority(Notification.PRIORITY_HIGH);
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Event tracker details:");
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}