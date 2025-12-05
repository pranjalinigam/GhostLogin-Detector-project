package com.ghostlogin.service.impl;

import com.ghostlogin.model.LoginEvent;
import com.ghostlogin.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.cloudwatch.CloudWatchClient;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.s3.S3Client;

@Service
public class NotificationServiceImpl implements NotificationService {
    private static final Logger log = LoggerFactory.getLogger(NotificationServiceImpl.class);

    private final SesClient sesClient;
    private final CloudWatchClient cloudWatchClient;
    private final S3Client s3Client;

    public NotificationServiceImpl(SesClient sesClient, CloudWatchClient cloudWatchClient, S3Client s3Client) {
        this.sesClient = sesClient;
        this.cloudWatchClient = cloudWatchClient;
        this.s3Client = s3Client;
    }

    @Override
    public void notifyUser(LoginEvent ev, String reason) {
        // Placeholder: log to CloudWatch and call SES to send email
        log.info("Notify user {} about event {}: {}", ev.getAuth0UserId(), ev.getId(), reason);
        // TODO: implement SES send and S3 upload of report
    }
}
