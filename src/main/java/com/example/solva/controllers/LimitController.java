package com.example.solva.controllers;

import com.example.solva.models.Limit;
import com.example.solva.services.LimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/limits")
public class LimitController {
    @Autowired
    private LimitService limitService;

    @PostMapping
    public Limit createLimit(@RequestBody Limit limit) {
        return limitService.saveLimit(limit);
    }

    @GetMapping
    public List<Limit> getAllLimits() {
        return limitService.getAllLimits();
    }

    @GetMapping("/{id}")
    public Limit getLimitById(@PathVariable Long id) {
        return limitService.getLimitById(id);
    }

    @GetMapping("/category/{category}")
    public List<Limit> getLimitsByCategory(@PathVariable String category) {
        return limitService.getLimitsByCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteLimit(@PathVariable Long id) {
        limitService.deleteLimit(id);
    }
}