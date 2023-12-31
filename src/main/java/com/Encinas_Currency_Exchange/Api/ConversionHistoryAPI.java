package com.Encinas_Currency_Exchange.Api;

import com.Encinas_Currency_Exchange.Bl.ConversionHistoryBL;
import com.Encinas_Currency_Exchange.Entity.ConversionHistory;
import com.Encinas_Currency_Exchange.Strategy.ConversionStrategy;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/conversions")
//@CrossOrigin(origins = "*")
public class ConversionHistoryAPI {

    @Autowired
    private ConversionHistoryBL conversionHistoryBL;

    @Autowired
    private ConversionStrategy conversionStrategy;

    @PostMapping("/convert")
    public ResponseEntity<ConversionHistory> convertAndSave(@RequestParam String fromCurrency, @RequestParam String toCurrency, @RequestParam Double amount, Authentication authentication) {
        try {
            Double convertedAmount = conversionStrategy.convert(fromCurrency, toCurrency, amount);
            return ResponseEntity.ok(conversionHistoryBL.convertAndSave(fromCurrency, toCurrency, convertedAmount));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public Page<ConversionHistory> getAllConversions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "conversionId") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return conversionHistoryBL.getAllConversions(pageable);
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

    @PutMapping("/{id}")
    public ResponseEntity<ConversionHistory> updateConversion(@PathVariable Integer id, @RequestBody ConversionHistory conversionHistory) {
        Optional<ConversionHistory> existingConversionOpt = conversionHistoryBL.getConversionById(id);
        if (!existingConversionOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        ConversionHistory existingConversion = existingConversionOpt.get();
        existingConversion.setConversionDate(conversionHistory.getConversionDate()); // Solo actualiza la fecha
        ConversionHistory updatedConversion = conversionHistoryBL.saveConversion(existingConversion);
        return ResponseEntity.ok(updatedConversion);
    }

    public void setConversionStrategy(ConversionStrategy strategy) {
        this.conversionStrategy = strategy;
    }
}
