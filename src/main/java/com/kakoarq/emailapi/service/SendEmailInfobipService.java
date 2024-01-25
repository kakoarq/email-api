package com.kakoarq.emailapi.service;

import com.kakoarq.emailapi.model.EmailReciverDTO;

public interface SendEmailInfobipService {
    void emailSender(EmailReciverDTO emailReciver);
}
