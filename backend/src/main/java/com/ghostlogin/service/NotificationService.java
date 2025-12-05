package com.ghostlogin.service;

import com.ghostlogin.model.LoginEvent;

public interface NotificationService {
    void notifyUser(LoginEvent ev, String reason);
}
