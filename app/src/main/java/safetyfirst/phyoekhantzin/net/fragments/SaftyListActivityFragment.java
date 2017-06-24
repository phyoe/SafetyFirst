package safetyfirst.phyoekhantzin.net.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import saftyfirst.phyoekhantzin.net.safetyfirst.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class SaftyListActivityFragment extends Fragment {

    public SaftyListActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_safty_list, container, false);
    }
}
