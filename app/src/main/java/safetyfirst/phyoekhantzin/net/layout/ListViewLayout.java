package safetyfirst.phyoekhantzin.net.layout;

import android.content.Context;
import android.graphics.Typeface;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import safetyfirst.phyoekhantzin.net.data.Phone;
import saftyfirst.phyoekhantzin.net.safetyfirst.R;

/**
 * Created by User on 3/10/2016.
 */
public class ListViewLayout extends ArrayAdapter<Phone> {
    public ListViewLayout(Context context, int resource) {
        super(context, resource);
    }

    public ListViewLayout(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public ListViewLayout(Context context, int resource, Phone[] objects) {
        super(context, resource, objects);
    }

    public ListViewLayout(Context context, int resource, int textViewResourceId, Phone[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public ListViewLayout(Context context, int resource, List<Phone> objects) {
        super(context, resource, objects);
    }

    public ListViewLayout(Context context, int resource, int textViewResourceId, List<Phone> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public void add(Phone object) {
        super.add(object);
    }

    @Override
    public Phone getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fragment_telephone_item, null);
        }

        Phone phone = (Phone) getItem(position);

        ImageView iv_country = (ImageView) convertView.findViewById(R.id.iv_country);
        iv_country.setImageDrawable(convertView.getResources().getDrawable(phone.imgId));


        TextView tv_code = (TextView) convertView.findViewById(R.id.tv_code);
        TextView tv_place = (TextView) convertView.findViewById(R.id.tv_place);
        TextView tv_police = (TextView) convertView.findViewById(R.id.tv_police);
        TextView tv_ambulance = (TextView) convertView.findViewById(R.id.tv_ambulance);
        TextView tv_fire = (TextView) convertView.findViewById(R.id.tv_fire);

        tv_code.setText("" + phone.code + "");
        tv_place.setText("" + phone.place + "");
        tv_police.setText("" + phone.police + "");
        tv_ambulance.setText("" + phone.ambulance + "");
        tv_fire.setText("" + phone.fire + "");

        return convertView;
    }
}
