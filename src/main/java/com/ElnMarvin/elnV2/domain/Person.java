package com.ElnMarvin.elnV2.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Person {
    @NotBlank(message = "ID is mandatory")
    private Long id;
    @NotNull(message = "First name is mandatory")
    private String firstName;
    private String lastName;
    private int age;

}

