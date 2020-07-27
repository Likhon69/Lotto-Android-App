package com.example.lottoecommrceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class OrderDetails extends AppCompatActivity {
    private static final String TAG = OrderDetails.class.getSimpleName();
    private static final String URL = "http://192.168.5.27/api/ArticleGet/PostData";
    EditText _address,_name;
    private RequestQueue mQueue;
    private int Article_Id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        Intent intent = getIntent();
        int articleId = intent.getIntExtra("ArticleId",0);
        Article_Id = articleId;
        _address = findViewById(R.id.address_id);
        _name = findViewById(R.id.name_id);

        Button _submit = findViewById(R.id.button_submit);

        /*TextView txtArticleId = findViewById(R.id.order_txt_id);
        txtArticleId.setText(Integer.toString(articleId));*/

        _submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            postData();
            }
        });
    }

    private void postData(){
        // Optional Parameters to pass as POST request
        JSONObject js = new JSONObject();
        try {
            js.put("articleDetails_Id",Article_Id);
            js.put("address",_address.getText().toString());
            js.put("name",_name.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Make request for JSONObject
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.POST, URL, js,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString() + " i am queen");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        }) {

            /**
             * Passing some request headers
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }

        };
        RequestQueue Queue = Volley.newRequestQueue(this);
        Queue.add(jsonObjReq);
        Toast.makeText(getApplicationContext(),"Succesfully!",Toast.LENGTH_LONG).show();
    }
}
