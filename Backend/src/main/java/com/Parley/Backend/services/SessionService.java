package com.Parley.Backend.services;

import com.Parley.Backend.dto.SessionResponse;
import com.Parley.Backend.entities.Location;
import com.Parley.Backend.entities.Session;
import com.Parley.Backend.repositories.LocationRepository;
import com.Parley.Backend.repositories.SessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;
    private final LocationRepository locationRepository;

    public SessionResponse createSession(Location location) {
        Random r = new Random();
        int newSessionCode;


        do {
            newSessionCode = r.nextInt(9999) + 1;
        }
        while (sessionRepository.findBySessionCodeAndStatus(newSessionCode, "Active").isPresent());

        Session createdSession =  new Session();

        createdSession.setSessionCode(newSessionCode);
        createdSession.setStatus("Active");

        Location savedLocation = locationRepository.save(location);

        List<Location> newLocationList = new ArrayList<Location>();

        newLocationList.add(savedLocation);
        createdSession.setLocations(newLocationList);

        Session savedSession = sessionRepository.save(createdSession);


        return this.mapToSessionResponse(savedSession);

    }


    private SessionResponse mapToSessionResponse(Session session){
        return SessionResponse.builder()
                .sessionId(session.getSessionId())
                .sessionCode(session.getSessionCode())
                .status(session.getStatus())
                .build();
    }


    public Session getSession(Long session_id) {

        return sessionRepository.findById(session_id).get();
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
