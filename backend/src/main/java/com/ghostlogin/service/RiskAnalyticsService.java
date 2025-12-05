package com.ghostlogin.service;

import com.ghostlogin.dto.RiskSummaryDTO;

public interface RiskAnalyticsService {
    RiskSummaryDTO getRiskSummary(String auth0UserId);
    Object getDeviceMismatchStats(String auth0UserId);
}
