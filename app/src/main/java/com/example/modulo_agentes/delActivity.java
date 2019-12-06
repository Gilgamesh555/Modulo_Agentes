package com.example.modulo_agentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class delActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del);
        loadComponents();
    }

    private void loadComponents() {
        Button btndel = findViewById(R.id.btneliminar);
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setComp();
                Intent intent = new Intent(delActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setComp() {
        TextView txt1 = findViewById(R.id.name);
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("username", txt1.getText().toString());
        client.delete(Services.AGENTES, params, new JsonHttpResponseHandler());
    }
}
