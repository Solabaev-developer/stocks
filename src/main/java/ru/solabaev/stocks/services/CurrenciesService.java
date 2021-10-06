package ru.solabaev.stocks.services;


import ru.solabaev.stocks.dao.impl.CurrenciesDaoImpl;
import ru.solabaev.stocks.entity.Currencies;

import java.util.List;

public class CurrenciesService {

    public CurrenciesService() {
    }

    private CurrenciesDaoImpl currenciesDao = new CurrenciesDaoImpl();

    public Currencies findcurrencies(int id) {
        return currenciesDao.findById(id);
    }

    public void savecurrencies(Currencies currencies) {
        currenciesDao.save(currencies);
    }

    public void deletecurrencies(Currencies currencies) {
        currenciesDao.delete(currencies);
    }

    public void updatecurrencies(Currencies currencies) {
        currenciesDao.update(currencies);
    }

    public List<Currencies> findAllcurrencies() {
        return currenciesDao.findAll();
    }
}
