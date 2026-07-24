package com.khair.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "Response", description = "Data Transfer Object for API response status and message")
public class ResponseDto {

    @Schema(description = "HTTP status code of the response")
    private String statusCode;

    @Schema(description = "Message describing the status of the response")
    private String statusMessage;

}

