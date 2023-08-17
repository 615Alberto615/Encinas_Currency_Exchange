package com.Encinas_Currency_Exchange.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyApiService {

    private static final String BASE_URL = "https://www.amdoren.com/api/currency.php";
    private static final String API_KEY = "bVxW8ufa3Ye7Rxd6fviSnwKuchYxfv";
    private static final Logger logger = LoggerFactory.getLogger(CurrencyApiService.class);

    public Double getExchangeRate(String fromCurrency, String toCurrency) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = BASE_URL + "?api_key=" + API_KEY + "&from=" + fromCurrency + "&to=" + toCurrency;

            CurrencyApiResponse response = restTemplate.getForObject(url, CurrencyApiResponse.class);

            if (response != null) {
                if (response.getError() == 0) {
                    return response.getAmount();
                } else {
                    logger.warn("Error al obtener la tasa de cambio: {}", response.getErrorMessage());
                }
            }
        } catch (Exception e) {
            logger.error("Error al hacer la solicitud a la API de moneda", e);
        }

        return null;
    }
}

class CurrencyApiResponse {
    private int error;
    private String errorMessage;
    private double amount;

    public CurrencyApiResponse() {
    }

    public CurrencyApiResponse(int error, String errorMessage, double amount) {
        this.error = error;
        this.errorMessage = errorMessage;
        this.amount = amount;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CurrencyApiResponse{" +
                "error=" + error +
                ", errorMessage='" + errorMessage + '\'' +
                ", amount=" + amount +
                '}';
    }
}