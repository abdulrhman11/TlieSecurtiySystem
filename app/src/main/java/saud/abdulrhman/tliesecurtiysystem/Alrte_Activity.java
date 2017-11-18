package saud.abdulrhman.tliesecurtiysystem;

import android.app.LauncherActivity;
import android.app.ProgressDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Alrte_Activity extends AppCompatActivity {

    private static final String URL_DATA = "http://tilesecurity.xyz/loginApp/AlertList.php";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<arteList> AlrteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alrte_);

        recyclerView =(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AlrteList = new ArrayList<>();

        loadRecyclerViewData();



    }

    private void loadRecyclerViewData(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loding...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();

                try {
                    JSONArray Alert = new JSONArray(response);

                    for(int i=0;i<Alert.length();i++){

                        JSONObject alertobject = Alert.getJSONObject(i);

                        String alert = alertobject.getString("alert");
                        String time = alertobject.getString("time");

                        arteList ArteListt = new arteList(alert,time);
                        AlrteList.add(ArteListt);


                    }

                    adapter = new myAdpter(AlrteList,getApplicationContext());
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Alrte_Activity.this);
                        builder.setMessage(" Failed")
                                .setNegativeButton("Retry",null)
                                .create()
                                .show();


                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
