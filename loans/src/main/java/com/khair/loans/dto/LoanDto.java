package com.khair.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(name = "Loan", description = "Data Transfer Object for Loan details")
@Data
public class LoanDto {

    @Schema(description = "Mobile number of the customer", example = "9876543210")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits.")
    @NotEmpty(message = "Mobile number can not be null or empty.")
    private String mobileNumber;

    @Schema(description = "Loan number associated with the customer", example = "123456789012")
    @Pattern(regexp = "^[0-9]{12}$", message = "Loan number must be 12 digits.")
    @NotEmpty(message = "Loan number can not be null or empty.")
    private String loanNumber;

    @Schema(description = "Type of loan", example = "Home Loan")
    @NotEmpty(message = "Loan type can not be null or empty.")
    private String loanType;

    @Positive(message = "Total loan amount must be positive.")
    @Schema(description = "Total loan amount", example = "500000")
    private int totalLoan;

    @PositiveOrZero(message = "Amount paid towards the loan must be zero or positive.")
    @Schema(description = "Amount paid towards the loan", example = "200000")
    private int amountPaid;

    @PositiveOrZero(message = "Outstanding amount must be zero or positive.")
    @Schema(description = "Outstanding amount of the loan", example = "300000")
    private int outstandingAmount;

}
