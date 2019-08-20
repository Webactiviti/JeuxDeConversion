package com.webactiviti.jeuxdeconversion.controleur;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.webactiviti.jeuxdeconversion.model.ConversionNombreEnRomain;
import com.webactiviti.jeuxdeconversion.vue.MDToast;
import com.webactiviti.jeuxdeconversion.R;

public class ChiffreRomainActivity extends AppCompatActivity {
    private EditText edtNombre;
    private TextView ttvResultat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chiffre_romain);
        edtNombre =  findViewById(R.id.edtNombre);
        ttvResultat = findViewById(R.id.ttvResultat);


        // efface le résultat si changement de saisie de nombre
        edtNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                ttvResultat.setText("");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        // Conversion des chiffres saisies en nombre romain
        Button btnConversion = findViewById(R.id.btnConvertir);
        btnConversion.setOnClickListener(v -> {
            ttvResultat.setText("");
            // retire le clavier
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(edtNombre.getWindowToken(), 0);

            String chiffreRomain;
            try {
                Integer nombre = Integer.parseInt(edtNombre.getText().toString());
                if (nombre < 5000){
                    ConversionNombreEnRomain conversionNombreEnRomain= new  ConversionNombreEnRomain();
                    chiffreRomain = conversionNombreEnRomain.calculRomain (nombre);
                    ttvResultat.setText(chiffreRomain);
                } else {
                    String mesg ="Le numéro saisie : " +edtNombre.getText().toString()+"\n est supérieur à 4999";
                    MDToast.makeText (getApplicationContext(),mesg ,
                            MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING).show();
                }

            } catch(NumberFormatException e) {
                String mesg ="Le numéro saisie : " +edtNombre.getText().toString()+"\n n'est pas un entier";
                MDToast.makeText (getApplicationContext(),mesg ,
                        MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show();

            }



        });
    }
}
