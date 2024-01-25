package com.kakoarq.emailapi.controller;

import com.kakoarq.emailapi.model.EmailReciverDTO;
import com.kakoarq.emailapi.service.SendEmailInfobipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email-api")
public class EmailReciverController {

    @Autowired
    private SendEmailInfobipService sendEmailInfobipService;

    @CrossOrigin (origins =  "https://kakoarq.com.br/")
    @PostMapping(path = "/envio-email")
    public ResponseEntity <Void> sendEmail(@RequestBody EmailReciverDTO emailReciver ){
        sendEmailInfobipService.emailSender(emailReciver);
        return null;
    }
}
