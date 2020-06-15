package com.yura.rada.dao.impl;

import com.yura.rada.dao.DeputatDao;
import com.yura.rada.model.Deputat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuriismac on 2020-06-06.
 * @project VerkhovnaRada
 */

@Repository
public class DeputatDaoImpl implements DeputatDao {

    private static final Logger logger = LoggerFactory.getLogger(DeputatDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addDeputat(Deputat deputat) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(deputat);
        logger.info("Deputat successfully saved. Deputat details: " + deputat);

    }

    @Override
    public void updateDeputat(Deputat deputat) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(deputat);
        logger.info("Deputat successfully updated. Deputat details: " + deputat);
    }

    @Override
    public void removeDeputat(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Deputat deputat = (Deputat) session.load(Deputat.class, id);

        if (deputat != null){
            session.delete(deputat);
            logger.info("Deputat successfully removed. Deputat details: " + deputat);
        }

    }

    @Override
    public Deputat getDeputatById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Deputat deputat = (Deputat) session.load(Deputat.class, id);
        logger.info("Deputat successfully uploaded. Deputat details: " + deputat);
        return deputat;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Deputat> listDeputats() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Deputat> deputatList = session.createQuery("from Deputat", Deputat.class).list();

        for (Deputat deputat : deputatList) {
            logger.info("Deputat list " + deputat);
        }
        return deputatList;
    }
}
