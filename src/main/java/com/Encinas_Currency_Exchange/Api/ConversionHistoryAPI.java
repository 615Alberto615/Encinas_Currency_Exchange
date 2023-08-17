package com.Encinas_Currency_Exchange.Api;
import com.Encinas_Currency_Exchange.Bl.ConversionHistoryBL;
import com.Encinas_Currency_Exchange.Entity.ConversionHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversions")
public class ConversionHistoryAPI {

    @Autowired
    private ConversionHistoryBL conversionHistoryBL;

    @PostMapping("/convert")
    public ConversionHistory convertAndSave(@RequestParam String fromCurrency, @RequestParam String toCurrency, @RequestParam double amount) {
        return conversionHistoryBL.convertAndSave(fromCurrency, toCurrency, amount);
    }

    @GetMapping
    public List<ConversionHistory> getAllConversions() {
        return conversionHistoryBL.getAllConversions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConversionHistory> getConversionById(@PathVariable Integer id) {
        return conversionHistoryBL.getConversionById(id)
                .map(conversion -> ResponseEntity.ok().body(conversion))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ConversionHistory createConversion(@RequestBody ConversionHistory conversionHistory) {
        return conversionHistoryBL.saveConversion(conversionHistory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConversion(@PathVariable Integer id) {
        conversionHistoryBL.deleteConversion(id);
        return ResponseEntity.ok().build();
    }
}