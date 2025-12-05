package com.ghostlogin.service.impl;

import com.ghostlogin.dto.LoginEventRequest;
import com.ghostlogin.model.LoginEvent;
import com.ghostlogin.repository.LoginEventRepository;
import com.ghostlogin.repository.RiskAnalyticsRepository;
import com.ghostlogin.service.LoginEventService;
import com.ghostlogin.util.GeoLocationUtil;
import com.ghostlogin.util.RiskCalculator;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginEventRepository;
    private final RiskCalculator riskCalculator;
    private final GeoLocationUtil geoLocationUtil;
    private final RiskAnalyticsRepository riskAnalyticsRepository;

    public LoginEventServiceImpl(LoginEventRepository loginEventRepository, RiskCalculator riskCalculator, GeoLocationUtil geoLocationUtil, RiskAnalyticsRepository riskAnalyticsRepository) {
        this.loginEventRepository = loginEventRepository;
        this.riskCalculator = riskCalculator;
        this.geoLocationUtil = geoLocationUtil;
        this.riskAnalyticsRepository = riskAnalyticsRepository;
    }

    @Override
    public LoginEvent createEvent(LoginEventRequest req) {
        LoginEvent ev = new LoginEvent();
        ev.setAuth0UserId(req.getAuth0UserId());
        ev.setIpAddress(req.getIpAddress());
        LoginEvent.Location loc = new LoginEvent.Location();
        loc.setCity(req.getCity());
        loc.setCountry(req.getCountry());
        ev.setLocation(loc);
        LoginEvent.DeviceInfo di = new LoginEvent.DeviceInfo();
        di.setBrowser(req.getBrowser());
        di.setOs(req.getOs());
        di.setDeviceId(req.getDeviceId());
        ev.setDeviceInfo(di);
        ev.setTimestamp(Instant.now());

        // find last event
        List<LoginEvent> prev = loginEventRepository.findTop20ByAuth0UserIdOrderByTimestampDesc(ev.getAuth0UserId());
        LoginEvent previous = prev.isEmpty() ? null : prev.get(0);

        int score = riskCalculator.calculateRisk(ev, previous);
        ev.setRiskScore(score);
        if (score > 60) ev.setStatus(LoginEvent.Status.SUSPICIOUS);
        else ev.setStatus(LoginEvent.Status.APPROVED);

        LoginEvent saved = loginEventRepository.save(ev);

        // update analytics (best-effort)
        // (left simple - placeholder)

        return saved;
    }

    @Override
    public List<LoginEvent> recent(String auth0UserId) {
        return loginEventRepository.findTop20ByAuth0UserIdOrderByTimestampDesc(auth0UserId);
    }

    @Override
    public void updateStatus(String id, LoginEvent.Status status) {
        loginEventRepository.findById(id).ifPresent(ev -> {
            ev.setStatus(status);
            loginEventRepository.save(ev);
        });
    }
}
