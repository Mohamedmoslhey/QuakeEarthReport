package com.example.hp_pc.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by HP-PC on 8/10/2017.
 */


    public class EarthQuakeAdapter extends ArrayAdapter<EarthQuakeInfo> {
        String primaryLocation;
        String locationOffset;
        private static final String LOCATION_SEPARATOR = " of ";



        public EarthQuakeAdapter(Context context, ArrayList<EarthQuakeInfo> EarthQuakeInfo) {
            super(context, 0, EarthQuakeInfo);
        }
        @Override
        public View getView(int position, View convertView,  ViewGroup parent) {

            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item, parent, false);}
            EarthQuakeInfo currentEarthQuakeInfo = getItem(position);

            DecimalFormat formatter = new DecimalFormat("0.00");
            TextView fakeNumberTextView = (TextView) listItemView.findViewById(R.id.Magnitude);
            String output = formatter.format(currentEarthQuakeInfo.getMagnitude());
            fakeNumberTextView.setText(output);
            GradientDrawable magnitudeCircle = (GradientDrawable) fakeNumberTextView.getBackground();
            int magnitudeColour =  getmCircleColour(currentEarthQuakeInfo.getMagnitude());
            magnitudeCircle.setColor(magnitudeColour);

            String originalLocation =  currentEarthQuakeInfo.getLocation();
            if (originalLocation.contains(LOCATION_SEPARATOR)) {
                String[] parts = originalLocation.split(LOCATION_SEPARATOR);
                locationOffset = parts[0] + LOCATION_SEPARATOR;
                primaryLocation = parts[1];
            } else {
                locationOffset = getContext().getString(R.string.NEAR_THE);
                primaryLocation = originalLocation;
            }
            TextView offestPlace = (TextView) listItemView.findViewById(R.id.location_offset);
            offestPlace.setText(primaryLocation);

            TextView primaryPlace = (TextView) listItemView.findViewById(R.id.primary_location);
            primaryPlace.setText(locationOffset);


            Date dateObject = new Date(currentEarthQuakeInfo.getmTimeInMilliseconds());
            TextView dateView = (TextView) listItemView.findViewById(R.id.date);
            // Format the date string (i.e. "Mar 3, 1984")
            String formattedDate = formatDate(dateObject);
            // Display the date of the current earthquake in that TextView
            dateView.setText(formattedDate);

            // Find the TextView with view ID time
            TextView timeView = (TextView) listItemView.findViewById(R.id.time);
            // Format the time string (i.e. "4:30PM")
            String formattedTime = formatTime(dateObject);
            // Display the time of the current earthquake in that TextView
            timeView.setText(formattedTime);




            return listItemView;
        }

        /**
         * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
         * @param magnitude
         */
        public  int getmCircleColour(double magnitude){
            int magnitudeByResId;
            int magnuitudeFl = (int) Math.floor(magnitude);
            switch(magnuitudeFl) {
                case 0:
                case 1:
                    magnitudeByResId = R.color.magnitude1;
                    break;
                case 2:
                    magnitudeByResId = R.color.magnitude2;
                    break;
                case 3:
                    magnitudeByResId = R.color.magnitude3;
                    break;
                case 4:
                    magnitudeByResId = R.color.magnitude4;
                    break;
                case 5:
                    magnitudeByResId = R.color.magnitude5;
                    break;
                case 6:
                    magnitudeByResId = R.color.magnitude6;
                    break;
                case 7:
                    magnitudeByResId = R.color.magnitude7;
                    break;
                case 8:
                    magnitudeByResId = R.color.magnitude8;
                    break;
                case 9:
                    magnitudeByResId = R.color.magnitude9;
                    break;
                default:
                    magnitudeByResId = R.color.magnitude10plus;
                    break;
            }
            return ContextCompat.getColor(getContext(), magnitudeByResId);
        }

        private String formatDate(Date dateObject) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
            return dateFormat.format(dateObject);
        }

        /**
         * Return the formatted date string (i.e. "4:30 PM") from a Date object.
         */
        private String formatTime(Date dateObject) {
            SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
            return timeFormat.format(dateObject);
        }
}
