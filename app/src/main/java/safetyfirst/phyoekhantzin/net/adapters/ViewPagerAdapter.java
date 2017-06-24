package safetyfirst.phyoekhantzin.net.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import saftyfirst.phyoekhantzin.net.safetyfirst.R;

public class ViewPagerAdapter extends PagerAdapter {
    // Declare Variables
    Context context;
    int[] flag;
    LayoutInflater inflater;

    public ViewPagerAdapter(Context context, int[] flag) {
        this.context = context;
        this.flag = flag;
    }

    @Override
    public int getCount() {
        return flag.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((CardView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables
        ImageView iv_image;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_earthquake_item, container,
                false);

             // Locate the ImageView in viewpager_earthquakes_itemhquakes_item.xml
        iv_image = (ImageView) itemView.findViewById(R.id.iv_image);
        // Capture position and set to the ImageView
        iv_image.setImageResource(flag[position]);

        // Add viewpager_earthquakes_itemhquakes_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_earthquake_item.xmlkes_item.xml from ViewPager
        ((ViewPager) container).removeView((CardView) object);

    }
}
