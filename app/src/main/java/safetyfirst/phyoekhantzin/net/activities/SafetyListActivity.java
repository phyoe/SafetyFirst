package safetyfirst.phyoekhantzin.net.activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import saftyfirst.phyoekhantzin.net.safetyfirst.R;
import safetyfirst.phyoekhantzin.net.adapters.ViewPagerAdapter;
import safetyfirst.phyoekhantzin.net.utils.SafetyFirstConstants;
import safetyfirst.phyoekhantzin.net.views.ViewPodFabs;

public class SafetyListActivity extends BaseActivity
        implements ViewPodFabs.ControllerFabs {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safty_list);

        ViewPodFabs vpFabs = (ViewPodFabs) findViewById(R.id.vp_fabs);
        vpFabs.setController(this);

        LinearLayout menu_earthquake = (LinearLayout) findViewById(R.id.menu_earthquake);
        menu_earthquake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EarthquakesActivityFragment fragment = new EarthquakesActivityFragment();
                // update the main content by replacing fragments
                Bundle args = new Bundle();
                //args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
                fragment.setArguments(args);

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        });

        LinearLayout menu_fire = (LinearLayout) findViewById(R.id.menu_fire);
        menu_fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FireActivityFragment fragment = new FireActivityFragment();
                // update the main content by replacing fragments
                Bundle args = new Bundle();
                //args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
                fragment.setArguments(args);

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_safty_list, menu);
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

    /**
     * Fragment that appears in the "content_frame",
     */
    public static class EarthquakesActivityFragment extends android.app.Fragment {

        // Declare Variables
        ViewPager viewPager;
        PagerAdapter adapter;
        int[] earthquakes;

        public EarthquakesActivityFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_earthquake, container, false);

            earthquakes = new int[] { R.drawable.earthquake1, R.drawable.earthquake2,
                    R.drawable.earthquake3, R.drawable.earthquake4,
                    R.drawable.earthquake5, R.drawable.earthquake6, R.drawable.earthquake7};
            // Locate the ViewPager in viewpager_main.xml
            viewPager = (ViewPager) rootView.findViewById(R.id.pager_earthquake);
            // Pass results to ViewPagerAdapter Class
            adapter = new ViewPagerAdapter(inflater.getContext(), earthquakes);
            // Binds the Adapter to the ViewPager
            viewPager.setAdapter(adapter);
            ((ViewPager) rootView.findViewById(R.id.pager_earthquake)).setAdapter(adapter);
            return rootView;
        }
    }
    public static class FireActivityFragment extends android.app.Fragment {

        // Declare Variables
        ViewPager viewPager;
        PagerAdapter adapter;
        int[] fires;

        public FireActivityFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_fire, container, false);

            fires = new int[] { R.drawable.fire1, R.drawable.fire2,
                    R.drawable.fire3, R.drawable.fire4,
                    R.drawable.fire5, R.drawable.fire6, R.drawable.fire7, R.drawable.fire8};
            // Locate the ViewPager in viewpager_main.xml
            viewPager = (ViewPager) rootView.findViewById(R.id.pager_fire);
            // Pass results to ViewPagerAdapter Class
            adapter = new ViewPagerAdapter(inflater.getContext(), fires);
            // Binds the Adapter to the ViewPager
            viewPager.setAdapter(adapter);
            ((ViewPager) rootView.findViewById(R.id.pager_fire)).setAdapter(adapter);
            return rootView;
        }
    }
}
