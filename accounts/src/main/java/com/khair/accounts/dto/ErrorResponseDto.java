package com.khair.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Schema(name = "ErrorResponse", description = "Data Transfer Object for API error response details")
@AllArgsConstructor
public class ErrorResponseDto {

    @Schema(description = "API path where the error occurred", example = "/api/v1/account/create")
    private String apiPath;

    @Schema(description = "HTTP status of the error response", example = "400 BAD_REQUEST")
    private HttpStatus errorStatus;

    @Schema(description = "Error message describing the reason for the error", example = "Invalid input data.")
    private String errorMessage;

    @Schema(description = "Timestamp when the error occurred", example = "2024-06-15T14:30:00")
    private LocalDateTime errorTime;
}
