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





}