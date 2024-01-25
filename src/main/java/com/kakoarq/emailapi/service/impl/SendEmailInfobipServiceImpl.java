package com.kakoarq.emailapi.service.impl;

import com.kakoarq.emailapi.constant.RequestHeaders;
import com.kakoarq.emailapi.model.EmailReciverDTO;

import com.kakoarq.emailapi.service.SendEmailInfobipService;
import okhttp3.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendEmailInfobipServiceImpl implements SendEmailInfobipService {

    @Value("${url.infobip}")
    private  String infobipUrl;

    @Value("${api.key}")
    private  String apiKey;

    @Value("${api.emailfrom}")
    private  String fromEmail;

    @Override
    public void emailSender(EmailReciverDTO emailReceiver) {
        OkHttpClient client = new OkHttpClient();

        RequestBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("from", fromEmail)
                .addFormDataPart("to", fromEmail)
                .addFormDataPart("subject", emailReceiver.getFirstName() + " "+ emailReceiver.getLastName() + " Entrou em contato no dia")
                .addFormDataPart("text", emailReceiver.getBodyEmail())
                .build();

        Request request = buildInfobipApiEmailRequest(body);
        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.code());
            assert response.body() != null;
            System.out.println(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Request buildInfobipApiEmailRequest(RequestBody body) {
        return new Request.Builder()
                .url(String.format("%s/email/3/send", infobipUrl))
                .method("POST", body)
                .addHeader(RequestHeaders.AUTHORIZATION.getHeaderName(), apiKey)
                .addHeader(RequestHeaders.CONTENT_TYPE.getHeaderName(), "text/plain")
                .addHeader(RequestHeaders.ACCEPT.getHeaderName(), "application/json")
                .build();
    }
}
