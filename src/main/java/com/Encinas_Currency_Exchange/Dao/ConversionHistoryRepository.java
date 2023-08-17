package com.Encinas_Currency_Exchange.Dao;


import com.Encinas_Currency_Exchange.Entity.ConversionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionHistoryRepository extends JpaRepository<ConversionHistory, Integer> {
}
