package com.ghostlogin.controller;

import com.ghostlogin.dto.LoginApproveResponse;
import com.ghostlogin.dto.LoginEventRequest;
import com.ghostlogin.model.LoginEvent;
import com.ghostlogin.service.LoginEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logins")
public class LoginEventController {

    private final LoginEventService loginEventService;

    public LoginEventController(LoginEventService loginEventService) {
        this.loginEventService = loginEventService;
    }

    @PostMapping("/create")
    public ResponseEntity<LoginEvent> create(@RequestBody LoginEventRequest req) {
        LoginEvent saved = loginEventService.createEvent(req);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/recent")
    public ResponseEntity<List<LoginEvent>> recent(@RequestParam String auth0UserId) {
        return ResponseEntity.ok(loginEventService.recent(auth0UserId));
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<LoginApproveResponse> approve(@PathVariable String id) {
        loginEventService.updateStatus(id, LoginEvent.Status.APPROVED);
        return ResponseEntity.ok(new LoginApproveResponse(id, "APPROVED"));
    }

    @PostMapping("/{id}/deny")
    public ResponseEntity<LoginApproveResponse> deny(@PathVariable String id) {
        loginEventService.updateStatus(id, LoginEvent.Status.DENIED);
        return ResponseEntity.ok(new LoginApproveResponse(id, "DENIED"));
    }
}
