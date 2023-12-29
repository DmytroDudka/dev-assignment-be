package com.transferz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class AirportDto {

    @NotNull(message = "Name must not be null")
    @NotBlank(message = "Name must not be blank")
    @Size(max = 255, message = "Name's size must be between 0 and 255")
    private String name;

    @NotNull(message = "Code must not be null")
    @NotBlank(message = "Code must not be blank")
    @Size(max = 20, message = "Code's size must be between 0 and 20")
    private String code;

    @NotNull(message = "Country must not be null")
    @NotBlank(message = "Country must not be blank")
    @Size(max = 60, message = "Country's size must be between 0 and 60")
    private String country;

}
