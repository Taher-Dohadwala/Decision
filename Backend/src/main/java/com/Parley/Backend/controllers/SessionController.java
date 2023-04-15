package com.Parley.Backend.controllers;

import com.Parley.Backend.dto.SessionResponse;
import com.Parley.Backend.services.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/session")
@AllArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @PostMapping("/create-session")
    @ResponseStatus(HttpStatus.CREATED)
    public SessionResponse createSession() {
        return sessionService.createSession();
    }
}
