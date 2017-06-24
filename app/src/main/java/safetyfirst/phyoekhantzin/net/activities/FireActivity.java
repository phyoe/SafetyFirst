package safetyfirst.phyoekhantzin.net.activities;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import safetyfirst.phyoekhantzin.net.adapters.ViewPagerAdapter;
import saftyfirst.phyoekhantzin.net.safetyfirst.R;

public class FireActivity extends AppCompatActivity {

    // Declare Variables
    ViewPager viewPager;
    PagerAdapter adapter;
    int[] fires;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        fires = new int[] { R.drawable.fire1, R.drawable.fire2,
                R.drawable.fire3, R.drawable.fire4,
                R.drawable.fire5, R.drawable.fire6, R.drawable.fire7, R.drawable.fire8};
        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager_fire);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(this, fires);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);
        ((ViewPager) findViewById(R.id.pager_fire)).setAdapter(adapter);

    }
}
