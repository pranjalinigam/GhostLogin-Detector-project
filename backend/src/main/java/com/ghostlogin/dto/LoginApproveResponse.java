package com.ghostlogin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginApproveResponse {
    private String id;
    private String status;
}
