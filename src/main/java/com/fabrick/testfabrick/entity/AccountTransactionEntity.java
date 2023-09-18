package com.fabrick.testfabrick.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity(name = "ACCOUNT_TRANSACTIONS")
public class AccountTransactionEntity {

    @Id
    private String transactionId;

    private String operationId;

    @Column(columnDefinition = "DATE")
    private Date accountingDate;

    @Column(columnDefinition = "DATE")
    private Date valueDate;

    @ManyToOne
    private TransactionTypeEntity transactionType;

    @Column(precision = 2, scale = 0)
    private float amount;

    private String currency;

    private String description;
}
