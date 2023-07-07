package com.ecommerce.microcommerce.produit.model;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "produit")
public class Produit {
    private int id;
    private String type;
    private long reference;
    private long desc;
    private int prix;

    public Produit(int id, String type, long reference, long desc, int prix) {
        this.id = id;
        this.type = type;
        this.reference = reference;
        this.desc = desc;
        this.prix = prix;
    }
    public Produit(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getReference() {
        return reference;
    }

    public void setReference(long reference) {
        this.reference = reference;
    }

    public long getDesc() {
        return desc;
    }

    public void setDesc(long desc) {
        this.desc = desc;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", type='" + type + '\'' +
                ", reference='" + reference + '\'' +
                ", prix=" + prix +
                '}';
    }
}

