package madscientist.labs.rocktheuniverse;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class BandPage extends AppCompatActivity {
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_band_page);
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.BAND);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int text = getResources().getIdentifier(message + "_description", "string", getPackageName());
        int title = getResources().getIdentifier(message + "_name", "string", getPackageName());
        int img = getResources().getIdentifier(message, "drawable", getPackageName());
        int info = getResources().getIdentifier(message + "_info", "string", getPackageName());

        getSupportActionBar().setTitle(title);
        TextView bandDescription = (TextView) findViewById(R.id.bandDescription);
        bandDescription.setText(text);
        TextView bandInfo = (TextView) findViewById(R.id.bandInfo);
        bandInfo.setText(info);
        ImageView cover = (ImageView) findViewById(R.id.bandCover);
        cover.setImageResource(img);

        SharedPreferences favorites = this.getSharedPreferences("RTU2016", Context.MODE_PRIVATE);
        if (favorites.getBoolean(message, false)) {
            CheckBox ck = (CheckBox) (findViewById(R.id.favorited));
            ck.setChecked(true);
        } else {
            CheckBox ck = (CheckBox) (findViewById(R.id.favorited));
            ck.setChecked(false);
        }

    }

    public void favorite(View v) {
        SharedPreferences favorites = this.getSharedPreferences("RTU2016", Context.MODE_PRIVATE);
        if (favorites.getBoolean(message, false)) {
            favorites.edit().putBoolean(message, false).apply();
            CheckBox ck = (CheckBox) (findViewById(R.id.favorited));
            ck.setChecked(false);
            removeNotification();
            Toast.makeText(this, "Un-Favorited " + getString(getResources().getIdentifier(message + "_name", "string", getPackageName())), Toast.LENGTH_SHORT).show();
        } else {
            favorites.edit().putBoolean(message, true).apply();
            CheckBox ck = (CheckBox) (findViewById(R.id.favorited));
            ck.setChecked(true);
            addNotification();
            Toast.makeText(this, "Favorited " + getString(getResources().getIdentifier(message + "_name", "string", getPackageName())), Toast.LENGTH_SHORT).show();
        }

    }

    public final static String BAND = "com.mycompany.myfirstapp.MESSAGE";

    public void addNotification() {
        Intent intent;
        PendingIntent pendingIntent;
        AlarmManager alarmMgr;
        switch (message) {
            case "ld":
                Calendar c = Calendar.getInstance();
                c.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c.set(Calendar.DAY_OF_MONTH, 7);
                c.set(Calendar.HOUR_OF_DAY, 18);
                c.set(Calendar.MINUTE, 35);
                c.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c.getTimeInMillis(), pendingIntent);
                break;
            case "zw":
                Calendar c1 = Calendar.getInstance();
                c1.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c1.set(Calendar.DAY_OF_MONTH, 7);
                c1.set(Calendar.HOUR_OF_DAY, 20);
                c1.set(Calendar.MINUTE, 5);
                c1.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c1.getTimeInMillis(), pendingIntent);
                break;
            case "jc":
                Calendar c2 = Calendar.getInstance();
                c2.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c2.set(Calendar.DAY_OF_MONTH, 7);
                c2.set(Calendar.HOUR_OF_DAY, 18);
                c2.set(Calendar.MINUTE, 5);
                c2.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 2, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c2.getTimeInMillis(), pendingIntent);
                break;
            case "red":
                Calendar c3 = Calendar.getInstance();
                c3.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c3.set(Calendar.DAY_OF_MONTH, 7);
                c3.set(Calendar.HOUR_OF_DAY, 19);
                c3.set(Calendar.MINUTE, 35);
                c3.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 3, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c3.getTimeInMillis(), pendingIntent);
                break;
            case "tm":
                Calendar c4 = Calendar.getInstance();
                c4.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c4.set(Calendar.DAY_OF_MONTH, 7);
                c4.set(Calendar.HOUR_OF_DAY, 21);
                c4.set(Calendar.MINUTE, 50);
                c4.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 4, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c4.getTimeInMillis(), pendingIntent);
                break;
            case "tl":
                Calendar c5 = Calendar.getInstance();
                c5.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c5.set(Calendar.DAY_OF_MONTH, 7);
                c5.set(Calendar.HOUR_OF_DAY, 21);
                c5.set(Calendar.MINUTE, 5);
                c5.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 5, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c5.getTimeInMillis(), pendingIntent);
                break;
            case "rs":
                Calendar c7 = Calendar.getInstance();
                c7.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c7.set(Calendar.DAY_OF_MONTH, 8);
                c7.set(Calendar.HOUR_OF_DAY, 18);
                c7.set(Calendar.MINUTE, 50);
                c7.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 7, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c7.getTimeInMillis(), pendingIntent);
                break;
            case "ff5":
                Calendar c8 = Calendar.getInstance();
                c8.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c8.set(Calendar.DAY_OF_MONTH, 8);
                c8.set(Calendar.HOUR_OF_DAY, 20);
                c8.set(Calendar.MINUTE, 20);
                c8.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 8, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c8.getTimeInMillis(), pendingIntent);
                break;
            case "bh":
                Calendar c9 = Calendar.getInstance();
                c9.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c9.set(Calendar.DAY_OF_MONTH, 8);
                c9.set(Calendar.HOUR_OF_DAY, 17);
                c9.set(Calendar.MINUTE, 50);
                c9.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 9, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c9.getTimeInMillis(), pendingIntent);
                break;
            case "kc":
                Calendar c10 = Calendar.getInstance();
                c10.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c10.set(Calendar.DAY_OF_MONTH, 8);
                c10.set(Calendar.HOUR_OF_DAY, 19);
                c10.set(Calendar.MINUTE, 20);
                c10.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 10, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c10.getTimeInMillis(), pendingIntent);
                break;
            case "cc":
                Calendar c11 = Calendar.getInstance();
                c11.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c11.set(Calendar.DAY_OF_MONTH, 8);
                c11.set(Calendar.HOUR_OF_DAY, 22);
                c11.set(Calendar.MINUTE, 5);
                c11.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 11, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c11.getTimeInMillis(), pendingIntent);
                break;
            case "am":
                Calendar c12 = Calendar.getInstance();
                c12.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c12.set(Calendar.DAY_OF_MONTH, 8);
                c12.set(Calendar.HOUR_OF_DAY, 21);
                c12.set(Calendar.MINUTE, 5);
                c12.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 12, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c12.getTimeInMillis(), pendingIntent);
                break;
            case "royce":
                Calendar c14 = Calendar.getInstance();
                c14.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c14.set(Calendar.DAY_OF_MONTH, 7);
                c14.set(Calendar.HOUR_OF_DAY, 18);
                c14.set(Calendar.MINUTE, 5);
                c14.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 14, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c14.getTimeInMillis(), pendingIntent);
                break;
            case "jillian":
                Calendar c15 = Calendar.getInstance();
                c15.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c15.set(Calendar.DAY_OF_MONTH, 7);
                c15.set(Calendar.HOUR_OF_DAY, 18);
                c15.set(Calendar.MINUTE, 50);
                c15.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 15, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c15.getTimeInMillis(), pendingIntent);
                break;
            case "seventh":
                Calendar c16 = Calendar.getInstance();
                c16.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c16.set(Calendar.DAY_OF_MONTH, 7);
                c16.set(Calendar.HOUR_OF_DAY, 19);
                c16.set(Calendar.MINUTE, 50);
                c16.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 16, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c16.getTimeInMillis(), pendingIntent);
                break;
            case "promote1":
                Calendar c17 = Calendar.getInstance();
                c17.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c17.set(Calendar.DAY_OF_MONTH, 7);
                c17.set(Calendar.HOUR_OF_DAY, 21);
                c17.set(Calendar.MINUTE, 20);
                c17.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 17, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c17.getTimeInMillis(), pendingIntent);
                break;
            case "ryan":
                Calendar c18 = Calendar.getInstance();
                c18.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c18.set(Calendar.DAY_OF_MONTH, 8);
                c18.set(Calendar.HOUR_OF_DAY, 18);
                c18.set(Calendar.MINUTE, 5);
                c18.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 18, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c18.getTimeInMillis(), pendingIntent);
                break;
            case "about":
                Calendar c19 = Calendar.getInstance();
                c19.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c19.set(Calendar.DAY_OF_MONTH, 8);
                c19.set(Calendar.HOUR_OF_DAY, 18);
                c19.set(Calendar.MINUTE, 50);
                c19.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 19, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c19.getTimeInMillis(), pendingIntent);
                break;
            case "respects":
                Calendar c20 = Calendar.getInstance();
                c20.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c20.set(Calendar.DAY_OF_MONTH, 8);
                c20.set(Calendar.HOUR_OF_DAY, 19);
                c20.set(Calendar.MINUTE, 50);
                c20.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 20, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c20.getTimeInMillis(), pendingIntent);
                break;
            case "promote2":
                Calendar c21 = Calendar.getInstance();
                c21.set(Calendar.MONTH, Calendar.SEPTEMBER);
                c21.set(Calendar.DAY_OF_MONTH, 8);
                c21.set(Calendar.HOUR_OF_DAY, 21);
                c21.set(Calendar.MINUTE, 5);
                c21.set(Calendar.SECOND, 0);
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 21, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.setExact(AlarmManager.RTC, c21.getTimeInMillis(), pendingIntent);
                break;

        }

    }

    public void removeNotification() {
        AlarmManager alarmMgr;
        Intent intent;
        PendingIntent pendingIntent;
        switch (message) {
            case "finding":
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "lauren":
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "kb":
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 2, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "rend":
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 3, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "mat":
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 4, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "jeremy":
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 5, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "skillet":
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 6, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "they":
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 7, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "nf":
                alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id", message);
                pendingIntent = PendingIntent.getBroadcast(this, 8, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "andy":
                alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id",message);
                pendingIntent = PendingIntent.getBroadcast(this, 9, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "family":
                alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id",message);
                pendingIntent = PendingIntent.getBroadcast(this, 10, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "colton":
                alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id",message);
                pendingIntent = PendingIntent.getBroadcast(this, 11, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "tobymac":
                alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id",message);
                pendingIntent = PendingIntent.getBroadcast(this, 12, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "lecrae":
                alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id",message);
                pendingIntent = PendingIntent.getBroadcast(this, 13, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "royce":
                alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id",message);
                pendingIntent = PendingIntent.getBroadcast(this, 14, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "jillian":
                alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id",message);
                pendingIntent = PendingIntent.getBroadcast(this, 15, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "seventh":
                alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id",message);
                pendingIntent = PendingIntent.getBroadcast(this, 16, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "promote1":
                alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id",message);
                pendingIntent = PendingIntent.getBroadcast(this, 17, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "ryan":
                alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id",message);
                pendingIntent = PendingIntent.getBroadcast(this, 18, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "about":
                alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id",message);
                pendingIntent = PendingIntent.getBroadcast(this, 19, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "respects":
                alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id",message);
                pendingIntent = PendingIntent.getBroadcast(this, 20, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
            case "promote2":
                alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
                intent = new Intent(this, MyReceiver.class);
                intent.putExtra("id",message);
                pendingIntent = PendingIntent.getBroadcast(this, 21, intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.cancel(pendingIntent);
                break;
        }
    }

}
