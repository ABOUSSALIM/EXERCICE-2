/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;
import org.hibernate.Session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "produits")
@NamedQuery(name = "Produit.sup",
        query = "SELECT p FROM Produit p WHERE p.prix > :100")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "reference")
    private String ref ;
    private float prix ;
    @ManyToOne
    private Categorie categorie ;

    public Produit() {
    }

    public Produit(String ref, float prix) {
        this.ref = ref;
        this.prix = prix;
    }

    public Produit(String ref, float prix, Categorie categorie) {
        this(ref,prix);
       
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }


    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", ref=" + ref + ", prix=" + prix + '}';
    }

  
    
}
