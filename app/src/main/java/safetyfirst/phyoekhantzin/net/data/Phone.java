package safetyfirst.phyoekhantzin.net.data;

import java.util.List;

/**
 * Created by User on 3/10/2016.
 */
public class Phone {

    public int code;
    public String place;
    public String police;
    public String ambulance;
    public String fire;
    public int imgId;

    public Phone(int code, String place, String police, String ambulance, String fire, int imgId){
        this.code = code;
        this.place = place;
        this.police = police;
        this.ambulance = ambulance;
        this.fire = fire;
        this.imgId = imgId;
    }
}
