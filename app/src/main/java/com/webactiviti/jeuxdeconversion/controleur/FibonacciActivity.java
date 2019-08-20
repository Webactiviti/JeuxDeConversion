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


import com.webactiviti.jeuxdeconversion.R;
import com.webactiviti.jeuxdeconversion.vue.MDToast;

public class FibonacciActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);

        Button btnCalculFibonacci = findViewById(R.id.btnCalculFibonacci);
        btnCalculFibonacci.setOnClickListener(v -> {
            EditText edtNumeroRang;
            edtNumeroRang = findViewById(R.id.edtNumeroRang);
            afficheResultatFibonacci(""); // reinit l'affichage
            try{
                Integer numRang = Integer.parseInt(edtNumeroRang.getText().toString());
                if (numRang >=0 && numRang <=10){
                    // retire le clavier
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edtNumeroRang.getWindowToken(), 0);
                    calculFibonacci (numRang);
                } else {
                    String mesg ="Le numéro saisie : " +edtNumeroRang.getText()
                            .toString()+"\n n'est pas compris entre 0 et 10";
                    MDToast.makeText (getApplicationContext(),mesg ,
                            MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING).show();
                }

            } catch(NumberFormatException e) {
                String mesg ="Le numéro saisie : " +edtNumeroRang.getText().toString()+"\n n'est pas un entier";
                MDToast.makeText (getApplicationContext(),mesg ,
                        MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show();
            }


        });

        EditText edtNumeroRang = findViewById(R.id.edtNumeroRang);
        edtNumeroRang.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                afficheResultatFibonacci(""); // efface le résultat du calcul
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    void afficheResultatFibonacci (String resultat){
        TextView ttvResultatFibonacci = findViewById(R.id.ttvResultatFibonacci);
        if (resultat.equals("")) ttvResultatFibonacci.setText("");
        else ttvResultatFibonacci.append(resultat+"\n");
    }



    private void calculFibonacci (Integer numRang){
        String retResultat="Rang 0 : 0";
        if (numRang !=0 ) retResultat +="\nRang 1 : 1";
        afficheResultatFibonacci (retResultat);

        if (numRang > 1){


            Integer nbOld =0;
            Integer nbEnCours=1;
            Integer nbNew;

            for(Integer num=2;num <=numRang; num++){
                nbNew =nbOld+ nbEnCours;
                nbOld = nbEnCours;
                nbEnCours = nbNew;

                retResultat = "Rang "+num.toString()+" : "+nbNew.toString();
                afficheResultatFibonacci (retResultat);
            }
        }

    }
}
