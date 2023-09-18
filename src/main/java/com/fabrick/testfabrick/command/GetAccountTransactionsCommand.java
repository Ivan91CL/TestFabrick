package com.fabrick.testfabrick.command;

import com.fabrick.testfabrick.dto.getAccountTransactions.GetAccountTransactionsRequestDto;
import com.fabrick.testfabrick.model.getAccountBalance.FabrickResponseGetAccountBalance;
import com.fabrick.testfabrick.model.getAccountTransactions.FabrickResponseGetAccountTransactions;
import com.fabrick.testfabrick.service.AccountService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
@Scope("prototype")
public class GetAccountTransactionsCommand {

    private static final Logger logger = LoggerFactory.getLogger(GetAccountTransactionsCommand.class);

    private GetAccountTransactionsRequestDto dto;

    @Autowired
    private AccountService accountService;

    public GetAccountTransactionsCommand(){}

    public GetAccountTransactionsCommand(GetAccountTransactionsRequestDto dto){
        super();
        this.dto = dto;
    }

    public FabrickResponseGetAccountTransactions execute(){
        logger.info("[COMMAND] GetAccountTransactionsCommand --- [METHOD] execute");
        return accountService.getAccountTransactions(dto);
    }
}
