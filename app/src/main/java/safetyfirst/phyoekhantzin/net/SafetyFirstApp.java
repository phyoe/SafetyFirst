package safetyfirst.phyoekhantzin.net;

import android.app.Application;
import android.content.Context;

/**
 * Created by User on 3/2/2016.
 */
public class SafetyFirstApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        //DataManager.getInstance().loadEventList();
    }

    public static Context getContext() {
        return context;
    }
}
