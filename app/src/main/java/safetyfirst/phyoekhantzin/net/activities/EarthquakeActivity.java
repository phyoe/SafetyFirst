package safetyfirst.phyoekhantzin.net.activities;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import saftyfirst.phyoekhantzin.net.safetyfirst.R;
import safetyfirst.phyoekhantzin.net.adapters.ViewPagerAdapter;

public class EarthquakeActivity extends AppCompatActivity {

    LinearLayout earthquake_content_before;
    LinearLayout earthquake_content_during;
    LinearLayout earthquake_content_after;

    // Declare Variables
    ViewPager viewPager;
    PagerAdapter adapter;
    int[] earthquakes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);

        earthquakes = new int[] { R.drawable.earthquake1, R.drawable.earthquake2,
                R.drawable.earthquake3, R.drawable.earthquake4,
                R.drawable.earthquake5, R.drawable.earthquake6, R.drawable.earthquake7};
        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager_earthquake);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(this, earthquakes);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);
        ((ViewPager) findViewById(R.id.pager_earthquake)).setAdapter(adapter);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        earthquake_content_before = (LinearLayout) findViewById(R.id.earthquake_content_before);
        earthquake_content_during = (LinearLayout) findViewById(R.id.earthquake_content_during);
        earthquake_content_after = (LinearLayout) findViewById(R.id.earthquake_content_after);
        // hide until its title is clicked
        earthquake_content_before.setVisibility(View.VISIBLE);
        earthquake_content_during.setVisibility(View.GONE);
        earthquake_content_after.setVisibility(View.GONE);

    }
    /**
     * onClick handler
     */
    public void toggle_contents1(View v){

        earthquake_content_before.setVisibility( earthquake_content_before.isShown()
                ? View.GONE
                : View.VISIBLE );
    }
    public void toggle_contents2(View v){

        earthquake_content_during.setVisibility( earthquake_content_during.isShown()
                ? View.GONE
                : View.VISIBLE );
    }
    public void toggle_contents3(View v){

        earthquake_content_after.setVisibility( earthquake_content_after.isShown()
                ? View.GONE
                : View.VISIBLE );
    }
}
