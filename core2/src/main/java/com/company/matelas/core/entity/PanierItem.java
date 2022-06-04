
package com.company.matelas.core.entity;


public class PanierItem {
  private Long matelasId;
   private int quantite;

    public PanierItem() {
    }

    public PanierItem(Long matelasId, int quantite) {
        this.matelasId = matelasId;
        this.quantite = quantite;
    }
   
   

    public Long getMatelasId() {
        return matelasId;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setMatelasId(Long matelasId) {
        this.matelasId = matelasId;
    }

    @Override
    public String toString() {
        return "PanierItem{" + "matelasId=" + matelasId + ", quantite=" + quantite + '}';
    }
    
    
    
}
