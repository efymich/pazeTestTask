package com.nikolaev.testApiApp.service;

import com.nikolaev.testApiApp.dto.RequestDTO;
import com.nikolaev.testApiApp.dto.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "paze-payment-api", url = "https://engine-sandbox.pay.tech")
public interface PazeApiClient {
	@PostMapping("api/v1/payments")
	ResponseDTO fetchData(@RequestHeader("Authorization") String authorizationHeader, RequestDTO requestDTO);
}
