package com.kakoarq.emailapi.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmailReciverDTO {
    /**
     Email do destinatario
     */
    private String emailReceiver;

    /**
     corpo do email
     */
    private String bodyEmail;

    /**
     cabecalho de email
     */
    private String emailSubject;

    /**
     Primeiro nome
     */
    private String firstName;

    /**
     ultimo nome
     */
    private String lastName;
}
