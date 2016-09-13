package madscientist.labs.rocktheuniverse;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;


public class MyReceiver extends BroadcastReceiver {

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intenta) {
        System.out.println(intenta.getStringExtra("id")+" Received");
        String message=intenta.getStringExtra("id");

        int title = context.getResources().getIdentifier(message + "_name", "string", context.getPackageName());
        System.out.println(title+message+" nc");
        int info = context.getResources().getIdentifier(message + "_info", "string", context.getPackageName());

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.nciconsmall)
                        .setLargeIcon((BitmapFactory.decodeResource(context.getResources(), R.mipmap.ncicon)))
                        .setContentTitle(context.getString(title))
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setPriority(1)
                        .setContentText(context.getString(info));

        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(title, mBuilder.build());

    }


}
