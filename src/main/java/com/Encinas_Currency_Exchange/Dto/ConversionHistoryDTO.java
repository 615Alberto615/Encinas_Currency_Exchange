package com.Encinas_Currency_Exchange.Dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ConversionHistoryDTO implements Serializable {

    private Integer conversionId;
    private CurrencyDTO fromCurrency;
    private CurrencyDTO toCurrency;
    private BigDecimal amount;
    private BigDecimal convertedAmount;
    private Date conversionDate;

    public ConversionHistoryDTO() {}

    public ConversionHistoryDTO(Integer conversionId, CurrencyDTO fromCurrency, CurrencyDTO toCurrency, BigDecimal amount, BigDecimal convertedAmount, Date conversionDate) {
        this.conversionId = conversionId;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
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

    public CurrencyDTO getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(CurrencyDTO fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public CurrencyDTO getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(CurrencyDTO toCurrency) {
        this.toCurrency = toCurrency;
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
        return "ConversionHistoryDTO{" +
                "conversionId=" + conversionId +
                ", fromCurrency=" + fromCurrency +
                ", toCurrency=" + toCurrency +
                ", amount=" + amount +
                ", convertedAmount=" + convertedAmount +
                ", conversionDate=" + conversionDate +
                '}';
    }
}