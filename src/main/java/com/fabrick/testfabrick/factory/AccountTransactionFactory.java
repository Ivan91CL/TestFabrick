package com.fabrick.testfabrick.factory;

import com.fabrick.testfabrick.entity.AccountTransactionEntity;
import com.fabrick.testfabrick.entity.TransactionTypeEntity;
import com.fabrick.testfabrick.model.getAccountTransactions.Transaction;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Component
public class AccountTransactionFactory {

    public List<AccountTransactionEntity> toEntityList(List<Transaction> transactionList){
        List<AccountTransactionEntity> entityList = new ArrayList<>();

        transactionList.forEach(t -> entityList.add(toEntity(t)));

        return entityList;
    }

    private AccountTransactionEntity toEntity(Transaction model){
        AccountTransactionEntity entity = new AccountTransactionEntity();
        entity.setTransactionId(model.getTransactionId());
        entity.setOperationId(model.getOperationId());
        entity.setAccountingDate(model.getAccountingDate());
        entity.setValueDate(model.getValueDate());
        entity.setAmount(model.getAmount());
        entity.setCurrency(model.getCurrency());
        entity.setDescription(model.getDescription());

        TransactionTypeEntity typeEntity = new TransactionTypeEntity();
        typeEntity.setEnumeration(model.getType().getEnumeration());
        typeEntity.setValue(model.getType().getValue());

        entity.setTransactionType(typeEntity);

        return entity;
    }
}
