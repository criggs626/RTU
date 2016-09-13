package madscientist.labs.rocktheuniverse;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    View mainPage;
    View fridayPage;
    View saturdayPage;
    View favoritePage;
    View fanZone;
    NavigationView navigationView;
    public final static String BAND = "com.mycompany.myfirstapp.MESSAGE";
    private static final String TWITTER_KEY = "pm0qsrFlpnlD3JQM1HhuEMYDa";
    private static final String TWITTER_SECRET = "OpgfyUsOKLj1s55i3xjH1kAyWI4uGm4aLa6TNnGFf0K6wEBUnG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        //here
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.home);
        createViews();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            switchViews(1);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            switchViews(1);
        } else if (id == R.id.friday) {
            switchViews(2);
        } else if (id == R.id.saturday) {
            switchViews(3);
        } else if (id == R.id.fav) {
            switchViews(4);
        } else if (id == R.id.connect) {
            switchViews(5);
        }else if (id == R.id.fanZone) {
            switchViews(6);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void createViews() {
        ViewStub stub = (ViewStub) findViewById(R.id.main_page);
        stub.setLayoutResource(R.layout.content_main);
        mainPage = stub.inflate();

        stub = (ViewStub) findViewById(R.id.friday_page);
        stub.setLayoutResource(R.layout.friday_night);
        fridayPage = stub.inflate();
        fridayPage.setVisibility(View.GONE);

        stub = (ViewStub) findViewById(R.id.saturday_page);
        stub.setLayoutResource(R.layout.saturday_night);
        saturdayPage = stub.inflate();
        saturdayPage.setVisibility(View.GONE);

        stub = (ViewStub) findViewById(R.id.favorite_page);
        stub.setLayoutResource(R.layout.favorite);
        favoritePage = stub.inflate();
        favoritePage.setVisibility(View.GONE);

        stub = (ViewStub) findViewById(R.id.fan_page);
        stub.setLayoutResource(R.layout.fan_zone);
        fanZone = stub.inflate();
        fanZone.setVisibility(View.GONE);

    }

    public void switchViews(int page) {
        switch (page) {
            case 1: {
                fridayPage.setVisibility(View.GONE);
                saturdayPage.setVisibility(View.GONE);
                favoritePage.setVisibility(View.GONE);
                mainPage.setVisibility(View.VISIBLE);
                fanZone.setVisibility(View.GONE);
                navigationView.setCheckedItem(R.id.home);
            }
            break;
            case 2: {
                saturdayPage.setVisibility(View.GONE);
                mainPage.setVisibility(View.GONE);
                favoritePage.setVisibility(View.GONE);
                fanZone.setVisibility(View.GONE);
                fridayPage.setVisibility(View.VISIBLE);
                navigationView.setCheckedItem(R.id.friday);
            }
            break;
            case 3: {
                fridayPage.setVisibility(View.GONE);
                mainPage.setVisibility(View.GONE);
                saturdayPage.setVisibility(View.VISIBLE);
                favoritePage.setVisibility(View.GONE);
                fanZone.setVisibility(View.GONE);
                navigationView.setCheckedItem(R.id.saturday);
            }
            break;
            case 4: {
                fridayPage.setVisibility(View.GONE);
                mainPage.setVisibility(View.GONE);
                saturdayPage.setVisibility(View.GONE);
                favoritePage.setVisibility(View.VISIBLE);
                fanZone.setVisibility(View.GONE);
                addFavorites();
                navigationView.setCheckedItem(R.id.fav);
            }
            break;
            case 5: {
                Intent intent = new Intent(this, TimelineActivity.class);
                startActivity(intent);
                navigationView.setCheckedItem(R.id.connect);
            }
            break;
            case 6:{
                fridayPage.setVisibility(View.GONE);
                mainPage.setVisibility(View.GONE);
                saturdayPage.setVisibility(View.GONE);
                favoritePage.setVisibility(View.GONE);
                fanZone.setVisibility(View.VISIBLE);
                navigationView.setCheckedItem(R.id.fanZone);
            }
            break;
        }
    }

    public void quickSwitch(View v) {
        if (v.getId() == R.id.switchFriday) {
            switchViews(2);
        } else if (v.getId() == R.id.switchSaturday) {
            switchViews(3);
        } else if (v.getId() == R.id.switchFavorite) {
            switchViews(4);
        }
    }

    public void bandPage(View v) {
        Intent intent = new Intent(this, BandPage.class);
        String message = v.getTag().toString();
        intent.putExtra(BAND, message);
        startActivity(intent);
    }

    public void addFavorites() {
        LinearLayout layout1 = (LinearLayout) findViewById(R.id.fridayFavorites);
        layout1.removeAllViews();

        LinearLayout layout2 = (LinearLayout) findViewById(R.id.saturdayFavorites);
        layout2.removeAllViews();

        TextView heading1 = (TextView) findViewById(R.id.favoriteTitle1);
        heading1.setText("Favorites");
        TextView heading2 = (TextView) findViewById(R.id.favoriteTitle2);
        heading2.setText("");

        SharedPreferences favorites = this.getSharedPreferences("RTU2016", Context.MODE_PRIVATE);

        String[] fridayBands = {"kb","royce","finding","jillian","rend","seventh","lauren","jeremy","promote1","mat","skillet"};
        String[] saturdayBands = {"andy","ryan","they","about","family","respects","nf","tobymac","promote2","colton","lecrae"};

        List<String> favoriteBands = new ArrayList<String>();

        int val = 7;
        for (int i = 0; i < fridayBands.length; i++) {
            if (favorites.getBoolean(fridayBands[i], false)) {
                favoriteBands.add(fridayBands[i]);
                LinearLayout layout = (LinearLayout) findViewById(R.id.fridayFavorites);
                Button btnTag = new Button(this);
                btnTag.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                btnTag.setPadding(10, 10, 10, 10);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                params.setMargins(0, 0, 0, 30);
                btnTag.setLayoutParams(params);
                btnTag.setText(getResources().getIdentifier(fridayBands[i] + "_name", "string", getPackageName()));
                btnTag.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnTag.setTag(fridayBands[i]);
                btnTag.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.mipmap.ic_chevron_right_black_24dp), null);
                //add button to the layout
                layout.addView(btnTag);
                btnTag.setOnClickListener(myhandler);
            }
        }
        int compare = favoriteBands.size();

        for (int i = 0; i < saturdayBands.length; i++) {
            if (favorites.getBoolean(saturdayBands[i], false)) {
                favoriteBands.add(saturdayBands[i]);
                LinearLayout layout = (LinearLayout) findViewById(R.id.saturdayFavorites);
                Button btnTag = new Button(this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                params.setMargins(0, 0, 0, 50);
                btnTag.setPadding(10, 10, 10, 10);
                btnTag.setLayoutParams(params);
                btnTag.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                btnTag.setText(getResources().getIdentifier(saturdayBands[i] + "_name", "string", getPackageName()));
                btnTag.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnTag.setTag(saturdayBands[i]);
                btnTag.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.mipmap.ic_chevron_right_black_24dp), null);
                //add button to the layout
                layout.addView(btnTag);
                btnTag.setOnClickListener(myhandler);
            }
        }
        if (compare != 0) {
            TextView heading = (TextView) findViewById(R.id.favoriteTitle1);
            heading.setText("Friday Bands");
        }
        if (favoriteBands.size() != compare) {
            TextView heading = (TextView) findViewById(R.id.favoriteTitle2);
            heading.setText("Saturday Bands");
        } else if (compare == 0) {
            TextView heading = (TextView) findViewById(R.id.favoriteTitle1);
            heading.setText("No Bands Favorited");
        }
    }

    View.OnClickListener myhandler = new View.OnClickListener() {
        public void onClick(View v) {
            bandPage(v);
        }


      };
}
