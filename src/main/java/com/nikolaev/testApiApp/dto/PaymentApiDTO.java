package com.nikolaev.testApiApp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.nikolaev.testApiApp.model.Result;

@Component
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class PaymentApiDTO {

    Integer status;
    Result result;

    @Autowired
    public PaymentApiDTO(Result result) {
        this.result = result;
    }
}
