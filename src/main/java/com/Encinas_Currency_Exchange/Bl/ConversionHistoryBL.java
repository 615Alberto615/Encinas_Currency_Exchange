package com.Encinas_Currency_Exchange.Bl;

import com.Encinas_Currency_Exchange.Dao.ConversionHistoryDAO;
import com.Encinas_Currency_Exchange.Entity.ConversionHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConversionHistoryBL {

    @Autowired
    private ConversionHistoryDAO conversionHistoryDAO;

    public List<ConversionHistory> getAllConversions() {
        return conversionHistoryDAO.findAll();
    }

    public Optional<ConversionHistory> getConversionById(Integer id) {
        return conversionHistoryDAO.findById(id);
    }

    public ConversionHistory saveConversion(ConversionHistory conversionHistory) {
        return conversionHistoryDAO.save(conversionHistory);
    }

    public void deleteConversion(Integer id) {
        conversionHistoryDAO.deleteById(id);
    }
}