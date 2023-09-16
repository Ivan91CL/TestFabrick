package com.fabrick.testfabrick.command;

import com.fabrick.testfabrick.model.FabrickResponseGetAccountBalance;
import com.fabrick.testfabrick.service.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
@Scope("prototype")
public class GetAccountBalanceCommand {

    private Long accountId;

    @Autowired
    private AccountService accountService;

    public GetAccountBalanceCommand(){}

    public GetAccountBalanceCommand(Long accountId){
        super();
        this.accountId = accountId;
    }

    public FabrickResponseGetAccountBalance execute(){
        return accountService.getAccountBalance(accountId);
    }
}
