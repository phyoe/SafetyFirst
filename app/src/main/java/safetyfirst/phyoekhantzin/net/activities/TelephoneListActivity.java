package safetyfirst.phyoekhantzin.net.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import safetyfirst.phyoekhantzin.net.data.Phone;
import safetyfirst.phyoekhantzin.net.layout.ListViewLayout;
import saftyfirst.phyoekhantzin.net.safetyfirst.R;

public class TelephoneListActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private static ListViewLayout lstViewActivity;
    private static ListView lstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephone_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_telephone_list, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {

            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
            /**/
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_telephone_list, container, false);
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            int pos = getArguments().getInt(ARG_SECTION_NUMBER);
            //textView.setText("section_label : " + pos);
            //textView.setText(getString(R.string.section_format, pos));


            lstView = (ListView) rootView.findViewById(R.id.list);
            lstViewActivity = new ListViewLayout(getContext(), R.layout.fragment_telephone_list);

            lstView.setAdapter(lstViewActivity);

            List<Phone> lst = readData(pos);
            System.out.print("Size : " + lst.size());

            for(Phone phone : lst){
                lstViewActivity.add(phone);
                System.out.print("Code : " + phone.code);
            }

            return rootView;
        }
        private static List<Phone> readData(int pos) {
            List<Phone> lst = new ArrayList<Phone>();

            //int code, String place, String police, String ambulance, String fire

            Phone[] mm_phone = setMMData();
            Phone[] asia_phone = setAsiaData();

            /**
             * pos 1 : Myanmer Phone
             * pos 2 : Asia Phone
             */
            if(pos == 2){
                for(int i = 0; i < asia_phone.length; i++){
                    lst.add(asia_phone[i]);
                }
            }else{
                for(int i = 0; i < mm_phone.length; i++){
                    lst.add(mm_phone[i]);
                }
            }
            return lst;
        }

        public static Phone[] setMMData(){
            int arr_img[] = setImageView(1);
            Phone[] mm_phone = {
                    new Phone(1, "NayPyiDaw", "067 414224, 067 414226, 067 420106", "067 420683, 067 420096", "067 420005, 067 420025", arr_img[0]),
                    new Phone(2, "Yangon", "199, 01 291284, 01 291285", "192, 01 392029-30", "191, 252011, 252022", arr_img[1]),
                    new Phone(3, "Mandalay", "199, 02 56869, 36982, 39635", "192, 02 39001-5, 02 21499", "191, 02 60738-40", arr_img[2])
            };
            return mm_phone;
        }

        public static Phone[] setAsiaData(){
            int arr_img[] = setImageView(2);
            Phone[] asia_phone = {
                    new Phone(1, "Abkhazia", "102", "103", "101", arr_img[0]),
                    new Phone(2, "Brunei", "993", "991", "995", arr_img[1]),
                    new Phone(3, "Cambodia", "117", "119", "118", arr_img[2]),
                    new Phone(4, "People's Republic of China", "110", "120", "119", arr_img[3]),
                    new Phone(5, "Hong Kong", "999", "999", "999", arr_img[4]),
                    new Phone(6, "Republic of China (Taiwan)", "110", "119", "119", arr_img[5]),
                    new Phone(7, "India", "100", "102", "101", arr_img[6]),
                    new Phone(8, "Indonesia", "110", "118", "113", arr_img[7]),
                    new Phone(9, "Japan", "110", "119", "119", arr_img[8]),
                    new Phone(10, "Republic of Korea", "112", "119", "119", arr_img[9]),
                    new Phone(11, "Democratic People's Republic of Korea", "119", "119", "119", arr_img[10]),
                    new Phone(12, "Laos", "191", "195", "190", arr_img[11]),
                    new Phone(13, "Malaysia", "999", "999", "999", arr_img[12]),
                    new Phone(14, "Myanmar", "199", "192", "191", arr_img[13]),
                    new Phone(15, "Nepal", "100", "102", "101", arr_img[14]),
                    new Phone(16, "Philippines", "117", "117", "117", arr_img[15]),
                    new Phone(17, "Singapore", "999", "995", "995", arr_img[16]),
                    new Phone(18, "Sri Lanka", "119", "110", "110", arr_img[17]),
                    new Phone(19, "Thailand", "911", "1669", "199", arr_img[18]),
                    new Phone(20, "Vietnam", "113", "115", "114", arr_img[19])
            };
            return asia_phone;
        }
        public static int[] setImageView(int pos){
            if(pos == 2) {
                int arr_img[] = {
                    R.drawable.flag_of_abkhazia,
                    R.drawable.flag_of_brunei,
                    R.drawable.flag_of_cambodia,
                    R.drawable.flag_of_the_people_republic_of_china,
                    R.drawable.flag_of_hong_kong,
                    R.drawable.flag_the_republic_of_china,
                    R.drawable.flag_of_india,
                    R.drawable.flag_of_indonesia,
                    R.drawable.flag_of_japan,
                    R.drawable.flag_of_south_korea,
                    R.drawable.flag_of_north_korea,
                    R.drawable.flag_of_laos,
                    R.drawable.flag_of_malaysia,
                    R.drawable.flag_of_myanmar,
                    R.drawable.flag_of_nepal,
                    R.drawable.flag_of_the_philippines,
                    R.drawable.flag_of_singapore,
                    R.drawable.flag_of_sri_lanka,
                    R.drawable.flag_of_thailand,
                    R.drawable.flag_of_vietnam
                };
                return arr_img;
            }else{
                int arr_img[] = {
                    R.drawable.flag_naypyidaw,
                    R.drawable.flag_yangon,
                    R.drawable.flag_mandalay
                };
                return arr_img;
            }
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "MYANMAR";
                case 1:
                    return "ASIA";
            }
            return null;
        }
    }
}
