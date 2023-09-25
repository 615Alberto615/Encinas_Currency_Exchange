package com.Encinas_Currency_Exchange.Strategy;

public interface ConversionStrategy {
    Double convert(String fromCurrency, String toCurrency, Double amount);
}
