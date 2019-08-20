package com.webactiviti.jeuxdeconversion.model;

import android.util.Log;

public class ConversionRot13 {

    private char [] lettreAM ={'a','b','c','d','e','f','g','h','i','j','k','l','m'};
    private char [] lettreNZ = {'n','o','p','q','r','s','t','u','v','w','x','y','z'};


    public String conversionTexte (String texteNormal){
        StringBuilder texteRot13= new StringBuilder();
        Integer tailleTexteNormal = texteNormal.length();

        if (tailleTexteNormal >0) {
            char caract;
            boolean majuscule ;
            for (Integer i=0; i < tailleTexteNormal ; i++){
                caract =texteNormal.charAt(i);

                if ((caract >='A') && (caract <= 'Z')) {
                    majuscule = true;
                    caract = Character.toLowerCase(caract); // met en minuscule
                }else {
                    majuscule = false;
                }

                if ( (caract >='a') && (caract <= 'z') ){ // lettre
                    Log.i("TAG", "caract  if:"+ caract);
                    boolean boucleFor =true;
                    if (caract <= 'm'){ // compris entre am
                        Integer tailleaz = lettreAM.length;
                        for (Integer j=0;(j < tailleaz)&& boucleFor ;j++){
                            if (lettreAM[j]==caract) {
                                boucleFor = false;
                                if (majuscule)
                                    texteRot13.append(Character.toUpperCase(lettreNZ[j]));
                                else
                                    texteRot13.append(lettreNZ[j]);
                            }
                        }
                    } else { // compris entre nz
                        Integer taillenz = lettreNZ.length;
                        for (Integer j=0; (j< taillenz) && boucleFor;j++){
                            if (lettreNZ[j] == caract){
                                boucleFor = false;
                                if(majuscule)
                                    texteRot13.append(Character.toUpperCase(lettreAM[j]));
                                else
                                    texteRot13.append(lettreAM[j]);
                            }
                        }

                    }
                } else { // pas de mofification
                    texteRot13.append(caract);
                }
            }
        }
        return texteRot13.toString();
    }
}
