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

    // Getters, setters y otros métodos útiles
}