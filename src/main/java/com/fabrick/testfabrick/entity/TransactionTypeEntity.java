package com.fabrick.testfabrick.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "TRANSACTION_TYPES")
public class TransactionTypeEntity {

    @Id
    private String enumeration;

    private String value;
}
