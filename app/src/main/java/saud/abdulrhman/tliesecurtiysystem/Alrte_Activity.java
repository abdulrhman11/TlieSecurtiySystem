package saud.abdulrhman.tliesecurtiysystem;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


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

public class Alrte_Activity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    private static final String URL_DATA = "http://tilesecurity.xyz/loginApp/AlertList.php";
    private RecyclerView recyclerView;
    private myAdpter adapter;

    private List<arteList> AlrteList = new ArrayList<>();


    public SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alrte_);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        swipeRefreshLayout =(SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);

        if (savedInstanceState != null){
            AlrteList = savedInstanceState.getParcelableArrayList("AlrteList");
            adapter = new myAdpter(AlrteList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);

        }else {


            loadRecyclerViewData();
        }



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

                         swipeRefreshLayout.setRefreshing(true);

                    }

                    adapter = new myAdpter(AlrteList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(Alrte_Activity.this));
                    recyclerView.setAdapter(adapter);
                    swipeRefreshLayout.setRefreshing(false);
                } catch (JSONException e) {

                    swipeRefreshLayout.setRefreshing(false);
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



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("AlrteList", (ArrayList<? extends Parcelable>) AlrteList);

    }

    @Override
    public void onRefresh() {

        loadRecyclerViewData();

    }
}
