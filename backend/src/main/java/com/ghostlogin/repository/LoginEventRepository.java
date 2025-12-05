package com.ghostlogin.repository;

import com.ghostlogin.model.LoginEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginEventRepository extends MongoRepository<LoginEvent, String> {
    List<LoginEvent> findTop20ByAuth0UserIdOrderByTimestampDesc(String auth0UserId);
}
