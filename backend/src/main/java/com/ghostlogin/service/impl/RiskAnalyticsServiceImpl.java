package com.ghostlogin.service.impl;

import com.ghostlogin.dto.RiskSummaryDTO;
import com.ghostlogin.model.RiskAnalytics;
import com.ghostlogin.repository.RiskAnalyticsRepository;
import com.ghostlogin.service.RiskAnalyticsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RiskAnalyticsServiceImpl implements RiskAnalyticsService {

    private final RiskAnalyticsRepository riskAnalyticsRepository;

    public RiskAnalyticsServiceImpl(RiskAnalyticsRepository riskAnalyticsRepository) {
        this.riskAnalyticsRepository = riskAnalyticsRepository;
    }

    @Override
    public RiskSummaryDTO getRiskSummary(String auth0UserId) {
        RiskAnalytics analytics = riskAnalyticsRepository.findByAuth0UserId(auth0UserId).orElse(null);
        RiskSummaryDTO dto = new RiskSummaryDTO();
        if (analytics != null) {
            dto.setAuth0UserId(auth0UserId);
            dto.setDailySummary(analytics.getDailySummary());
            dto.setLast24HoursRisk(analytics.getLast24HoursRisk());
            dto.setHighRiskCount(analytics.getHighRiskCount());
        } else {
            dto.setAuth0UserId(auth0UserId);
            dto.setDailySummary(Collections.emptyMap());
        }
        return dto;
    }

    @Override
    public Object getDeviceMismatchStats(String auth0UserId) {
        RiskAnalytics analytics = riskAnalyticsRepository.findByAuth0UserId(auth0UserId).orElse(null);
        if (analytics == null) return Collections.emptyMap();
        return Collections.singletonMap("deviceMismatchCount", analytics.getDeviceMismatchCount());
    }
}
