package com.nikolaev.testApiApp.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestDTO {
	String paymentType = "DEPOSIT";
	String paymentMethod = "BASIC_CARD";

	@DecimalMin(value = "1E-18", inclusive = false,message = "should be more than 1e-18")
	@DecimalMax(value = "999999.99",inclusive = false,message = "should be less than 999999.99")
	Double amount;

	@NotNull(message = "should be not null")
	String currency;
}
