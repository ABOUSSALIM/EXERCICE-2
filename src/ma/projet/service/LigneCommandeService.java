
package ma.projet.service;

import java.util.Date;
import java.util.List;
import javafx.beans.binding.Bindings;
import ma.projet.classes.LigneCommandeProduit ;
import ma.projet.classes.Commande;
import ma.projet.classes.Produit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class LigneCommandeService implements IDao <LigneCommandeProduit> {

    @Override
    public boolean create(LigneCommandeProduit o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public LigneCommandeProduit getById(int id) {
        Session session = null;
        LigneCommandeProduit e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (LigneCommandeProduit) session.get(LigneCommandeProduit.class, id);
            session.getTransaction().commit();
            return e;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return e;
    }

    @Override
    public List<LigneCommandeProduit> getAll() {
        Session session = null;
        List<LigneCommandeProduit>  lignecommandes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            lignecommandes = session.createQuery("from LigneCommandeProduit").list();
            session.getTransaction().commit();
            return lignecommandes;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return lignecommandes;
    }

     public void produitDate(Date debut,Date fin){
       for(LigneCommandeProduit lcp : getAll()) {
           Date d = lcp.getCommande().getDate();
           if(d != null && d.compareTo(debut)>=0 && d.compareTo(fin)<= 0){
               System.out.println(" Les produits commandés entre ces dates sont : "+lcp.getProduit());
               System.out.println(" d'une qunatite egale a :"+lcp.getQt());
       }   
    }  }  
     public void produitCommande(Commande c){
       try{ 
           System.out.println("Commande :"+c.getId()+"                  Date : "+c.getDate());
           System.out.println("Liste des produits :");
           System.out.println("Reference :               Prix :                 Quantite : ");
         
       for(LigneCommandeProduit lcp : getAll()){
           Commande cm = lcp.getCommande();
           if(cm.getId() == c.getId()){
               System.out.println(lcp.getProduit().getRef()+"               "+lcp.getProduit().getPrix()+"DH                  "+lcp.getQt());
               System.out.println();
       }
       }
       }catch(Exception e){
               System.out.println(" Cette Commande n'existe pas ");
       }
}
   }

