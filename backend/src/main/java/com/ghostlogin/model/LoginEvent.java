package com.ghostlogin.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@NoArgsConstructor
@Document(collection = "login_events")
public class LoginEvent {
    @Id
    private String id;
    private String auth0UserId;
    private String ipAddress;
    private Location location;
    private DeviceInfo deviceInfo;
    private Instant timestamp = Instant.now();
    private int riskScore;
    private Status status = Status.SUSPICIOUS;

    public enum Status { APPROVED, DENIED, SUSPICIOUS }

    @Data
    @NoArgsConstructor
    public static class Location {
        private String city;
        private String country;
    }

    @Data
    @NoArgsConstructor
    public static class DeviceInfo {
        private String browser;
        private String os;
        private String deviceId;
    }
}
