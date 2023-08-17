package com.Encinas_Currency_Exchange.Dao;

import com.Encinas_Currency_Exchange.Entity.ConversionHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConversionHistoryDAO {

    @Autowired
    private ConversionHistoryRepository conversionHistoryRepository;

    public List<ConversionHistory> findAll() {
        return conversionHistoryRepository.findAll();
    }

    public Optional<ConversionHistory> findById(Integer id) {
        return conversionHistoryRepository.findById(id);
    }

    public ConversionHistory save(ConversionHistory conversionHistory) {
        return conversionHistoryRepository.save(conversionHistory);
    }

    public void deleteById(Integer id) {
        conversionHistoryRepository.deleteById(id);
    }

}