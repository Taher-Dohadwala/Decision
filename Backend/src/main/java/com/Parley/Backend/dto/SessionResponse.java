package com.Parley.Backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionResponse {

    private Long sessionId;

    private int sessionCode;

    private String status;

}
