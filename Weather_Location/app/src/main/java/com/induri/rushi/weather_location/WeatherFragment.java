package com.induri.rushi.weather_location;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Date;

/**
 * Created by Sony on 09-03-2016.
 */
public class WeatherFragment extends Fragment {
    String code;
    String country;
    String city;
    TextView cityText;
    TextView countryText;
    TextView zipText;
    recycleradapter adapter;
    RecyclerView rv;
    ProgressDialog progressDialog;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setRetainInstance(true);
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        new myasynctask().execute();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    protected class myasynctask extends AsyncTask<Void, Void, List<Weather>> {

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setIndeterminate(true);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMessage("Loading the weather Data");
            progressDialog.show();
        }

        @Override
        protected List<Weather> doInBackground(Void... params) {
            double lat = 0;
            double lon = 0;
            try {
                LocationManager lm = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);

                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                }
                Location loc = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                if (loc ==null){
                    return null;
                }
                lat = loc.getLatitude();
                lon = loc.getLongitude();

                Geocoder geocoder;
                List<Address> addresses;
                geocoder = new Geocoder(getContext(), Locale.getDefault());
                addresses = geocoder.getFromLocation(lat,lon,5);
                Log.d("Tag",""+addresses.size());
                code=addresses.get(0).getPostalCode();
                Log.d("Tag",""+code);

            }
            catch (Exception e){
                return null;
            }
            List<Weather> weatherList=new ArrayList<Weather>();
            String temp=null;
            HttpURLConnection conn = null;
            BufferedReader reader=null;
            try {

                URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?lat="+lat+"&lon="+lon+"&cnt=10&APPID=7b2366dd5335c041b021f482eb8fc9d2");
                conn = (HttpURLConnection) url.openConnection();
                Log.d("TAG1","Fianl JSON object");
                InputStream stream = conn.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buff = new StringBuffer();

                String line = "";
                while((line=reader.readLine())!= null){
                    buff.append(line);
                }

                String finalJson = buff.toString();

                JSONObject jo = new JSONObject(finalJson);
                JSONObject co = jo.getJSONObject("city");
                String city1 = co.getString("name");
                city = city1;

                String country1 = co.getString("country");
                country = country1;

                for (int i=0;i<10;i++){
                    Weather w = new Weather();
                    JSONArray ja = jo.getJSONArray("list");
                    JSONObject listobject = ja.getJSONObject(i);
                    String date = listobject.getString("dt");
                    JSONObject tempjo = listobject.getJSONObject("temp");
                    String dayTemp = tempjo.getString("day");
                    String minTemp = tempjo.getString("min");
                    String maxTemp = tempjo.getString("max");
                    long date2 = (Long.valueOf(date).longValue());
                    Date date1 = new Date(date2*1000);
                    Log.d("Date",""+date1);
                    w.date = ""+date1;
                    w.dayTemp = dayTemp;
                    w.maxTemp = maxTemp;
                    w.minTemp = minTemp;
                    weatherList.add(w);
                }

                Log.d("weather",""+weatherList);

                String count = jo.getString("cnt");
                Log.d("count",""+count);

            }
            catch ( Exception e){
                Toast.makeText(getContext(),"Please check Int connection",Toast.LENGTH_LONG).show();
                e.printStackTrace();
                return null;
            }
            return weatherList;
        }

        @Override
        protected void onPostExecute(List<Weather> weathers) {
            progressDialog.dismiss();
            if(weathers ==null){
                Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
            }

            cityText.setText(city);
            countryText.setText(country);
            zipText.setText(code);
            rv.setAdapter(new recycleradapter(getContext(),weathers));

            Log.d("Postexecute",""+weathers);
        }
    }
}
