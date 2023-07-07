package com.ecommerce.microcommerce.facture.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "facture")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private String description;
    private double montant;

    // Constructeurs, getters et setters

    public Facture() {
    }

    public Facture(Date date, String description, double montant) {
        this.date = date;
        this.description = description;
        this.montant = montant;
    }

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
