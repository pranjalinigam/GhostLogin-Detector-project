package com.ghostlogin.controller;

import com.ghostlogin.model.LoginEvent;
import com.ghostlogin.model.UserProfile;
import com.ghostlogin.repository.LoginEventRepository;
import com.ghostlogin.repository.UserProfileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/setup")
public class SetupController {

    private final UserProfileRepository userProfileRepository;
    private final LoginEventRepository loginEventRepository;

    public SetupController(UserProfileRepository userProfileRepository, LoginEventRepository loginEventRepository) {
        this.userProfileRepository = userProfileRepository;
        this.loginEventRepository = loginEventRepository;
    }

    @GetMapping("/init")
    public ResponseEntity<String> initSampleData() {
        // Create a sample user profile
        UserProfile user = new UserProfile();
        user.setAuth0UserId("auth0|sample-user-" + UUID.randomUUID());
        user.setEmail("sample.user@example.com");
        userProfileRepository.save(user);

        // Create a sample login event for that user
        LoginEvent evt = new LoginEvent();
        evt.setAuth0UserId(user.getAuth0UserId());
        evt.setIpAddress("203.0.113.5");
        LoginEvent.Location loc = new LoginEvent.Location();
        loc.setCity("Testville");
        loc.setCountry("Testland");
        evt.setLocation(loc);
        LoginEvent.DeviceInfo di = new LoginEvent.DeviceInfo();
        di.setBrowser("Firefox");
        di.setOs("Windows");
        di.setDeviceId("device-" + UUID.randomUUID());
        evt.setDeviceInfo(di);
        evt.setRiskScore(42);
        loginEventRepository.save(evt);

        return ResponseEntity.ok("Sample data created: user_profiles and login_events populated") ;
    }
}
