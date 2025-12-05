package com.ghostlogin.controller;

import com.ghostlogin.dto.DeviceDTO;
import com.ghostlogin.model.UserProfile;
import com.ghostlogin.repository.UserProfileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/device")
public class TrustedDeviceController {

    private final UserProfileRepository userProfileRepository;

    public TrustedDeviceController(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addDevice(@RequestParam String auth0UserId, @RequestBody DeviceDTO dto) {
        UserProfile profile = userProfileRepository.findByAuth0UserId(auth0UserId).orElse(new UserProfile());
        profile.setAuth0UserId(auth0UserId);
        UserProfile.TrustedDevice td = new UserProfile.TrustedDevice();
        td.setDeviceId(dto.getDeviceId());
        td.setDeviceType(dto.getDeviceType());
        profile.getTrustedDevices().add(td);
        userProfileRepository.save(profile);
        return ResponseEntity.ok(td);
    }

    @GetMapping("/list")
    public ResponseEntity<List<DeviceDTO>> list(@RequestParam String auth0UserId) {
        UserProfile profile = userProfileRepository.findByAuth0UserId(auth0UserId).orElse(new UserProfile());
        List<DeviceDTO> list = profile.getTrustedDevices().stream().map(d -> {
            DeviceDTO dto = new DeviceDTO();
            dto.setDeviceId(d.getDeviceId());
            dto.setDeviceType(d.getDeviceType());
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }
}
