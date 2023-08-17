package com.Encinas_Currency_Exchange.Dao;


import com.Encinas_Currency_Exchange.Entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyDAO {

    @Autowired
    private CurrencyRepository currencyRepository;

    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    public Optional<Currency> findById(Integer id) {
        return currencyRepository.findById(id);
    }

    public Currency save(Currency currency) {
        return currencyRepository.save(currency);
    }

    public void deleteById(Integer id) {
        currencyRepository.deleteById(id);
    }
}