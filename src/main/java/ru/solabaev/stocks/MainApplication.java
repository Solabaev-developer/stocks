package ru.solabaev.stocks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.transaction.internal.TransactionImpl;
import ru.solabaev.stocks.controller.StocksController;
import ru.solabaev.stocks.entity.Currencies;
import ru.solabaev.stocks.entity.Stocks;
import ru.solabaev.stocks.parcer.Parcer;
import ru.solabaev.stocks.services.CurrenciesService;
import ru.solabaev.stocks.util.HibernateSessionFactoryUtil;

public class MainApplication {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(new StocksController().getCurrentStocks(session, new Parcer().getDocument("https://investfunds.ru/etf/79/")));
        session.getTransaction().commit();
        session.close();
    }

}
