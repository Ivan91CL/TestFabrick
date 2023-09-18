package com.fabrick.testfabrick.repository;

import com.fabrick.testfabrick.entity.AccountTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionsRepository extends JpaRepository<AccountTransactionEntity, String> {
}
