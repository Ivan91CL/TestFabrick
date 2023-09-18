package com.fabrick.testfabrick.command;

import com.fabrick.testfabrick.model.createMoneyTransfer.FabrickRequestCreateMoneyTransfer;
import com.fabrick.testfabrick.model.getAccountBalance.FabrickResponseGetAccountBalance;
import com.fabrick.testfabrick.service.MoneyTransferService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Data
@Scope("prototype")
public class CreateMoneyTransferCommand {

    private static final Logger logger = LoggerFactory.getLogger(CreateMoneyTransferCommand.class);

    private FabrickRequestCreateMoneyTransfer request;
    private Number accountId;

    @Autowired
    private MoneyTransferService moneyTransferService;

    public CreateMoneyTransferCommand(){}

    public CreateMoneyTransferCommand(FabrickRequestCreateMoneyTransfer request, Number accountId){
        super();
        this.request = request;
        this.accountId = accountId;
    }

    public ResponseEntity execute(){
        logger.info("[COMMAND] CreateMoneyTransferCommand --- [METHOD] execute");
        return moneyTransferService.createMoneyTransfer(request, accountId);
    }
}
