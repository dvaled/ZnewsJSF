/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.ZnewsUtil;
import pojo.Writeer;
        

/**
 *
 * @author DAVA
 */
public class DAOLoginWriter {
    
    public List<Writeer> getBy(String uName, String uPass) {
        Writeer u = new Writeer();
        List<Writeer> wrter = new ArrayList();

        Transaction trans = null;
        Session session = ZnewsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Writeer where username= :uName AND password= :uPass");
            query.setString("uName", uName);
            query.setString("uPass", uPass);
            u = (Writeer) query.uniqueResult();
            wrter = query.list();

            trans.commit();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return wrter;
    }
    
}
