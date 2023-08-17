package com.Encinas_Currency_Exchange.Bl;

import com.Encinas_Currency_Exchange.Dao.ConversionHistoryDAO;
import com.Encinas_Currency_Exchange.Dao.CurrencyDAO;
import com.Encinas_Currency_Exchange.Entity.ConversionHistory;
import com.Encinas_Currency_Exchange.Entity.Currency;
import com.Encinas_Currency_Exchange.Service.CurrencyApiService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ConversionHistoryBL {

    @Autowired
    private ConversionHistoryDAO conversionHistoryDAO;
    @Autowired
    private CurrencyApiService currencyApiService;
    @Autowired
    private CurrencyDAO currencyDAO;
    private static final Logger logger = LoggerFactory.getLogger(ConversionHistoryBL.class);

    @Transactional
    public ConversionHistory convertAndSave(String fromCurrencyCode, String toCurrencyCode, double amount) {
        logger.info("Iniciando conversión de {} a {} con cantidad {}", fromCurrencyCode, toCurrencyCode, amount);

        Double exchangeRate = currencyApiService.getExchangeRate(fromCurrencyCode, toCurrencyCode);

        if (exchangeRate == null) {
            logger.warn("No se pudo obtener la tasa de cambio para {} a {}", fromCurrencyCode, toCurrencyCode);
            return null;
        }

        ConversionHistory conversion = new ConversionHistory();

        conversion.setFromCurrencyCode(fromCurrencyCode);
        conversion.setToCurrencyCode(toCurrencyCode);
        conversion.setAmount(BigDecimal.valueOf(amount));
        conversion.setConvertedAmount(BigDecimal.valueOf(amount * exchangeRate));
        conversion.setConversionDate(new Date());

        logger.info("Guardando la conversión en la base de datos");
        return conversionHistoryDAO.save(conversion);
    }

    public List<ConversionHistory> getAllConversions() {
        logger.info("Obteniendo todas las conversiones");
        return conversionHistoryDAO.findAll();
    }

    public Optional<ConversionHistory> getConversionById(Integer id) {
        logger.info("Buscando conversión por ID: {}", id);
        return conversionHistoryDAO.findById(id);
    }

    public ConversionHistory saveConversion(ConversionHistory conversionHistory) {
        logger.info("Guardando la conversión: {}", conversionHistory);
        return conversionHistoryDAO.save(conversionHistory);
    }

    public void deleteConversion(Integer id) {
        logger.info("Eliminando la conversión con ID: {}", id);
        conversionHistoryDAO.deleteById(id);
    }
}
