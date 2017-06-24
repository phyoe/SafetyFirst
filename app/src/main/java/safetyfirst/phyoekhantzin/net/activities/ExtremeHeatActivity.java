package safetyfirst.phyoekhantzin.net.activities;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import safetyfirst.phyoekhantzin.net.adapters.ViewPagerAdapter;
import saftyfirst.phyoekhantzin.net.safetyfirst.R;

public class ExtremeHeatActivity extends AppCompatActivity {
    // Declare Variables
    ViewPager viewPager;
    PagerAdapter adapter;
    int[] heats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extreme_heat);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        heats = new int[] { R.drawable.heat1, R.drawable.heat2,
                R.drawable.heat3, R.drawable.heat4};
        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager_heat);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(this, heats);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);
        ((ViewPager) findViewById(R.id.pager_heat)).setAdapter(adapter);
    }
}
