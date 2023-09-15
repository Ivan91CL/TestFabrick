package com.fabrick.testfabrick.controller;


import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private BeanFactory beanFactory;

    @GetMapping("/getAccountInfo")
    public String getAccountInfo(@RequestParam(value = "accountId") Long accountId) {

        return accountId.toString();
    }

}
