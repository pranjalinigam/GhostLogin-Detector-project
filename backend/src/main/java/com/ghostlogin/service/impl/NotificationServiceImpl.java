package com.ghostlogin.service.impl;

import com.ghostlogin.model.LoginEvent;
import com.ghostlogin.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    private static final Logger log = LoggerFactory.getLogger(NotificationServiceImpl.class);

    public NotificationServiceImpl() {
    }

    @Override
    public void notifyUser(LoginEvent ev, String reason) {
        // AWS integrations removed per user request — log notifications instead.
        log.info("[Notification] user={} eventId={} reason={}", ev.getAuth0UserId(), ev.getId(), reason);
    }
}
