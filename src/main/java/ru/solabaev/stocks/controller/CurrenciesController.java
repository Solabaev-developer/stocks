package ru.solabaev.stocks.controller;

import org.jsoup.nodes.Document;
import ru.solabaev.stocks.entity.Currencies;
import ru.solabaev.stocks.parcer.Parcer;

import java.util.Date;

public class CurrenciesController {
    private Integer id = 0;

    public CurrenciesController() {
        this.id = id + 1;
    }

    public Currencies getCurrencies(Document document) {
        Double currencyUsd = new Parcer().getCurrencyUsd(document);
        Double currencyEur = new Parcer().getCurrencyEur(document);
        return new Currencies(this.id, currencyUsd, currencyEur, new Date());

    }
}
