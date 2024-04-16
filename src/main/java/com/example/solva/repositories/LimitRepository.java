package com.example.solva.repositories;

import com.example.solva.models.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface LimitRepository extends JpaRepository<Limit, Long> {
    List<Limit> findByCategoryAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            String category, LocalDate startDate, LocalDate endDate);
    Optional<Limit> findByCurrencyAndCategory(String currencyCode, String category);

}