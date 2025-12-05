package com.ghostlogin.controller;

import com.ghostlogin.dto.RiskSummaryDTO;
import com.ghostlogin.service.RiskAnalyticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final RiskAnalyticsService riskAnalyticsService;

    public AnalyticsController(RiskAnalyticsService riskAnalyticsService) {
        this.riskAnalyticsService = riskAnalyticsService;
    }

    @GetMapping("/risk-summary")
    public ResponseEntity<RiskSummaryDTO> riskSummary(@RequestParam String auth0UserId) {
        return ResponseEntity.ok(riskAnalyticsService.getRiskSummary(auth0UserId));
    }

    @GetMapping("/device-mismatch-stats")
    public ResponseEntity<?> deviceMismatch(@RequestParam String auth0UserId) {
        return ResponseEntity.ok(riskAnalyticsService.getDeviceMismatchStats(auth0UserId));
    }
}
