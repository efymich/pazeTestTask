package com.nikolaev.testApiApp.service;

import com.nikolaev.testApiApp.dto.PaymentApiDTO;
import com.nikolaev.testApiApp.model.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "paze-payment-api", url = "https://engine-sandbox.pay.tech")
public interface ExternalApiClient {
    @PostMapping("api/v1/payments")
    PaymentApiDTO fetchData(@RequestHeader("Authorization") String authorizationHeader, Result requestBody);
}
