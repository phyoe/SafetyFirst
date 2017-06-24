package safetyfirst.phyoekhantzin.net.activities;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import safetyfirst.phyoekhantzin.net.adapters.ViewPagerAdapter;
import saftyfirst.phyoekhantzin.net.safetyfirst.R;

public class TsunamiActivity extends AppCompatActivity {

    // Declare Variables
    ViewPager viewPager;
    PagerAdapter adapter;
    int[] tsunamis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsunami);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        tsunamis = new int[] { R.drawable.tsunami1, R.drawable.tsunami2,
                R.drawable.tsunami3, R.drawable.tsunami4,
                R.drawable.tsunami5, R.drawable.tsunami6};
        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager_tsunami);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(this, tsunamis);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);
        ((ViewPager) findViewById(R.id.pager_tsunami)).setAdapter(adapter);

    }
}
