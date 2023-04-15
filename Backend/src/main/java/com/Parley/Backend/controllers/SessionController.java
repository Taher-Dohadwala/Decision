package com.Parley.Backend.controllers;

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

    @GetMapping("/{session_id}")
    @ResponseStatus(HttpStatus.OK)
    public Session getSession(@PathVariable("session_id") Long session_id){
        return sessionService.getSession(session_id);

    }

    @GetMapping("/locations")
    @ResponseStatus(HttpStatus.OK)
    public List<Location> getLocations(){
        return sessionService.getAllLocations();

    }

}
