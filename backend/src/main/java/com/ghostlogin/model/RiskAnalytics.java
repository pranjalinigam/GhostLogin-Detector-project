package com.ghostlogin.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Map;

@Data
@NoArgsConstructor
@Document(collection = "risk_analytics")
public class RiskAnalytics {
    @Id
    private String id;
    private String auth0UserId;
    private Map<String, Integer> dailySummary; // date -> score or count
    private int last24HoursRisk;
    private int highRiskCount;
    private int deviceMismatchCount;
    private Instant updatedAt = Instant.now();
}
