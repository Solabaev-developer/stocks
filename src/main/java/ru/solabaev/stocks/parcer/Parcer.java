package ru.solabaev.stocks.parcer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.solabaev.stocks.entity.Stocks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Parcer {
    private Long id;

    private Integer priceUsd;

    private Date date;

    private String name;

    private Integer priceRub;

    private Integer priceEur;

    public Document getDocument(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("Страница не найдена");
        }
        return document;
    }

    public Double getPriceUsdFromDoc(Document document) {
        return Double.parseDouble(document.getElementsByClass("price left").text());
    }

    public String getNameFromDoc(Document document) {
        return document.getElementsByClass("ttl left indent_top_10 indent_right_10").text();
    }

    public Double getCurrencyUsd(Document document) {
        Elements elements = document.getElementsByClass("price");
        String price = elements.get(0).text();
        return Double.parseDouble(price);
    }

    public Double getCurrencyEur(Document document) {
        Elements elements = document.getElementsByClass("price");
        String price = elements.get(1).text();
        return Double.parseDouble(price);
    }
}
