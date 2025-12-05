package com.ghostlogin.service;

import com.ghostlogin.dto.DeviceDTO;

import java.util.List;

public interface TrustedDeviceService {
    void registerDevice(String auth0UserId, DeviceDTO deviceDTO);
    List<DeviceDTO> listTrusted(String auth0UserId);
}
