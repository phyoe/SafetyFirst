package safetyfirst.phyoekhantzin.net.activities;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import safetyfirst.phyoekhantzin.net.adapters.ViewPagerAdapter;
import saftyfirst.phyoekhantzin.net.safetyfirst.R;

public class LightningActivity extends AppCompatActivity {

    // Declare Variables
    ViewPager viewPager1;
    PagerAdapter adapter1;
    ViewPager viewPager2;
    PagerAdapter adapter2;
    int[] indoors;
    int[] outdoors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lightning);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        indoors = new int[] { R.drawable.lightning_indoor1, R.drawable.lightning_indoor2,
                R.drawable.lightning_indoor3, R.drawable.lightning_indoor4,
                R.drawable.lightning_indoor5, R.drawable.lightning_indoor6, R.drawable.lightning_indoor7};

        outdoors = new int[] { R.drawable.lightning_outdoor1, R.drawable.lightning_outdoor2,
                R.drawable.lightning_outdoor3, R.drawable.lightning_outdoor4,
                R.drawable.lightning_outdoor5, R.drawable.lightning_outdoor6,
                R.drawable.lightning_outdoor7, R.drawable.lightning_outdoor8,
                R.drawable.lightning_outdoor9, R.drawable.lightning_outdoor10,
                R.drawable.lightning_outdoor11
        };

        // Locate the ViewPager in viewpager_main.xml
        viewPager1 = (ViewPager) findViewById(R.id.pager_lightning_indoor);
        // Pass results to ViewPagerAdapter Class
        adapter1 = new ViewPagerAdapter(this, indoors);
        // Binds the Adapter to the ViewPager
        viewPager1.setAdapter(adapter1);
        ((ViewPager) findViewById(R.id.pager_lightning_indoor)).setAdapter(adapter1);

        // Locate the ViewPager in viewpager_main.xml
        viewPager2 = (ViewPager) findViewById(R.id.pager_lightning_outdoor);
        // Pass results to ViewPagerAdapter Class
        adapter2 = new ViewPagerAdapter(this, outdoors);
        // Binds the Adapter to the ViewPager
        viewPager2.setAdapter(adapter2);
        ((ViewPager) findViewById(R.id.pager_lightning_outdoor)).setAdapter(adapter2);
    }
}
