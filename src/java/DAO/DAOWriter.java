/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Writeer;
import pojo.ZnewsUtil;

/**
 *
 * @author DAVA
 */
public class DAOWriter {
   
    public void addWriter(Writeer wrt) {
        Transaction trans = null;
        Session session = ZnewsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(wrt);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteWriter(Integer idB) {
        Transaction trans = null;
        Session session = ZnewsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Writeer wrt = (Writeer) session.load(Writeer.class, new Integer(idB));
            session.delete(wrt);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public java.util.List<Writeer> getbyID(Integer idB) {
        Writeer wrt = new Writeer();
        java.util.List<Writeer> lWrt = new ArrayList();

        Transaction trans = null;
        Session session = ZnewsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Writeer where id= :id");
            query.setInteger("id", idB);
            wrt = (Writeer) query.uniqueResult();
            lWrt = query.list();

            trans.commit();
        } catch (Exception e) {

        }
        return lWrt;
    }
    

    public java.util.List<Writeer> retrieveWriter() {

        java.util.List stud = new ArrayList();
        Writeer stud1 = new Writeer();
        Transaction trans = null;
        Session session = ZnewsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Writeer");
            stud = query.list();
            stud.add(stud1.getUsername());
            stud.add(stud1.getPassword());

            trans.commit();

        } catch (Exception e) {

        }
        return stud;
    }

    public void updateWriter(Writeer wrt) {
        Transaction trans = null;
        Session session = ZnewsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(wrt);
            trans.commit();
        } catch (Exception e) {

        }
    }
    
}
