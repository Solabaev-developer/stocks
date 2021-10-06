package ru.solabaev.stocks.conf;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@Configuration
@ComponentScan("ru.solabaev.stocks")
@PropertySource("classpath:url.properties")
public class Config {
    @Value("${url}")
    private String url;

    @Bean
    public Document getDocument() {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("Страница не найдена");
        }
        return document;
    }
}
