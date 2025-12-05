package com.ghostlogin.controller;

import com.ghostlogin.model.UserProfile;
import com.ghostlogin.repository.UserProfileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserProfileRepository userProfileRepository;

    public AuthController(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(@AuthenticationPrincipal Jwt jwt) {
        if (jwt == null) return ResponseEntity.status(401).build();
        return ResponseEntity.ok(Map.of(
                "sub", jwt.getSubject(),
                "claims", jwt.getClaims()
        ));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@AuthenticationPrincipal Jwt jwt, @RequestBody Map<String, String> body) {
        if (jwt == null) return ResponseEntity.status(401).build();
        String auth0Id = jwt.getSubject();
        String email = body.getOrDefault("email", jwt.getClaimAsString("email"));

        UserProfile profile = new UserProfile();
        profile.setAuth0UserId(auth0Id);
        profile.setEmail(email);
        userProfileRepository.save(profile);

        return ResponseEntity.ok(profile);
    }
}
