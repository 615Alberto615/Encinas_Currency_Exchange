package com.Encinas_Currency_Exchange.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Currencies")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_id")
    private Integer currencyId;

    @Column(name = "currency_code", unique = true, nullable = false, length = 3)
    private String currencyCode;

    @Column(name = "currency_name", nullable = false, length = 50)
    private String currencyName;

    @OneToMany(mappedBy = "fromCurrency")
    private List<ConversionHistory> conversionsFrom;

    @OneToMany(mappedBy = "toCurrency")
    private List<ConversionHistory> conversionsTo;

    public Currency() {
    }

    public Currency(Integer currencyId, String currencyCode, String currencyName, List<ConversionHistory> conversionsFrom, List<ConversionHistory> conversionsTo) {
        this.currencyId = currencyId;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.conversionsFrom = conversionsFrom;
        this.conversionsTo = conversionsTo;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public List<ConversionHistory> getConversionsFrom() {
        return conversionsFrom;
    }

    public void setConversionsFrom(List<ConversionHistory> conversionsFrom) {
        this.conversionsFrom = conversionsFrom;
    }

    public List<ConversionHistory> getConversionsTo() {
        return conversionsTo;
    }

    public void setConversionsTo(List<ConversionHistory> conversionsTo) {
        this.conversionsTo = conversionsTo;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyId=" + currencyId +
                ", currencyCode='" + currencyCode + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", conversionsFrom=" + conversionsFrom +
                ", conversionsTo=" + conversionsTo +
                '}';
    }
}