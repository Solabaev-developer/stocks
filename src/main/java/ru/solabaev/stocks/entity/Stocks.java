package ru.solabaev.stocks.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stocks")
public class Stocks {

    public Stocks() {
    }

    public Stocks(Integer id, Double priceUsd, Date date, String name, Double priceRub, Double priceEur) {
        this.id = id;
        this.priceUsd = priceUsd;
        this.date = date;
        this.name = name;
        this.priceRub = priceRub;
        this.priceEur = priceEur;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double priceUsd;

    private Date date;

    private String name;

    private Double priceRub;

    private Double priceEur;

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id;
    }

    @Column(name = "price_usd")
    public Double getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(Double priceUsd) {
        this.priceUsd = priceUsd;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price_rub")
    public Double getPriceRub() {
        return priceRub;
    }

    public void setPriceRub(Double priceRub) {
        this.priceRub = priceRub;
    }

    @Column(name = "price_eur")
    public Double getPriceEur() {
        return priceEur;
    }

    public void setPriceEur(Double priceEur) {
        this.priceEur = priceEur;
    }

    @Override
    public String toString() {
        return "Stocks{" +
                "id=" + id +
                ", PriceUsd=" + priceUsd +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", PriceRub=" + priceRub +
                ", PriceEur=" + priceEur +
                '}';
    }
}
