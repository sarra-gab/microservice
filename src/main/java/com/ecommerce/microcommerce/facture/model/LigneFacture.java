package com.ecommerce.microcommerce.facture.model;

import com.ecommerce.microcommerce.produit.model.Produit;

import javax.persistence.*;

@Entity
@Table(name = "facture_produit")
public class LigneFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    private int quantite;

    public LigneFacture(Long id, Facture facture, Produit produit, int quantite) {
        this.id = id;
        this.facture = facture;
        this.produit = produit;
        this.quantite = quantite;
    }
    public LigneFacture() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
