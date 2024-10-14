/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "lebelle")
    private String leb;
    private String code ;
    @OneToMany(mappedBy = "categorie",fetch = FetchType.EAGER)
    private List<Produit> produits ;
    public Categorie() {
    }

    
    public Categorie(String leb, String code) {
        this.leb = leb;
        this.code = code;
    }
   public Categorie(String leb, String code, List<Produit> produits) {
        this(leb,code); 
        this.produits = produits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeb() {
        return leb;
    }

    public void setLeb(String leb) {
        this.leb = leb;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public String toString() {
        return "Categorie{" + "leb=" + leb + ", code=" + code + '}';
    }
   


    
}
