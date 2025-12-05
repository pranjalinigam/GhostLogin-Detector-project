package com.ghostlogin.service.impl;

import com.ghostlogin.dto.DeviceDTO;
import com.ghostlogin.model.UserProfile;
import com.ghostlogin.repository.UserProfileRepository;
import com.ghostlogin.service.TrustedDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrustedDeviceServiceImpl implements TrustedDeviceService {

    private final UserProfileRepository userProfileRepository;

    public TrustedDeviceServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public void registerDevice(String auth0UserId, DeviceDTO deviceDTO) {
        UserProfile profile = userProfileRepository.findByAuth0UserId(auth0UserId).orElse(new UserProfile());
        profile.setAuth0UserId(auth0UserId);
        UserProfile.TrustedDevice td = new UserProfile.TrustedDevice();
        td.setDeviceId(deviceDTO.getDeviceId());
        td.setDeviceType(deviceDTO.getDeviceType());
        profile.getTrustedDevices().add(td);
        userProfileRepository.save(profile);
    }

    @Override
    public List<DeviceDTO> listTrusted(String auth0UserId) {
        UserProfile profile = userProfileRepository.findByAuth0UserId(auth0UserId).orElse(new UserProfile());
        return profile.getTrustedDevices().stream().map(td -> {
            DeviceDTO dto = new DeviceDTO();
            dto.setDeviceId(td.getDeviceId());
            dto.setDeviceType(td.getDeviceType());
            return dto;
        }).collect(Collectors.toList());
    }
}
