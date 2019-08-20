package com.webactiviti.jeuxdeconversion.model;



public class ConversionNombreEnRomain {

    private String [] nbMillierRomain ={"MMMM", "MMM","MM","M"};//
    private Integer[] nbMillier ={4000,3000,2000,1000};

    private String[] nbCentaineRomain ={"CM","DCCC","DCC","DC","D","CD","CCC","CC","C"};
    private Integer[] nbCentaine = {900,800,700,600,500,400,300,200,100};

    private String [] nbDizaineRomain ={"XC","LXXX","LXX","LX","L","XL","XXX","XX","X"};
    private Integer[] nbDizaine = {90,80,70,60,50,40,30,20,10};

    private String [] nbUniteRomain = {"IX", "VIII","VII","VI", "V", "IV","III","II", "I"} ;
    private Integer[] nbUnite = {9,8,7,6,5,4,3,2,1};

    public String calculRomain (Integer entier) {
        StringBuilder nbRomain = new StringBuilder();
        boolean boucleFor = true;
        // boucle millier
        for (int i=0  ; (i< nbMillier.length) && boucleFor; i++){
            if (entier >= nbMillier[i]){
                nbRomain.append(nbMillierRomain[i]);
                entier -=nbMillier[i];
                boucleFor = false;
            }
        }
        boucleFor = true;
        // boucle centaine
        for (int i=0  ; (i< nbCentaine.length) && boucleFor; i++){
            if (entier >= nbCentaine[i]){
                nbRomain.append(nbCentaineRomain[i]);
                entier -=nbCentaine[i];
                boucleFor = false;
            }
        }
        boucleFor = true;
        // boucle dizaine
        for (int i=0  ; (i< nbDizaine.length) && boucleFor; i++){
            if (entier >= nbDizaine[i]){
                nbRomain.append(nbDizaineRomain[i]);
                entier -=nbDizaine[i];
                boucleFor = false;
            }
        }
        boucleFor = true;
        // boucle unite
        for (int i=0  ; (i< nbUnite.length) && boucleFor; i++){
            if (entier >= nbUnite[i]){
                nbRomain.append(nbUniteRomain[i]);
                entier -=nbUnite[i];
                boucleFor = false;
            }
        }

        return nbRomain.toString();
    }
}
