package com.ghostlogin.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "user_profiles")
public class UserProfile {
    @Id
    private String id;
    private String auth0UserId;
    private String email;
    private List<TrustedDevice> trustedDevices = new ArrayList<>();
    private Instant createdAt = Instant.now();

    @Data
    @NoArgsConstructor
    public static class TrustedDevice {
        private String deviceId;
        private String deviceType;
        private Instant addedOn = Instant.now();
    }
}
