package com.Encinas_Currency_Exchange.Api;

import com.Encinas_Currency_Exchange.Bl.CurrencyBL;
import com.Encinas_Currency_Exchange.Entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyAPI {

    @Autowired
    private CurrencyBL currencyBL;

    @GetMapping
    public List<Currency> getAllCurrencies() {
        return currencyBL.getAllCurrencies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Currency> getCurrencyById(@PathVariable Integer id) {
        return currencyBL.getCurrencyById(id)
                .map(currency -> ResponseEntity.ok().body(currency))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Currency createCurrency(@RequestBody Currency currency) {
        return currencyBL.saveCurrency(currency);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Currency> updateCurrency(@PathVariable Integer id, @RequestBody Currency currency) {
        return ResponseEntity.ok(currencyBL.saveCurrency(currency));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrency(@PathVariable Integer id) {
        currencyBL.deleteCurrency(id);
        return ResponseEntity.ok().build();
    }
}