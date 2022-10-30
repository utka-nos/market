package com.utkanos.api;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiResponse {
    private final int status;
    private final String message;
}
