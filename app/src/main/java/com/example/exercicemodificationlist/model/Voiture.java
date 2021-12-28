package com.example.exercicemodificationlist.model;

import java.io.Serializable;

public class Voiture implements Serializable {
    private String marque;
    private String model;

    public Voiture(String marque, String model) {
        this.marque = marque;
        this.model = model;
    }

    public Voiture(){}

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
