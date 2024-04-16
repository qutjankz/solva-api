package com.example.solva.services;

import com.example.solva.models.Limit;
import com.example.solva.repositories.LimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class LimitService {
    @Autowired
    private LimitRepository limitRepository;

    public boolean checkLimitExceeded(Double amount, String currency, LocalDate date) {
        Optional<Limit> optionalLimit = limitRepository.findByCurrencyAndCategory(currency, "goods");

        Limit limit = optionalLimit.orElseGet(() -> {
            Limit newLimit = new Limit();
            newLimit.setAmount(1000.0);
            return newLimit;
        });

        return amount > limit.getAmount();
    }
    public Limit saveLimit(Limit limit) {
        return limitRepository.save(limit);
    }

    public List<Limit> getAllLimits() {
        return limitRepository.findAll();
    }

    public Limit getLimitById(Long id) {
        return limitRepository.findById(id).orElse(null);
    }

    public List<Limit> getLimitsByCategory(String category) {
        return limitRepository.findByCategoryAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                category, LocalDate.now(), LocalDate.now());
    }

    public void deleteLimit(Long id) {
        limitRepository.deleteById(id);
    }
}