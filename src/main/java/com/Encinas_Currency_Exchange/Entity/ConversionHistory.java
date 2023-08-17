package com.Encinas_Currency_Exchange.Entity;
import jakarta.persistence.*;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ConversionHistory")
public class ConversionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conversion_id")
    private Integer conversionId;

    @ManyToOne
    @JoinColumn(name = "from_currency", referencedColumnName = "currency_id")
    private Currency fromCurrency;

    @ManyToOne
    @JoinColumn(name = "to_currency", referencedColumnName = "currency_id")
    private Currency toCurrency;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "converted_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal convertedAmount;

    @Column(name = "conversion_date", nullable = false)
    private Date conversionDate;

    public ConversionHistory() {
    }

    public ConversionHistory(Integer conversionId, Currency fromCurrency, Currency toCurrency, BigDecimal amount, BigDecimal convertedAmount, Date conversionDate) {
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

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
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
        return "ConversionHistory{" +
                "conversionId=" + conversionId +
                ", fromCurrency=" + fromCurrency +
                ", toCurrency=" + toCurrency +
                ", amount=" + amount +
                ", convertedAmount=" + convertedAmount +
                ", conversionDate=" + conversionDate +
                '}';
    }
}