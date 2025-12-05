package com.ghostlogin.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@Component
public class DeviceFingerprintUtil {
    public String fingerprintFromHeaders(String browser, String os, String deviceId) {
        try {
            String base = StringUtils.defaultString(browser) + "|" + StringUtils.defaultString(os) + "|" + StringUtils.defaultString(deviceId);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(base.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            return String.valueOf(baseHashFallback(browser, os, deviceId));
        }
    }

    private int baseHashFallback(String a, String b, String c) {
        return (a + b + c).hashCode();
    }
}
