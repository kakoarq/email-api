package com.kakoarq.emailapi.controller;

import com.kakoarq.emailapi.model.EmailReciverDTO;
import com.kakoarq.emailapi.service.SendEmailInfobipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email-api")
public class EmailReciverController {

    @Autowired
    private SendEmailInfobipService sendEmailInfobipService;

    @PostMapping(path = "/envio-email")
    public ResponseEntity <Void> sendEmail(@RequestBody EmailReciverDTO emailReciver ){
        sendEmailInfobipService.emailSender(emailReciver);
        return null;
    }
}
