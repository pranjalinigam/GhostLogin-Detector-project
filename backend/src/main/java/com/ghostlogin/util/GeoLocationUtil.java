package com.ghostlogin.util;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.Map;

@Component
public class GeoLocationUtil {
    private final WebClient client = WebClient.create("http://ip-api.com/json/");

    public GeoResult lookup(String ip) {
        try {
            Map<String, Object> resp = client.get()
                    .uri(ip)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block(Duration.ofSeconds(5));
            if (resp == null) return new GeoResult("", "");
            String city = resp.getOrDefault("city", "").toString();
            String country = resp.getOrDefault("country", "").toString();
            return new GeoResult(city, country);
        } catch (Exception e) {
            return new GeoResult("", "");
        }
    }

    public record GeoResult(String city, String country) {}
}
