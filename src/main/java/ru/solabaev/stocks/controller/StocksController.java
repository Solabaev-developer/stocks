package ru.solabaev.stocks.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.solabaev.stocks.entity.Currencies;
import ru.solabaev.stocks.entity.Stocks;
import ru.solabaev.stocks.parcer.DocumentCreator;
import ru.solabaev.stocks.parcer.Parcer;

import java.util.Date;

@Component
public class StocksController {
    private Integer id = 0;
    private Double priceUsd;
    private String name;
    private Double priceEur;
    private Double priceRub;
    private Document document;
    private Parcer parcer;

    @Autowired
    public StocksController(Document document, Parcer parcer) {
        this.id = id + 1;
        this.document = document;
        this.parcer = parcer;
    }


    public void getPriceUsd() {
        this.priceUsd = parcer.getPriceUsdFromDoc();
    }

    public void getName() {
        this.name = parcer.getNameFromDoc();
    }

    public void getPriceEur(Session session) {

        Double currencyEur = session.load(Currencies.class, 1).getEur();
        Double currencyUsd = session.load(Currencies.class, 1).getUsd();
        this.priceEur = priceUsd * currencyUsd / currencyEur;
    }

    public void getPriceRub(Session session) {

        Double currencyUsd = session.load(Currencies.class, 1).getUsd();
        this.priceRub = priceUsd * currencyUsd;
    }

    public Stocks getCurrentStocks (Session session) {
        getPriceUsd();
        getName();
        getPriceRub(session);
        getPriceEur(session);
         return new Stocks(this.id, this.priceUsd, new Date(),this.name, this.priceRub,this.priceEur);
    }
}
