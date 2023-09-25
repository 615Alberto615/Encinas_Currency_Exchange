package com.Encinas_Currency_Exchange.Strategy;

import com.Encinas_Currency_Exchange.Service.CurrencyApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Component
@Primary
public class SimpleConversiones implements ConversionStrategy {

    private static final Logger log = LoggerFactory.getLogger(SimpleConversiones.class);

    private CurrencyApiService currencyApiService;

    public SimpleConversiones(CurrencyApiService currencyApiService) {
        this.currencyApiService = currencyApiService;
    }

    @Override
    public Double convert(String fromCurrency, String toCurrency, Double amount) {
        try {
            Double exchangeRate = currencyApiService.getExchangeRate(fromCurrency, toCurrency);
            return amount * exchangeRate;
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            log.warn("Usando tasa de cambio predeterminada de 1 para {} a {}.", fromCurrency, toCurrency);
            return amount; // Usar una tasa de cambio predeterminada de 1
        }
    }
}

/*
@Override
    public double convert(String fromCurrency, String toCurrency, double amount) {
        double rate = getExchangeRate(fromCurrency, toCurrency);
        return amount * rate;
    }


    private double getExchangeRate(String fromCurrency, String toCurrency) {

        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            return 0.85; // Supongamos que 1 USD es 0.85 EUR
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            return 1.18; // Supongamos que 1 EUR es 1.18 USD
        }
        // ... agregar más tasas de cambio según sea necesario

        // Si no encontramos una tasa de cambio, retornamos 1 (esto significa que las monedas son iguales, lo cual puede no ser cierto en una implementación real)
        return 1.0;
    }
*/