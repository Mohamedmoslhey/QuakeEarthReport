package com.example.hp_pc.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP-PC on 8/20/2017.
 */

public class EarthQuakeInfoLoader extends AsyncTaskLoader<List<EarthQuakeInfo>> {

    private static final String LOG_TAG = EarthQuakeInfoLoader.class.getName();

    /** Query URL */
    private String mUrl;

    public EarthQuakeInfoLoader(Context context , String url) {
        super(context);
        mUrl = url ;
    }
    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<EarthQuakeInfo> loadInBackground() {
        if(mUrl == null){
            return  null;
        }
        List<EarthQuakeInfo> earthquakesw = QueryUtil.fetchEarthquakeData(mUrl);
        return earthquakesw;
    }
}
