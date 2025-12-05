package com.ghostlogin.dto;

import lombok.Data;

import java.util.Map;

@Data
public class RiskSummaryDTO {
    private String auth0UserId;
    private Map<String, Integer> dailySummary;
    private int last24HoursRisk;
    private int highRiskCount;
}
