package com.ghostlogin.service;

import com.ghostlogin.dto.LoginEventRequest;
import com.ghostlogin.model.LoginEvent;

import java.util.List;

public interface LoginEventService {
    LoginEvent createEvent(LoginEventRequest req);
    List<LoginEvent> recent(String auth0UserId);
    void updateStatus(String id, LoginEvent.Status status);
}
