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
import pojo.Admin;
import pojo.ZnewsUtil;

/**
 *
 * @author DAVA
 */
public class DAOAdmin {
    
    public void addAdmin(Admin adm) {
        Transaction trans = null;
        Session session = ZnewsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(adm);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAdmin(Integer idB) {
        Transaction trans = null;
        Session session = ZnewsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Admin adm = (Admin) session.load(Admin.class, new Integer(idB));
            session.delete(adm);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public java.util.List<Admin> getbyID(Integer idB) {
        Admin adm = new Admin();
        java.util.List<Admin> lAdm = new ArrayList();

        Transaction trans = null;
        Session session = ZnewsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Admin where id= :id");
            query.setInteger("id", idB);
            adm = (Admin) query.uniqueResult();
            lAdm = query.list();

            trans.commit();
        } catch (Exception e) {

        }
        return lAdm;
    }
    

    public java.util.List<Admin> retrieveAdmin() {

        java.util.List stud = new ArrayList();
        Admin stud1 = new Admin();
        Transaction trans = null;
        Session session = ZnewsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Admin");
            stud = query.list();
            stud.add(stud1.getUsername());
            stud.add(stud1.getPassword());

            trans.commit();

        } catch (Exception e) {

        }
        return stud;
    }

    public void updateAdmin(Admin adm) {
        Transaction trans = null;
        Session session = ZnewsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(adm);
            trans.commit();
        } catch (Exception e) {

        }
    }
    
}
