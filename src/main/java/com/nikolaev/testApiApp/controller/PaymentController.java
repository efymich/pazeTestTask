package com.nikolaev.testApiApp.controller;

import com.nikolaev.testApiApp.dto.PaymentApiDTO;
import com.nikolaev.testApiApp.service.PazeApiService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PaymentController {

    private final PazeApiService apiService;

    @Value("${currencies}")
    private final List<String> currencies;

    public PaymentController(PazeApiService apiService, List<String> currencies) {
        this.apiService = apiService;
        this.currencies = currencies;
    }

    @GetMapping("/payments")
    public String showForm(Model model) {

        model.addAttribute("paymentBodyRequest", apiService.getPaymentRequestBody());
        model.addAttribute("currencies",currencies);

        return "payment";
    }

    @PostMapping(value = "/payments",consumes = {"application/x-www-form-urlencoded"})
    public String pay(@ModelAttribute("paymentBodyRequest") PaymentApiDTO paymentRequestBody, @Value("${paze-api.bearer-token}") String token) {
        apiService.setPaymentRequestBody(paymentRequestBody);
        try {
            PaymentApiDTO response = apiService.getResponse(token);
            return "redirect:" + response.getResult().getRedirectUrl();
        } catch (FeignException e) {
            if (e.status() == HttpStatus.BAD_REQUEST.value() || e.status() == HttpStatus.UNAUTHORIZED.value()) {
                return "error-template";
            } else {
                e.getStackTrace();
                throw e;
            }
        }
    }
}
