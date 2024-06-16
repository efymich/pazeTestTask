package com.nikolaev.testApiApp.controller;

import com.nikolaev.testApiApp.config.AppConfig;
import com.nikolaev.testApiApp.dto.RequestDTO;
import com.nikolaev.testApiApp.dto.ResponseDTO;
import com.nikolaev.testApiApp.service.PaymentService;
import feign.FeignException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class PaymentController {

	private final AppConfig appConfig;

	private final PaymentService paymentService;

	@GetMapping("/payments")
	public String showForm(Model model) {
		model.addAttribute("requestDTO", new RequestDTO());
		model.addAttribute("currencies", appConfig.getCurrencies());
		return "payment";
	}

	@PostMapping(value = "/pay", consumes = {"application/x-www-form-urlencoded"})
	public String pay(@Valid @ModelAttribute("requestDTO") RequestDTO requestDTO,
					  BindingResult bindingResult,
					  Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("currencies", appConfig.getCurrencies());
			return "payment";
		}

		try {
			ResponseDTO response = paymentService.getResponse(requestDTO);
			return "redirect:" + response.getResult().getRedirectUrl();
		} catch (FeignException e) {
			if (e.status() == HttpStatus.BAD_REQUEST.value() || e.status() == HttpStatus.UNAUTHORIZED.value()) {
				model.addAttribute("message", e.getMessage());
				return "error-template";
			} else {
				e.getStackTrace();
				throw e;
			}
		}
	}
}
