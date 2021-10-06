package ru.solabaev.stocks.parcer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class CreateDocument  {
    private String url;
    private Document document;

    public CreateDocument(String url) {
        this.url = url;
    }

    public void getDocument() {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("Страница не найдена");
        }
        this.document = document;
    }
}
