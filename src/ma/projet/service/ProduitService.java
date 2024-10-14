
package ma.projet.service;

import java.util.List;
import javax.persistence.TypedQuery;
import ma.projet.classes.Produit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ma.projet.classes.Categorie;


public class ProduitService  implements IDao <Produit> {

    @Override
    public boolean create(Produit o) {
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
    public Produit getById(int id) {
        Session session = null;
        Produit e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Produit) session.get(Produit.class, id);
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
    public List<Produit> getAll() {
        Session session = null;
        List<Produit>  produits = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            produits = session.createQuery("from Produit").list();
            session.getTransaction().commit();
            return produits;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return produits;
    }

    public void  produitCategorie(Categorie cat){
        try{
        System.out.println("###  les Produits categoresées par " +cat+" sont :  \n"
                +cat.getProduits());
        }catch(Exception e){
            System.out.println(" "+e.getMessage());}
        
    } 
   public void produitSup() {
    Session session = null;
    List<Produit> prds = null;
    try {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery<Produit> query = session.createNamedQuery("Produit.sup", Produit.class);
        query.setParameter("prix", 100);  // Définir le paramètre de prix
        prds = query.getResultList();
        for (Produit p : prds) {
            System.out.println(p);
        }
        session.getTransaction().commit();
    } catch (HibernateException e) {    
        if (session != null && session.getTransaction() != null) {
            session.getTransaction().rollback();
        }
        System.out.println("Erreur : " + e.getMessage());
    } finally {   
        if (session != null) {
            session.close();
        }
    }
}

}
