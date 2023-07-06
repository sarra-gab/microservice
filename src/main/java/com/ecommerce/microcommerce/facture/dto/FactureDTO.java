package com.ecommerce.microcommerce.facture.dto;

import java.util.List;

public class FactureDTO {
    private Long clientId;
    private List<Long> produitIds;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<Long> getProduitIds() {
        return produitIds;
    }

    public void setProduitIds(List<Long> produitIds) {
        this.produitIds = produitIds;
    }
}
