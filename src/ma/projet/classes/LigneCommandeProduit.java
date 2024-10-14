
package ma.projet.classes;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommandeProduit {
    @EmbeddedId
    private ProduitCommandePk pk ;
    @ManyToOne
    @JoinColumn(name = "produit",insertable = false,updatable = false)
    private Produit produit ;
    
    @ManyToOne
    @JoinColumn(name = "commande",insertable = false,updatable = false)
    private Commande   commande ;
    
    @Column(name = "quantite")
    private int qt ;

    public LigneCommandeProduit() {
    }

    public LigneCommandeProduit(ProduitCommandePk pk, Produit produit, Commande commande, int qt) {
        this.pk = pk;
        this.produit = produit;
        this.commande = commande;
        this.qt = qt;
    }

    public ProduitCommandePk getPk() {
        return pk;
    }

    public void setPk(ProduitCommandePk pk) {
        this.pk = pk;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }
    
    
}
