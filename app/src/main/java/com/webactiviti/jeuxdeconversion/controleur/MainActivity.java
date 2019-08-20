package com.webactiviti.jeuxdeconversion.controleur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.webactiviti.jeuxdeconversion.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liste des choix

        Button btnChiffreRomain = findViewById(R.id.btnChiffreRomain);
        btnChiffreRomain.setOnClickListener(v -> {
            final Intent intent = new Intent(MainActivity.this, ChiffreRomainActivity.class);
            startActivity(intent);

        });

        Button btnChiffrageRot13 = findViewById(R.id.btnChiffrageROT13);
        btnChiffrageRot13.setOnClickListener(v -> {
            final Intent intent = new Intent(MainActivity.this, Rot13Activity.class);
            startActivity(intent);
        });

        Button btnConvertisseurCF = findViewById(R.id.btnConversionCF);
        btnConvertisseurCF.setOnClickListener(v -> {
            final Intent intent = new Intent(MainActivity.this, CFActivity.class);
            startActivity(intent);
        });

        Button btnFibonacci = findViewById(R.id.btnFibonacci);
        btnFibonacci.setOnClickListener(v -> {
            final Intent intent = new Intent(MainActivity.this, FibonacciActivity.class);
            startActivity(intent);
        });
    }
}
