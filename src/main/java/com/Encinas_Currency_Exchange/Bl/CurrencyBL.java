package com.Encinas_Currency_Exchange.Bl;

import com.Encinas_Currency_Exchange.Dao.CurrencyDAO;
import com.Encinas_Currency_Exchange.Entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyBL {

    @Autowired
    private CurrencyDAO currencyDAO;

    public List<Currency> getAllCurrencies() {
        return currencyDAO.findAll();
    }

    public Optional<Currency> getCurrencyById(Integer id) {
        return currencyDAO.findById(id);
    }

    public Currency saveCurrency(Currency currency) {
        return currencyDAO. save(currency);
    }

    public void deleteCurrency(Integer id) {
        currencyDAO.deleteById(id);
    }
}