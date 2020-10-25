package com.example.lottoecommrceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import com.example.lottoecommrceapp.article.ArticleVariant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class OrderDetails extends AppCompatActivity {
    private static final String TAG = OrderDetails.class.getSimpleName();
    private static final String URL = "http://192.168.5.27/api/ArticleGet/PostData";
    private static final String URL_VARIANT = "http://192.168.5.27/api/ArticleGet/GetArticleVarianListByID/";
    EditText _address,_name;
    private RequestQueue mQueue;
    private int Article_Id;
    int articlePriceStandard;
    int newValueQuantity;
    ArticleVariant[] articleVariant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        Intent intent = getIntent();
        int articleId = intent.getIntExtra("ArticleId",0);
        int articlePrice = intent.getIntExtra("Article_Standard_Price",0);
        getSize(articleId);
        Article_Id = articleId;
        articlePriceStandard = articlePrice;
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

        ElegantNumberButton btn_elegant = findViewById(R.id.number_button);
        btn_elegant.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {

            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                Log.d(TAG, String.format("oldValue: %d   newValue: %d", oldValue, newValue));
                newValueQuantity = newValue;
                totalPrice(newValueQuantity);
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

    }
    private void totalPrice(int quantity){
        TextView totalPrice = findViewById(R.id.total_price);
        totalPrice.setText(Integer.toString(quantity*articlePriceStandard));
    }
    private void getSize(int id){
        StringRequest request = new StringRequest(Request.Method.GET,URL_VARIANT+id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Successfully signed in variant response : " + response.toString());
                GsonBuilder gsonbuilder = new GsonBuilder();
                Gson gson = gsonbuilder.create();

                articleVariant = gson.fromJson(response, ArticleVariant[].class);

                showSize(articleVariant);




            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue Queue = Volley.newRequestQueue(this);
        Queue.add(request);
    }

    private void showSize(ArticleVariant[] articleVariant){
        Spinner spinner = findViewById(R.id.show_size);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,articleVariant);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
