package com.webactiviti.jeuxdeconversion.controleur;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.webactiviti.jeuxdeconversion.R;
import com.webactiviti.jeuxdeconversion.vue.MDToast;

import java.text.DecimalFormat;

public class CFActivity extends AppCompatActivity {
    private EditText edtCelcius ;
    private EditText edtFahrenheit ;
    private Button btnCelcius ;
    private Button btnFahrenheit ;
    private Button btnNewCalcul ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cf);

        edtCelcius = findViewById(R.id.edtCelcius);
        edtFahrenheit = findViewById(R.id.edtFahrenheit);
        effaceCalcul();

        btnCelcius = findViewById(R.id.btnCelcius);
        btnFahrenheit = findViewById(R.id.btnFahrenheit);
        btnNewCalcul = findViewById(R.id.btnNewCalcul);
        reinitButton(0);


        // Reinit un nouveau calcul
        btnNewCalcul.setOnClickListener(v -> {
            effaceCalcul();
            reinitButton(0);
        });

        // Conversion Celcius en Fahrenheit
        btnCelcius.setOnClickListener(v -> {

            // retire le clavier
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(edtCelcius.getWindowToken(), 0);
            try {

                Float celcius  = Float.parseFloat(edtCelcius.getText().toString());

                Float fahrenheit = (celcius * 1.8F) + 32.0F ;

                DecimalFormat decimalF = new DecimalFormat("#0.00");
                edtFahrenheit.setText( decimalF.format(fahrenheit));
                reinitButton(1);

            } catch(NumberFormatException e) {
                String mesg ="Erreur saisie : " +edtCelcius.getText().toString();
                MDToast.makeText (getApplicationContext(),mesg ,
                        MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING).show();
            }
        });


        //conversion Fahranheit en Celcius
        btnFahrenheit.setOnClickListener(v -> {
            // retire le clavier
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(edtFahrenheit.getWindowToken(), 0);
            try {
                Float fahrenheit = Float.parseFloat(edtFahrenheit.getText().toString());

                Float celcius = (fahrenheit -32F) / 1.8F ;
                DecimalFormat decimalC = new DecimalFormat("#0.00");

                edtCelcius.setText(decimalC.format(celcius));
                reinitButton(1);

            } catch(NumberFormatException e) {
            String mesg ="Erreur saisie : " +edtFahrenheit.getText().toString();
            MDToast.makeText (getApplicationContext(),mesg ,
                    MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING).show();
        }
        });

    }
    // reinit calcul
    private void effaceCalcul(){
        edtCelcius.setText("");
        edtFahrenheit.setText("");
    }

    // Init button et valeurs saisies
    private void reinitButton (Integer choix){
        btnCelcius.setEnabled(false);
        btnFahrenheit.setEnabled(false);
        btnNewCalcul.setEnabled(false);
        edtCelcius.setEnabled(false);
        edtFahrenheit.setEnabled(false);

        switch(choix){
            case 0: // début
                btnCelcius.setEnabled(true);
                btnFahrenheit.setEnabled(true);
                edtCelcius.setEnabled(true);
                edtFahrenheit.setEnabled(true);
                break;

            case 1 : // calcul fait
                btnNewCalcul.setEnabled(true);
                break;
        }

    }

}
