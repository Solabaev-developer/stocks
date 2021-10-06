package ru.solabaev.stocks.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.solabaev.stocks.dao.StocksDao;
import ru.solabaev.stocks.entity.Stocks;
import ru.solabaev.stocks.util.HibernateSessionFactoryUtil;

import java.util.List;

public class StocksDaoImpl implements StocksDao {

    public Stocks findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Stocks.class, id);
    }

    public void save(Stocks stocks) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(stocks);
        tx1.commit();
        session.close();
    }

    public void update(Stocks stocks) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(stocks);
        tx1.commit();
        session.close();
    }

    public void delete(Stocks stocks) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(stocks);
        tx1.commit();
        session.close();
    }

    public List<Stocks> findAll() {
        List<Stocks> stocks = (List<Stocks>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Stocks").list();
        return stocks;
    }
}

