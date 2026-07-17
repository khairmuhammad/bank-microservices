package com.khair.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "Customer", description = "Data Transfer Object for Customer and Account details")
public class CustomerDto {

    @Schema(description = "Unique identifier for the customer", example = "1")
    @NotEmpty(message = "Name can not be null or empty.")
    @Size(min = 5, max = 30, message = "Name must be between 3 and 50 characters.")
    private String name;

    @Schema(description = "Email address of the customer", example = "john@gmail.com")
    @NotEmpty(message = "Email can not be null or empty.")
    @Email(message = "Email should be valid.")
    private String email;

    @Schema(description = "Mobile number of the customer", example = "9876543210")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits.")
    @NotEmpty(message = "Mobile number can not be null or empty.")
    private String mobileNumber;

    @Schema(description = "Account details associated with the customer")
    private AccountsDto accountsDto;
}
