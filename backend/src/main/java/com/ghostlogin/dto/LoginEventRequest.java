package com.ghostlogin.dto;

import lombok.Data;

@Data
public class LoginEventRequest {
    private String auth0UserId;
    private String ipAddress;
    private String city;
    private String country;
    private String browser;
    private String os;
    private String deviceId;
}
