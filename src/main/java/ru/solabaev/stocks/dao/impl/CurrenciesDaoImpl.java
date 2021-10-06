package ru.solabaev.stocks.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.solabaev.stocks.dao.CurrenciesDao;
import ru.solabaev.stocks.entity.Currencies;
import ru.solabaev.stocks.util.HibernateSessionFactoryUtil;


import java.util.List;

public class CurrenciesDaoImpl implements CurrenciesDao {

    public Currencies findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Currencies.class, id);
    }

    public void save(Currencies currencies) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(currencies);
        tx1.commit();
        session.close();
    }

    public void update(Currencies currencies) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(currencies);
        tx1.commit();
        session.close();
    }

    public void delete(Currencies currencies) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(currencies);
        tx1.commit();
        session.close();
    }

    public List<Currencies> findAll() {
        List<Currencies> Currencies = (List<Currencies>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Currencies").list();
        return Currencies;
    }
}
