package com.josedev.productAPI.dto;

public record ErrorResponse(int status, String error, String message) {
}
