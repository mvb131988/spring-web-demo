package com.example.demo.common;

public enum ChannelType {
    
    PHONE("Phone"),
    MAIL("Mail"),
    MANUAL("Manual");

    public final String type;

    ChannelType(String type) {
        this.type = type;
    }
}
