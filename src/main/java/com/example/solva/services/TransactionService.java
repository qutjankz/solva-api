package com.example.solva.services;

import com.example.solva.models.Transaction;
import com.example.solva.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private LimitService limitService;
    public Transaction createTransaction(Transaction transaction) {
        boolean limitExceeded = limitService.checkLimitExceeded(transaction.getAmount(), transaction.getCurrency(), transaction.getDate());

        transaction.setLimitExceeded(limitExceeded);
        return transactionRepository.save(transaction);
    }
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Transaction not found with id: " + id));
    }

    public List<Transaction> getTransactionsExceedingLimit() {
        return transactionRepository.findByLimitExceeded(true);
    }
}