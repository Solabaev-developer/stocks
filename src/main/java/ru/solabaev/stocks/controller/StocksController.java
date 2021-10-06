package ru.solabaev.stocks.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jsoup.nodes.Document;
import ru.solabaev.stocks.entity.Currencies;
import ru.solabaev.stocks.entity.Stocks;
import ru.solabaev.stocks.parcer.Parcer;

import java.util.Date;

public class StocksController {
    private Integer id = 0;
    private Double priceUsd;
    private String name;
    private Double priceEur;
    private Double priceRub;

    public StocksController() {
        this.id = id + 1;
    }

    public void getPriceUsd(Document document) {
        this.priceUsd = new Parcer().getPriceUsdFromDoc(document);
    }

    public void getName(Document document) {
        this.name = new Parcer().getNameFromDoc(document);
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

    public Stocks getCurrentStocks (Session session, Document document) {
        getPriceUsd(document);
        getName(document);
        getPriceRub(session);
        getPriceEur(session);
        return new Stocks(this.id, this.priceUsd, new Date(),this.name, this.priceRub,this.priceEur);
    }
}
