package com.fabrick.testfabrick.repository;

import com.fabrick.testfabrick.entity.AccountTransactionEntity;
import com.fabrick.testfabrick.entity.TransactionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypesRepository extends JpaRepository<TransactionTypeEntity, String> {
}
