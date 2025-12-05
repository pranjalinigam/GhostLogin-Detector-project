package com.ghostlogin.util;

import com.ghostlogin.model.LoginEvent;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
public class RiskCalculator {

    /**
     * Very simple heuristic-based risk score 0-100
     */
    public int calculateRisk(LoginEvent current, LoginEvent previous) {
        int score = 0;

        // IP or geo change
        if (previous != null) {
            String prevCity = previous.getLocation() == null ? "" : previous.getLocation().getCity();
            String curCity = current.getLocation() == null ? "" : current.getLocation().getCity();
            if (!prevCity.equalsIgnoreCase(curCity)) score += 30;

            String prevDevice = previous.getDeviceInfo() == null ? "" : previous.getDeviceInfo().getDeviceId();
            String curDevice = current.getDeviceInfo() == null ? "" : current.getDeviceInfo().getDeviceId();
            if (!prevDevice.equals(curDevice)) score += 20;

            // time anomaly (short interval)
            Duration dur = Duration.between(previous.getTimestamp(), current.getTimestamp());
            if (Math.abs(dur.toHours()) < 2) score += 10;
        } else {
            // first seen: baseline low risk
            score += 10;
        }

        // device/browser unknown
        if (current.getDeviceInfo() == null || current.getDeviceInfo().getDeviceId() == null) score += 15;

        // clamp
        return Math.min(100, Math.max(0, score));
    }
}
