package com.example.hp_pc.quakereport;

/**
 * Created by HP-PC on 8/10/2017.
 */

class EarthQuakeInfo {


    private  String mUrl;
    /** Magnitude of the earthquake
     *
     */
    private double mMagnitude;

    /** Location of the earthquake
     *
     */
    private String mLocation  ;

    /** Date of the earthquake
     *
     */
    private long mTimeInMilliseconds;




    /**
     * Create a new Word object.
     *
     * param Magnitude is the size of the earthquake
     * param Location is where the earthquake occured
     * param Date is the day that the earthquake happened
     */

    public EarthQuakeInfo(double Magnitude, String Location, long TimeInMilliseconds, String url) {
        mMagnitude = Magnitude;

        mLocation = Location;
        mTimeInMilliseconds = TimeInMilliseconds;
        mUrl = url;;

    }



    /** Returns the magnitude of the earthquake
     *
     */
    public double getMagnitude() {return mMagnitude;}

    /** Returns the location of the earthquake
     *
     */
    public String getLocation() {return mLocation;}

    /** Returns the magnitude of the earthquake
     *
     */
    public long getmTimeInMilliseconds() {return mTimeInMilliseconds;}
    public String getUrl(){return mUrl  ;}

}
