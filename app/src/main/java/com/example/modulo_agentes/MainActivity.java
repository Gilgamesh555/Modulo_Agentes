package com.example.modulo_agentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadComponents();
    }

    private void loadComponents() {
        Button btadd = findViewById(R.id.btadd);
        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openaddActivity();
            }
        });
        Button btdel = findViewById(R.id.btdel);
        btdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeleteActivity();
            }
        });
    }

    private void openDeleteActivity() {
        Intent intent = new Intent(this, delActivity.class);
        startActivity(intent);
    }

    private void openaddActivity(){
        Intent intent = new Intent(this, addActivity.class);
        startActivity(intent);
    }
}
