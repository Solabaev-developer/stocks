package ru.solabaev.stocks.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jsoup.nodes.Document;
import ru.solabaev.stocks.entity.Currencies;
import ru.solabaev.stocks.parcer.Parcer;

import java.util.Date;

public class StocksController {
    private Integer id = 0;
    private Double priceUsd;

    public StocksController() {
        this.id = id + 1;
    }

    public void getPriceUsd(Document document) {
        this.priceUsd = new Parcer().getPriceUsdFromDoc(document);
    }

    public Double getpriceEur(Session session) {

        Double currencyEur = session.load(Currencies.class, 1).getEur();
        Double currencyUsd = session.load(Currencies.class, 1).getUsd();
        Double result = priceUsd / currencyUsd * currencyEur;
        System.out.println(result);
        return result;
    }

/*    public Currencies getStocks(Document document) {
        Double priceUsd = new Parcer().getPriceUsdFromDoc(document);
        String name = new Parcer().getNameFromDoc(document);

    }*/
}
