package com.khair.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(name = "Accounts", description = "Data Transfer Object for Account details")
public class AccountsDto {

    @Schema(description = "Account number associated with the customer")
    @Pattern(regexp = "^[0-9]{10}$", message = "Account number must be 10 digits.")
    @NotEmpty(message = "Account number can not be null or empty.")
    private Long accountNumber;

    @Schema(description = "Account type associated with the customer", example = "Savings")
    @NotEmpty(message = "Account type can not be null or empty.")
    private String accountType;

    @Schema(description = "Branch address associated with the customer", example = "123 Main St, City, Country")
    @NotEmpty(message = "Branch address can not be null or empty.")
    private String branchAddress;
}
