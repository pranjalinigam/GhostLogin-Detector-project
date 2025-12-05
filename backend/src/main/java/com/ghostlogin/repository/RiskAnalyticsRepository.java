package com.ghostlogin.repository;

import com.ghostlogin.model.RiskAnalytics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiskAnalyticsRepository extends MongoRepository<RiskAnalytics, String> {
    Optional<RiskAnalytics> findByAuth0UserId(String auth0UserId);
}
