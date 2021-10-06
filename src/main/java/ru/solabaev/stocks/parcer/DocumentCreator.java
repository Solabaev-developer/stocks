package ru.solabaev.stocks.parcer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DocumentCreator extends Document {
    /**
     * Create a new, empty Document.
     *
     * @param baseUri base URI of document
     * @see Jsoup#parse
     * @see #createShell
     */
    public DocumentCreator(String baseUri) {
        super(baseUri);
    }
}
