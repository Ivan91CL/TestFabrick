package com.fabrick.testfabrick.controller;


import com.fabrick.testfabrick.assembler.GetAccountBalanceResponseAssembler;
import com.fabrick.testfabrick.command.GetAccountBalanceCommand;
import com.fabrick.testfabrick.dto.GetAccountBalanceResponseDto;
import com.fabrick.testfabrick.model.FabrickResponseGetAccountBalance;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Data
@RequestMapping(value = "/fabrick", produces = {"application/json"})
public class FabrickController {

    private static final Logger logger = LoggerFactory.getLogger(FabrickController.class);

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private GetAccountBalanceResponseAssembler getAccountBalanceResponseAssembler;


    @GetMapping("/getAccountBalance")
    public ResponseEntity<GetAccountBalanceResponseDto> getAccountBalance(@RequestParam(value = "accountId") Long accountId) {

        GetAccountBalanceCommand command = applicationContext.getBean(GetAccountBalanceCommand.class, accountId);
        FabrickResponseGetAccountBalance fabrickResponse = command.execute();
        ((ConfigurableApplicationContext) applicationContext).getBeanFactory().destroyBean(command);
        GetAccountBalanceResponseDto response = getAccountBalanceResponseAssembler.convertToDto(fabrickResponse);
        return ResponseEntity.ok(response);
    }

}
