package com.example.rnest.ngirangiracuacajson;

import android.app.VoiceInteractor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText txt_city;
    private Button button;
    private TextView result_id, result_main, result_description, result_icon, result_temp, result_pres, result_hum, result_temp_min, result_temp_max, result_sea, result_gnd;
    private RequestQueue requestQueue;
    private ImageView imageIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button              = (Button) findViewById(R.id.button);
        requestQueue        = Volley.newRequestQueue(this);
        txt_city            = (EditText) findViewById(R.id.txt_city);
        result_id           = (TextView) findViewById(R.id.result_id);
        result_main         = (TextView) findViewById(R.id.result_main);
        result_description  = (TextView) findViewById(R.id.result_description);
        result_icon         = (TextView) findViewById(R.id.result_icon);

        result_temp         = (TextView) findViewById(R.id.result_temp);
        result_pres         = (TextView) findViewById(R.id.result_pres);
        result_hum          = (TextView) findViewById(R.id.result_hum);
        result_temp_min     = (TextView) findViewById(R.id.result_temp_min);
        result_temp_max     = (TextView) findViewById(R.id.result_temp_max);
        result_sea          = (TextView) findViewById(R.id.result_sea);
        result_gnd          = (TextView) findViewById(R.id.result_gnd);
        imageIcon           = (ImageView) findViewById(R.id.imageIcon);
    }

    public void loadweather(View view){
        final String uri = Uri.parse("http://api.openweathermap.org/data/2.5/weather")
                .buildUpon()
                .appendQueryParameter("q",txt_city.getText().toString())
                .appendQueryParameter("appid", "0d4cf99adbefa02ffb56cd3920a4bb43")
                .toString();

        final JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET, uri, null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response){
                try{
                    final String tmp_id = response.getJSONArray("weather").getJSONObject(0).getString("id");
                    final String tmp_main = response.getJSONArray("weather").getJSONObject(0).getString("main");
                    final String tmp_description = response.getJSONArray("weather").getJSONObject(0).getString("description");
                    final String tmp_icon = response.getJSONArray("weather").getJSONObject(0).getString("icon");

                    final String tmp_temp = response.getJSONObject("main").getString("temp");
                    final String tmp_pres = response.getJSONObject("main").getString("pressure");
                    final String tmp_hum = response.getJSONObject("main").getString("humidity");

                    final String tmp_temp_min = response.getJSONObject("main").getString("temp_min");
                    final String tmp_temp_max = response.getJSONObject("main").getString("temp_max");

                    //final String tmp_sea = response.getJSONObject("main").getString("sea_level");
                    //final String tmp_gnd = response.getJSONObject("main").getString("grnd_level");

                    result_id.setText(tmp_id);
                    result_main.setText(tmp_main);
                    result_description.setText(tmp_description);
                    result_icon.setText(tmp_icon);

                    result_temp.setText(tmp_temp);
                    result_pres.setText(tmp_pres);
                    result_hum.setText(tmp_hum);
                    result_temp_min.setText(tmp_temp_min);
                    result_temp_max.setText(tmp_temp_max);
                    //result_sea.setText(tmp_sea);
                    //result_gnd.setText(tmp_gnd);

                    Map<String, Integer> iconMap = new HashMap<>();
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

                    final Integer drawableId = iconMap.get(tmp_icon);
                    //Log.i(TAG, "Icon ID" + iconId + "-> Drawable ID" + drawableId);
                    imageIcon.setImageResource(drawableId);

                } catch(JSONException e) {
                    Log.e("MainAcivity", "JSON ERROR");
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse (VolleyError error){
                Log.e("MainActivity", "HTTP error");
            }
        });
        requestQueue.add(jsonReq);
    }
}
