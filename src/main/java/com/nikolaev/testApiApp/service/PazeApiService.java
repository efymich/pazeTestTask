package com.nikolaev.testApiApp.service;

import com.nikolaev.testApiApp.dto.PaymentApiDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class PazeApiService {

    private PaymentApiDTO paymentRequestBody;

    private final ExternalApiClient externalApiClient;

    public PazeApiService(PaymentApiDTO paymentRequestBody, ExternalApiClient externalApiClient) {
        this.paymentRequestBody = paymentRequestBody;
        this.externalApiClient = externalApiClient;
    }

    public PaymentApiDTO getResponse(String token) {
        return externalApiClient.fetchData("Bearer " + token, paymentRequestBody.getResult());
    }
}
