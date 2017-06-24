package safetyfirst.phyoekhantzin.net.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import safetyfirst.phyoekhantzin.net.adapters.ViewPagerAdapter;
import saftyfirst.phyoekhantzin.net.safetyfirst.R;

public class FloodActivity extends AppCompatActivity {

    // Declare Variables
    ViewPager viewPager;
    PagerAdapter adapter;
    int[] floods;

    LinearLayout flood_content1;
    LinearLayout flood_content2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flood);


        floods = new int[] { R.drawable.flood1, R.drawable.flood2,
                R.drawable.flood3, R.drawable.flood4,
                R.drawable.flood5, R.drawable.flood6, R.drawable.flood7, R.drawable.flood8};
        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager_flood);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(this, floods);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);
        ((ViewPager) findViewById(R.id.pager_flood)).setAdapter(adapter);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        flood_content1 = (LinearLayout) findViewById(R.id.flood_content1);
        flood_content2 = (LinearLayout) findViewById(R.id.flood_content2);
        // hide until its title is clicked
        flood_content1.setVisibility(View.VISIBLE);
        flood_content2.setVisibility(View.GONE);
    }
    /**
     * onClick handler
     */
    public void toggle_contents1(View v){

        flood_content1.setVisibility( flood_content1.isShown()
                ? View.GONE
                : View.VISIBLE );
    }
    public void toggle_contents2(View v){

        flood_content2.setVisibility( flood_content2.isShown()
                ? View.GONE
                : View.VISIBLE );
    }
}
