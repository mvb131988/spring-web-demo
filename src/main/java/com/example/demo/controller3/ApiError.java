package com.example.demo.controller3;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ApiError (
        @JsonProperty("Code") String code,
        @JsonProperty("Message") String message) {
    
}
