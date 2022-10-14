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
import pojo.News;

/**
 *
 * @author DAVA
 */
public class DAOBerita {
    
    public void addBerita(News brt) {
        Transaction trans = null;
        Session session = ZnewsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(brt);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBerita(Integer idB) {
        Transaction trans = null;
        Session session = ZnewsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            News brt = (News) session.load(News.class, new Integer(idB));
            session.delete(brt);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<News> getbyID(Integer idB) {
        News brt = new News();
        List<News> lBrt = new ArrayList();

        Transaction trans = null;
        Session session = ZnewsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from News where id= :id");
            query.setInteger("id", idB);
            brt = (News) query.uniqueResult();
            lBrt = query.list();

            trans.commit();
        } catch (Exception e) {

        }
        return lBrt;
    }
    

    public List<News> retrieveNews() {

        List stud = new ArrayList();
        News stud1 = new News();
        Transaction trans = null;
        Session session = ZnewsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from News");
            stud = query.list();
            stud.add(stud1.getTitle());
            stud.add(stud1.getDescription());
            stud.add(stud1.getWriter());
            stud.add(stud1.getContent());

            trans.commit();

        } catch (Exception e) {

        }
        return stud;
    }

    public void updateBerita(News brt) {
        Transaction trans = null;
        Session session = ZnewsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(brt);
            trans.commit();
        } catch (Exception e) {

        }
    }

    
    
}
