package com.example.demo.common;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public record Company(
    @JsonProperty("Name") String name,
    @JsonProperty("CategoryId") BigInteger categoryId,
    @JsonProperty("ChannelType") ChannelType channelType,
    @JsonProperty("QueryUuid") UUID queryUuid,
    @JsonProperty("IsWhiteListed") Boolean isWhiteListed,
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
    @JsonProperty("RegistrationTime") 
    LocalDateTime registrationTime) {

}