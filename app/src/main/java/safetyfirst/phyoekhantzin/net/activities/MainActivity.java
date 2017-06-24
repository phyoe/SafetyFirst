package safetyfirst.phyoekhantzin.net.activities;

import android.Manifest;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

import saftyfirst.phyoekhantzin.net.safetyfirst.R;
import safetyfirst.phyoekhantzin.net.adapters.ViewPagerAdapter;
import safetyfirst.phyoekhantzin.net.utils.SafetyFirstConstants;
import safetyfirst.phyoekhantzin.net.views.ViewPodFabs;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ViewPodFabs.ControllerFabs{

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 100;

    private String numberToCall = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPodFabs vpFabs = (ViewPodFabs) findViewById(R.id.vp_fabs);
        vpFabs.setController(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = new SaftyListActivityFragment();
        showActivityFragment(fragment);
    }

    public void openFire(View v){
        Toast.makeText(getApplicationContext(), "In case of Fire ...", Toast.LENGTH_SHORT).show();

        Intent in = new Intent(this, FireActivity.class);
        startActivity(in);
    }
    public void openExtremeHeat(View v){
        Toast.makeText(getApplicationContext(), "In case of Extreme Heat ...", Toast.LENGTH_SHORT).show();

        Intent in = new Intent(this, ExtremeHeatActivity.class);
        startActivity(in);
    }
    public void openFlood(View v){
        Toast.makeText(getApplicationContext(), "In case of Flood ...", Toast.LENGTH_SHORT).show();

        Intent in = new Intent(this, FloodActivity.class);
        startActivity(in);
    }
    public void openEarthquake(View v){
        Toast.makeText(getApplicationContext(), "In case of Earthquake ...", Toast.LENGTH_SHORT).show();

        Intent in = new Intent(this, EarthquakeActivity.class);
        startActivity(in);
    }
    public void openLightning(View v){
        Toast.makeText(getApplicationContext(), "In case of Lightning ...", Toast.LENGTH_SHORT).show();

        Intent in = new Intent(this, LightningActivity.class);
        startActivity(in);
    }
    public void openTsunami(View v){
        Toast.makeText(getApplicationContext(), "In case of Tsunami ...", Toast.LENGTH_SHORT).show();

        Intent in = new Intent(this, TsunamiActivity.class);
        startActivity(in);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Fragment fragment = new SaftyListActivityFragment();
            showActivityFragment(fragment);

        } else if (id == R.id.nav_fire) {
            Toast.makeText(getApplicationContext(), "In case of Fire ...", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(this, FireActivity.class);
            startActivity(in);

        } else if (id == R.id.nav_extreme_heat) {
            Toast.makeText(getApplicationContext(), "In case of Extreme Heat ...", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(this, ExtremeHeatActivity.class);
            startActivity(in);

        } else if (id == R.id.nav_flood) {
            Toast.makeText(getApplicationContext(), "In case of Flood ...", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(this, FloodActivity.class);
            startActivity(in);

        } else if (id == R.id.nav_earthquake) {
            Toast.makeText(getApplicationContext(), "In case of Earthquake ...", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(this, EarthquakeActivity.class);
            startActivity(in);

        } else if (id == R.id.nav_lightning) {
            Toast.makeText(getApplicationContext(), "In case of Lightning ...", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(this, LightningActivity.class);
            startActivity(in);

        } else if (id == R.id.nav_tsunami) {
            Toast.makeText(getApplicationContext(), "In case of Tsunami ...", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(this, TsunamiActivity.class);
            startActivity(in);

        } else if (id == R.id.nav_telphone_list) {
            Intent in = new Intent(this, TelephoneListActivity.class);
            startActivity(in);
        } else if (id == R.id.nav_cdc_url) {
            openInCDCUrl(SafetyFirstConstants.URI_TO_OPEN_IN_CDC);
        }else{
            Fragment fragment = new SaftyListActivityFragment();
            showActivityFragment(fragment);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showActivityFragment(Fragment fragment){

        // update the main content by replacing fragments
        Bundle args = new Bundle();
        //args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
        fragment.setArguments(args);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }
    @Override
    public void onTapCall() {
        makeCall(SafetyFirstConstants.NUMBER_TO_CALL);
    }

    @Override
    public void onTapMap() {
        navigateInMap(SafetyFirstConstants.URI_TO_OPEN_IN_MAP);
    }

    @Override
    public void onTapFacebook() {
        openInFacebook(SafetyFirstConstants.URI_TO_OPEN_IN_FACEBOOK);
    }

    protected void makeCall(String numberToCall) {
        numberToCall.replaceAll(" ", "");
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numberToCall));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            this.numberToCall = numberToCall;

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);

            return;
        }
        startActivity(intent);
    }

    protected void navigateInMap(String uriToOpen) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uriToOpen));
        startActivity(intent);
    }

    protected void openInFacebook(String url) {
        Uri uri = Uri.parse(url);
        try {
            ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo("com.facebook.katana", 0);
            if (applicationInfo.enabled) {
                // http://stackoverflow.com/a/24547437/1048340
                uri = Uri.parse("fb://facewebmodal/f?href=" + url);
            }
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    protected void openInCDCUrl(String url) {
        Uri uri = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    /**
     * Fragment that appears in the "content_frame",
     */
    public static class SaftyListActivityFragment extends Fragment {

        public SaftyListActivityFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_safty_list, container, false);
            return rootView;
        }
    }
}
