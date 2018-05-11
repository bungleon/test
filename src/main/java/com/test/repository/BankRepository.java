package com.test.repository;

import com.test.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BankRepository extends JpaRepository<Bank, UUID> {
    Bank findBySwiftCode(String swiftCode);
    List<Bank> findAll();
}
