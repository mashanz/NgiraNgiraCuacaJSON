package com.example.rnest.ngirangiracuacajson;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOError;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText txt_city;
    private Button button;
    private TextView result_id, result_main, result_description, result_icon, result_temp, result_pres, result_hum;
    private RequestQueue requestQueue;
    private ImageView imageIcon;
    private String tmpo_id, tmpo_main, tmpo_description, tmpo_icon, tmpo_temp, tmpo_pres, tmpo_hum, tmpo_city;
    private Integer tmpo_imageIcon;
    public static final String TAG = "MainActivity";
    private Map<String, Integer> iconMap = new HashMap<>();
    private FusedLocationProviderClient mLoc;
    private Array loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoc = LocationServices.getFusedLocationProviderClient(this);

        Log.i(TAG, "ambil element by id");
        button = (Button) findViewById(R.id.button);
        requestQueue = Volley.newRequestQueue(this);
        txt_city = (EditText) findViewById(R.id.txt_city);
        result_id = (TextView) findViewById(R.id.result_id);
        result_main = (TextView) findViewById(R.id.result_main);
        result_description = (TextView) findViewById(R.id.result_description);
        result_icon = (TextView) findViewById(R.id.result_icon);
        result_temp = (TextView) findViewById(R.id.result_temp);
        result_pres = (TextView) findViewById(R.id.result_pres);
        result_hum = (TextView) findViewById(R.id.result_hum);
        imageIcon = (ImageView) findViewById(R.id.imageIcon);

        Log.i(TAG, "Mapping icon icon");
        iconMap.put("00d", R.drawable.i00);
        iconMap.put("01d", R.drawable.i01);
        iconMap.put("02d", R.drawable.i02);
        iconMap.put("03d", R.drawable.i03);
        iconMap.put("04d", R.drawable.i04);
        iconMap.put("05d", R.drawable.i05);
        iconMap.put("06d", R.drawable.i06);
        iconMap.put("07d", R.drawable.i07);
        iconMap.put("08d", R.drawable.i08);
        iconMap.put("09d", R.drawable.i09);
        iconMap.put("10d", R.drawable.i10);
        iconMap.put("11d", R.drawable.i11);
        iconMap.put("12d", R.drawable.i12);
        iconMap.put("13d", R.drawable.i13);
        iconMap.put("14d", R.drawable.i14);
        iconMap.put("15d", R.drawable.i15);
        iconMap.put("16d", R.drawable.i16);
        iconMap.put("17d", R.drawable.i17);
        iconMap.put("18d", R.drawable.i18);
        iconMap.put("19d", R.drawable.i19);
        iconMap.put("20d", R.drawable.i20);
        iconMap.put("21d", R.drawable.i21);
        iconMap.put("22d", R.drawable.i22);
        iconMap.put("23d", R.drawable.i23);
        iconMap.put("24d", R.drawable.i24);
        iconMap.put("25d", R.drawable.i25);
        iconMap.put("26d", R.drawable.i26);
        iconMap.put("27d", R.drawable.i27);
        iconMap.put("28d", R.drawable.i28);
        iconMap.put("29d", R.drawable.i29);
        iconMap.put("30d", R.drawable.i30);
        iconMap.put("31d", R.drawable.i31);
        iconMap.put("32d", R.drawable.i32);
        iconMap.put("33d", R.drawable.i33);
        iconMap.put("34d", R.drawable.i34);
        iconMap.put("35d", R.drawable.i35);
        iconMap.put("36d", R.drawable.i36);
        iconMap.put("37d", R.drawable.i37);
        iconMap.put("38d", R.drawable.i38);
        iconMap.put("39d", R.drawable.i39);
        iconMap.put("40d", R.drawable.i40);
        iconMap.put("41d", R.drawable.i41);
        iconMap.put("42d", R.drawable.i42);
        iconMap.put("43d", R.drawable.i43);
        iconMap.put("44d", R.drawable.i44);
        iconMap.put("45d", R.drawable.i45);
        iconMap.put("46d", R.drawable.i46);
        iconMap.put("47d", R.drawable.i47);
        iconMap.put("nan", R.drawable.nan);
        iconMap.put("backdrop", R.drawable.backdrop);
        iconMap.put("00n", R.drawable.i00);
        iconMap.put("01n", R.drawable.i01);
        iconMap.put("02n", R.drawable.i02);
        iconMap.put("03n", R.drawable.i03);
        iconMap.put("04n", R.drawable.i04);
        iconMap.put("05n", R.drawable.i05);
        iconMap.put("06n", R.drawable.i06);
        iconMap.put("07n", R.drawable.i07);
        iconMap.put("08n", R.drawable.i08);
        iconMap.put("09n", R.drawable.i09);
        iconMap.put("10n", R.drawable.i10);
        iconMap.put("11n", R.drawable.i11);
        iconMap.put("12n", R.drawable.i12);
        iconMap.put("13n", R.drawable.i13);
        iconMap.put("14n", R.drawable.i14);
        iconMap.put("15n", R.drawable.i15);
        iconMap.put("16n", R.drawable.i16);
        iconMap.put("17n", R.drawable.i17);
        iconMap.put("18n", R.drawable.i18);
        iconMap.put("19n", R.drawable.i19);
        iconMap.put("20n", R.drawable.i20);
        iconMap.put("21n", R.drawable.i21);
        iconMap.put("22n", R.drawable.i22);
        iconMap.put("23n", R.drawable.i23);
        iconMap.put("24n", R.drawable.i24);
        iconMap.put("25n", R.drawable.i25);
        iconMap.put("26n", R.drawable.i26);
        iconMap.put("27n", R.drawable.i27);
        iconMap.put("28n", R.drawable.i28);
        iconMap.put("29n", R.drawable.i29);
        iconMap.put("30n", R.drawable.i30);
        iconMap.put("31n", R.drawable.i31);
        iconMap.put("32n", R.drawable.i32);
        iconMap.put("33n", R.drawable.i33);
        iconMap.put("34n", R.drawable.i34);
        iconMap.put("35n", R.drawable.i35);
        iconMap.put("36n", R.drawable.i36);
        iconMap.put("37n", R.drawable.i37);
        iconMap.put("38n", R.drawable.i38);
        iconMap.put("39n", R.drawable.i39);
        iconMap.put("40n", R.drawable.i40);
        iconMap.put("41n", R.drawable.i41);
        iconMap.put("42n", R.drawable.i42);
        iconMap.put("43n", R.drawable.i43);
        iconMap.put("44n", R.drawable.i44);
        iconMap.put("45n", R.drawable.i45);
        iconMap.put("46n", R.drawable.i46);
        iconMap.put("47n", R.drawable.i47);
        Log.i(TAG, "parsing icon");
        final Integer drawableId = iconMap.get("13d");
        Log.i(TAG, "tmp_icon:" + "13d" + " drawableId: " + drawableId);
        imageIcon.setImageResource(drawableId);
        tmpo_imageIcon = drawableId;
    }

    public void loadweather(View view) {
        //TODO: TOAST
        Context context = getApplicationContext();
        CharSequence text = "GET WEATHER FROM "+txt_city.getText().toString();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Log.i(TAG, "loadweather");
        Log.i(TAG, "parsing GET to api");
        final String uri = Uri.parse("http://api.openweathermap.org/data/2.5/weather")
                .buildUpon()
                .appendQueryParameter("q", txt_city.getText().toString())
                .appendQueryParameter("appid", "0d4cf99adbefa02ffb56cd3920a4bb43")
                .toString();
        Log.i(TAG, "pasing JSON element to get Value");
        final JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET, uri, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i(TAG, "JSON onResponse");
                try {
                    Log.i(TAG, "try: JSON onResponse GET all needed element (parsing)");
                    final String tmp_id = response.getJSONArray("weather").getJSONObject(0).getString("id");
                    final String tmp_main = response.getJSONArray("weather").getJSONObject(0).getString("main");
                    final String tmp_description = response.getJSONArray("weather").getJSONObject(0).getString("description");
                    final String tmp_icon = response.getJSONArray("weather").getJSONObject(0).getString("icon");
                    final String tmp_temp = response.getJSONObject("main").getString("temp");
                    final String tmp_pres = response.getJSONObject("main").getString("pressure");
                    final String tmp_hum = response.getJSONObject("main").getString("humidity");

                    Log.i(TAG, "parsing icon");
                    final Integer drawableId = iconMap.get(tmp_icon);
                    Log.i(TAG, "tmp_icon:" + tmp_icon + " drawableId: " + drawableId);

                    Log.i(TAG, "Show result");
                    result_id.setText(tmp_id);
                    result_main.setText(tmp_main);
                    result_description.setText(tmp_description);
                    result_icon.setText(tmp_icon);
                    result_temp.setText(tmp_temp);
                    result_pres.setText(tmp_pres);
                    result_hum.setText(tmp_hum);
                    imageIcon.setImageResource(drawableId);

                    Log.i(TAG, "save result to temp for rotating");
                    tmpo_id = tmp_id;
                    tmpo_main = tmp_main;
                    tmpo_description = tmp_description;
                    tmpo_icon = tmp_icon;
                    tmpo_temp = tmp_temp;
                    tmpo_pres = tmp_pres;
                    tmpo_hum = tmp_hum;
                    tmpo_imageIcon = drawableId;

                } catch (JSONException e) {
                    Log.e("MainAcivity", "JSON ERROR");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("MainActivity", "HTTP error");
            }
        });
        requestQueue.add(jsonReq);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, "store Instace");
        outState.putString("result_id", tmpo_id);
        outState.putString("result_main", tmpo_main);
        outState.putString("result_description", tmpo_description);
        outState.putString("result_icon", tmpo_icon);
        outState.putString("result_temp", tmpo_temp);
        outState.putString("result_pres", tmpo_pres);
        outState.putString("result_hum", tmpo_hum);
        outState.putInt("result_img", tmpo_imageIcon);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(TAG, "restore Instace");
        super.onRestoreInstanceState(savedInstanceState);
        tmpo_id = savedInstanceState.getString("result_id");
        tmpo_main = savedInstanceState.getString("result_main");
        tmpo_description = savedInstanceState.getString("result_description");
        tmpo_icon = savedInstanceState.getString("result_icon");
        tmpo_temp = savedInstanceState.getString("result_temp");
        tmpo_pres = savedInstanceState.getString("result_pres");
        tmpo_hum = savedInstanceState.getString("result_hum");
        tmpo_imageIcon = savedInstanceState.getInt("result_img");

        Log.i(TAG, "show result from rotating");
        result_id.setText(tmpo_id);
        result_main.setText(tmpo_main);
        result_description.setText(tmpo_description);
        result_icon.setText(tmpo_icon);
        result_temp.setText(tmpo_temp);
        result_pres.setText(tmpo_pres);
        result_hum.setText(tmpo_hum);
        imageIcon.setImageResource(tmpo_imageIcon);
    }

    @Override
    protected void onPause() {
        // TODO:
        Log.i(TAG, "menyimpan shared preference" + txt_city.getText().toString() + "ke city" + tmpo_city);
        final SharedPreferences shPref = getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = shPref.edit();
        edit.putString("city", txt_city.getText().toString());
        edit.putString("id", tmpo_id);
        edit.putString("main", tmpo_main);
        edit.putString("description", tmpo_description);
        edit.putString("icon", tmpo_icon);
        edit.putString("temperature", tmpo_temp);
        edit.putString("pressure", tmpo_pres);
        edit.putString("humidity", tmpo_hum);
        edit.putInt("image", tmpo_imageIcon);
        edit.commit();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // TODO:
        Log.i(TAG, "Load to database");
        final SharedPreferences shPref = getPreferences(Context.MODE_PRIVATE);
        tmpo_city = shPref.getString("city", "-");
        tmpo_id = shPref.getString("id", "-");
        tmpo_main = shPref.getString("main", "-");
        tmpo_description = shPref.getString("description", "-");
        tmpo_icon = shPref.getString("icon", "-");
        tmpo_temp = shPref.getString("temperature", "-");
        tmpo_pres = shPref.getString("pressure", "-");
        tmpo_hum = shPref.getString("humidity", "-");
        tmpo_imageIcon = shPref.getInt("image", 13);

        Log.i(TAG, "Show from database");
        txt_city.setText(tmpo_city);
        result_id.setText(tmpo_id);
        result_main.setText(tmpo_main);
        result_description.setText(tmpo_description);
        result_icon.setText(tmpo_icon);
        result_temp.setText(tmpo_temp);
        result_pres.setText(tmpo_pres);
        result_hum.setText(tmpo_hum);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        Log.i(TAG,"Permission ReQuest");
    }

    public void locationFinder(View view) {
        Log.i(TAG,"locationFinder onClick");
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG,"Permission Denied");
            //return;
        }else{
            Log.i(TAG,"Permission Granted");
        }
        Log.i(TAG,"getLastLocation");
        mLoc.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                Log.i(TAG,"Is there location?");
                if (location != null) {
                    //TODO
                    Log.i(TAG,"GOT it Latitude = " + location.getLatitude() + " Longitude = " + location.getLongitude());
                    getLocation(location.getLatitude(),location.getLongitude());
                }
            }
        });
    }

    public void getLocation(Double latitude, Double longitude){
        Log.i(TAG, "Search Location Based LAT="+latitude+" LON="+longitude);
        Log.i(TAG, "loadweather");
        Log.i(TAG, "parsing GET to api");
        final String uri = Uri.parse("http://api.openweathermap.org/data/2.5/weather")
                .buildUpon()
                .appendQueryParameter("lat", String.valueOf(latitude))
                .appendQueryParameter("lon", String.valueOf(longitude))
                .appendQueryParameter("appid", "0d4cf99adbefa02ffb56cd3920a4bb43")
                .toString();
        Log.i(TAG, "pasing JSON element to get Value");
        final JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET, uri, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i(TAG, "JSON onResponse");
                try {
                    Log.i(TAG, "try: JSON onResponse GET all needed element (parsing)");
                    final String myLoc = response.getString("name");
                    Log.i(TAG, myLoc);
                    txt_city.setText(myLoc);

                    Context context = getApplicationContext();
                    CharSequence text = "LOCATION NOW : "+myLoc;
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                } catch (JSONException e) {

                    Context context = getApplicationContext();
                    CharSequence text = "LOCATION : FAILED TO GET LOCATION";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    Log.e("MainAcivity", "JSON ERROR");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("MainActivity", "HTTP error");
            }
        });
        requestQueue.add(jsonReq);
    }
}
