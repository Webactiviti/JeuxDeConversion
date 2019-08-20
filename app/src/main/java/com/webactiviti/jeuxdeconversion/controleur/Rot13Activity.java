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

import com.webactiviti.jeuxdeconversion.model.ConversionRot13;
import com.webactiviti.jeuxdeconversion.R;

public class Rot13Activity extends AppCompatActivity {
    private EditText edtTexteNormal;
    private EditText edtResultatRot13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rot13);

        edtTexteNormal = findViewById(R.id.edtTexteNormal);
        edtResultatRot13 = findViewById(R.id.edtResultatRot13);



        Button btnConvertirRot13 = findViewById(R.id.btnConvertirRot13);

        btnConvertirRot13.setOnClickListener(v -> {
            ConversionRot13 conversionRot13 = new ConversionRot13();
            edtResultatRot13.setText(conversionRot13.conversionTexte(edtTexteNormal.getText().toString()));
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(edtTexteNormal.getWindowToken(), 0);



        });

        edtTexteNormal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                edtResultatRot13.setText("");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }
}
