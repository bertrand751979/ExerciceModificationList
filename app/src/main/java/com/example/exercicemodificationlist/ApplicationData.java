package com.example.exercicemodificationlist;

import static java.nio.file.Paths.get;

import com.example.exercicemodificationlist.model.Voiture;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationData {
    private Voiture voitureAncienne = new Voiture();
    private Voiture voitureNouvelle = new Voiture();


    private ApplicationData(){}

    private static ApplicationData INSTANCE = null;
    public static ApplicationData getInstance(){
        if (INSTANCE == null){
            INSTANCE = new ApplicationData();
        }
        return INSTANCE;
    }

    public Voiture getVoitureAncienne() {
        return voitureAncienne;
    }

    public void setVoitureAncienne(Voiture voitureAncienne) {
        this.voitureAncienne = voitureAncienne;
    }

    public Voiture getVoitureNouvelle() {
        return voitureNouvelle;
    }

    public void setVoitureNouvelle(Voiture voitureNouvelle) {
        this.voitureNouvelle = voitureNouvelle;
    }
}
