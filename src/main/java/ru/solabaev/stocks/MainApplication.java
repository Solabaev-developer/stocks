package ru.solabaev.stocks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.solabaev.stocks.controller.StocksController;
import ru.solabaev.stocks.parcer.Parcer;
import ru.solabaev.stocks.services.CurrenciesService;

public class MainApplication {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        CurrenciesService currenciesService = new CurrenciesService();
        StocksController stocksController = new StocksController();
        stocksController.getPriceUsd(new Parcer().getDocument("https://investfunds.ru/etf/79/"));
        stocksController.getpriceEur(session);
    }

}
