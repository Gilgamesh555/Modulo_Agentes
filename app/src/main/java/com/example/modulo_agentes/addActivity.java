package com.example.modulo_agentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class addActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    static String g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        loadComponents();
    }

    private void loadComponents() {
        Button btnSend = findViewById(R.id.btnsend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callService();
            }
        });
    }

    private void callService() {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        EditText txtname= findViewById(R.id.txtname);
        EditText txtusername = findViewById(R.id.txtusername);
        EditText txtemail= findViewById(R.id.txtemail);
        EditText txtpassword= findViewById(R.id.txtpassword);
        EditText txtdireccion= findViewById(R.id.txtdireccion);
        RadioGroup radioGroup = findViewById(R.id.RgrGenre);
        radioGroup.setOnCheckedChangeListener(this);
        params.add("username", txtusername.getText().toString());
        params.add("name", txtname.getText().toString());
        params.add("email", txtemail.getText().toString());
        params.add("password", txtpassword.getText().toString());
        params.add("sex", g);
        params.add("agent", "true");
        client.post(Services.AGENTES, params, new AsyncHttpResponseHandler() {
           @Override
           public void onSuccess(int statusCode, Header[] headers, byte[] responseBody){
               Toast.makeText(addActivity.this, "Usuario Registrado con Exito", Toast.LENGTH_LONG).show();
               Intent inte = new Intent(addActivity.this, MainActivity.class);
               startActivity(inte);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(addActivity.this, "No se pudo conectar", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        switch (i) {
            case R.id.rB1: g="Varon"; break;
            case R.id.rB2: g="Mujer"; break;
        }
    }
}
