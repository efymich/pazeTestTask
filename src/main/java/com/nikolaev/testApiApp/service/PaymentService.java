package com.nikolaev.testApiApp.service;

import com.nikolaev.testApiApp.config.AppConfig;
import com.nikolaev.testApiApp.dto.RequestDTO;
import com.nikolaev.testApiApp.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

	private final AppConfig appConfig;

	private final PazeApiClient pazeApiClient;

	public ResponseDTO getResponse(RequestDTO requestDTO) {
		return pazeApiClient.fetchData("Bearer " + appConfig.getToken(), requestDTO);
	}
}
