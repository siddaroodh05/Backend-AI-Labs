package com.siddu.dtovalidation;


import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record Productdto(
        @NotNull(message = "enter id")
        Long id,
        @NotBlank(message = "name must not blanked")
        String name,
        String description,
        @NotNull(message = "enter price of product")
        @Positive(message = "price must be positive")
        BigDecimal price,
        @NotNull(message = "enter quanity of product")
        @Positive(message = "quanity must be greater then zero")
        Long quanity

){
}
