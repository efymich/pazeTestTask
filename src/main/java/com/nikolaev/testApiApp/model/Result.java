package com.nikolaev.testApiApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    String id;
    String paymentType = "DEPOSIT";
    String state;
    String paymentMethod = "BASIC_CARD";

    @DecimalMin(value = "1E-18", inclusive = false,message = "should be more than 1e-18")
    @DecimalMax(value = "999999.99",inclusive = false,message = "should be less than 999999.99")
    Double amount;

    @NotNull
    String currency;
    String redirectUrl;
}
