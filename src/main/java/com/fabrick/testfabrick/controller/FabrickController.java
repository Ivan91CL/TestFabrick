package com.fabrick.testfabrick.controller;


import com.fabrick.testfabrick.assembler.CreateMoneyTransferAssembler;
import com.fabrick.testfabrick.assembler.GetAccountBalanceAssembler;
import com.fabrick.testfabrick.command.CreateMoneyTransferCommand;
import com.fabrick.testfabrick.command.GetAccountBalanceCommand;
import com.fabrick.testfabrick.dto.createMoneyTransfer.CreateMoneyTransferRequestDto;
import com.fabrick.testfabrick.dto.createMoneyTransfer.CreateMoneyTransferResponseDto;
import com.fabrick.testfabrick.dto.getAccountBalance.GetAccountBalanceResponseDto;
import com.fabrick.testfabrick.dto.ResponseDto;
import com.fabrick.testfabrick.exception.CustomException;
import com.fabrick.testfabrick.exception.ErrorManager;
import com.fabrick.testfabrick.model.getAccountBalance.FabrickResponseGetAccountBalance;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Data
@RequestMapping(value = "/fabrick", produces = {"application/json"})
public class FabrickController {

    private static final Logger logger = LoggerFactory.getLogger(FabrickController.class);

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private GetAccountBalanceAssembler getAccountBalanceAssembler;
    @Autowired
    private CreateMoneyTransferAssembler createMoneyTransferAssembler;


    @GetMapping("/getAccountBalance")
    public ResponseEntity<ResponseDto> getAccountBalance(@RequestParam(value = "accountId") Long accountId) {

        try {
            GetAccountBalanceCommand command = applicationContext.getBean(GetAccountBalanceCommand.class, accountId);
            FabrickResponseGetAccountBalance fabrickResponse = command.execute();
            ((ConfigurableApplicationContext) applicationContext).getBeanFactory().destroyBean(command);
            GetAccountBalanceResponseDto response = getAccountBalanceAssembler.convertResponseToDto(fabrickResponse);
            return ResponseEntity.ok(response);
        }catch (CustomException e){
            return ErrorManager.generateErrorMessage(e);
        }
    }

    @PostMapping("/createMoneyTransfer")
    public ResponseEntity<ResponseDto> createMoneyTransfer(@RequestBody CreateMoneyTransferRequestDto requestDto) {

        try {
            CreateMoneyTransferCommand command = applicationContext.getBean(CreateMoneyTransferCommand.class, createMoneyTransferAssembler.convertDtoToRequest(requestDto), requestDto.getAccountId());
            ResponseEntity fabrickResponse = command.execute();
            ((ConfigurableApplicationContext) applicationContext).getBeanFactory().destroyBean(command);
            CreateMoneyTransferResponseDto response = createMoneyTransferAssembler.convertResponseToDto(fabrickResponse);
            return ResponseEntity.ok(response);
        }catch (CustomException e){
            return ErrorManager.generateErrorMessage(e);
        }
    }

}
