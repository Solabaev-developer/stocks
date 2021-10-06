package ru.solabaev.stocks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.solabaev.stocks.conf.Config;
import ru.solabaev.stocks.controller.StocksController;

public class MainApplication {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        StocksController stocksController = context.getBean("stocksController", StocksController.class);

        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(stocksController.getCurrentStocks(session));
        session.getTransaction().commit();
        session.close();
    }

}
