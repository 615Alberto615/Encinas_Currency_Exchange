package com.Encinas_Currency_Exchange.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ConversionHistory", schema = "public")
public class ConversionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conversion_id")
    private Integer conversionId;

    @Column(name = "from_currency", length = 3, nullable = false)
    private String fromCurrencyCode;

    @Column(name = "to_currency", length = 3, nullable = false)
    private String toCurrencyCode;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "converted_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal convertedAmount;

    @Column(name = "conversion_date", nullable = false)
    private Date conversionDate;

    public ConversionHistory() {
    }

    public ConversionHistory(Integer conversionId, String fromCurrencyCode, String toCurrencyCode, BigDecimal amount, BigDecimal convertedAmount, Date conversionDate) {
        this.conversionId = conversionId;
        this.fromCurrencyCode = fromCurrencyCode;
        this.toCurrencyCode = toCurrencyCode;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
        this.conversionDate = conversionDate;
    }

    public Integer getConversionId() {
        return conversionId;
    }

    public void setConversionId(Integer conversionId) {
        this.conversionId = conversionId;
    }

    public String getFromCurrencyCode() {
        return fromCurrencyCode;
    }

    public void setFromCurrencyCode(String fromCurrencyCode) {
        this.fromCurrencyCode = fromCurrencyCode;
    }

    public String getToCurrencyCode() {
        return toCurrencyCode;
    }

    public void setToCurrencyCode(String toCurrencyCode) {
        this.toCurrencyCode = toCurrencyCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(BigDecimal convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public Date getConversionDate() {
        return conversionDate;
    }

    public void setConversionDate(Date conversionDate) {
        this.conversionDate = conversionDate;
    }

    @Override
    public String toString() {
        return "ConversionHistory{" +
                "conversionId=" + conversionId +
                ", fromCurrencyCode='" + fromCurrencyCode + '\'' +
                ", toCurrencyCode='" + toCurrencyCode + '\'' +
                ", amount=" + amount +
                ", convertedAmount=" + convertedAmount +
                ", conversionDate=" + conversionDate +
                '}';
    }
}
