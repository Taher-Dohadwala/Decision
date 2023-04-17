package com.Parley.Backend.controllers;

import com.Parley.Backend.dto.LocationResponse;
import com.Parley.Backend.dto.SessionResponse;
import com.Parley.Backend.entities.Location;
import com.Parley.Backend.entities.Session;
import com.Parley.Backend.services.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/session")
@AllArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @PostMapping("/create-session")
    @ResponseStatus(HttpStatus.CREATED)
    public SessionResponse createSession(@RequestBody Location location) {
        return sessionService.createSession(location);
    }

    @PostMapping("/join-session/{session_code}")
    @ResponseStatus(HttpStatus.OK)
    public SessionResponse joinSession(@PathVariable("session_code") int sessionCode, @RequestBody Location location) {
        return sessionService.joinSession(sessionCode, location);
    }

    @GetMapping("/{session_id}")
    @ResponseStatus(HttpStatus.OK)
    public Session getSession(@PathVariable("session_id") Long sessionId) {
        return sessionService.getSession(sessionId);

    }

    @GetMapping("/center-location/{session_id}")
    @ResponseStatus(HttpStatus.OK)
    public LocationResponse getCenterLocation(@PathVariable("session_id") Long sessionId) {
        return sessionService.getCenterLocation(sessionId);

    }

    @PostMapping("/start/{session_id}")
    @ResponseStatus(HttpStatus.OK)
    public SessionResponse startSession(@PathVariable("session_id") Long sessionId) {
        return sessionService.startSession(sessionId);
    }

    @GetMapping("/locations")
    @ResponseStatus(HttpStatus.OK)
    public List<Location> getLocations(){
        return sessionService.getAllLocations();

    }





}
