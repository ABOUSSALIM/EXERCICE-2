/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.Produit;
import ma.projet.classes.ProduitCommandePk;
import ma.projet.service.CategorieService;
import ma.projet.service.CommandeService;
import ma.projet.service.LigneCommandeService;
import ma.projet.service.ProduitService;

public class Test {

    public static void main(String[] args) {
        
        
      Scanner scan = new Scanner(System.in); 
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
      Date d1 = null ;
      Date d2 = null ;
      ProduitService ps = new ProduitService();
      CategorieService cs = new CategorieService();
      CommandeService ms = new  CommandeService();
      LigneCommandeService lcs = new LigneCommandeService() ;
      cs.create(new Categorie("SH100","Electronique"));
      cs.create(new Categorie("SKW18","food"));
      ps.create(new Produit("RTC110",2000,cs.getById(1)));
      ps.create(new Produit("XMAX111",3000,cs.getById(1)));
      ms.create(new Commande(new Date()));   
      lcs.create(new LigneCommandeProduit(new ProduitCommandePk(1,1),ps.getById(1),ms.getById(1) , 20));
      lcs.create(new LigneCommandeProduit(new ProduitCommandePk(2,1),ps.getById(2), ms.getById(1), 10));
        //  Methode afficher les produits par categorie
        ps.produitCategorie(cs.getById(1));
       //Affichage conditionnee
        try{
            System.out.println("Entrer la date de debut DD-MM-YYYY :");
            String debut = scan.nextLine();
            d1 = sdf.parse(debut);
            System.out.println("Entrer la date de fin DD-MM-YYYY :");
            String fin = scan.nextLine();
            d2 = sdf.parse(fin);
          
        }catch(Exception e){
            System.out.println("erreur ! "+e.getMessage());
    }
        
          //lcs.produitDate(d1, d2);
          //lcs.produitCommande(ms.getById(2));
          ps.produitSup();
    }   
}
