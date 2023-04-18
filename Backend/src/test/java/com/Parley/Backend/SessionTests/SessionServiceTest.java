package com.Parley.Backend.SessionTests;

import com.Parley.Backend.dto.SessionResponse;
import com.Parley.Backend.entities.Location;
import com.Parley.Backend.entities.Session;
import com.Parley.Backend.repositories.LocationRepository;
import com.Parley.Backend.repositories.SessionRepository;
import com.Parley.Backend.services.SessionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


public class SessionServiceTest {

    @Mock
    private SessionRepository sessionRepository;

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private SessionService sessionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateSession() {
        // Mock repository behavior
        when(sessionRepository.findBySessionCodeAndStatus(anyInt(), anyString())).thenReturn(Optional.empty());
        when(sessionRepository.save(Mockito.any(Session.class))).thenReturn(new Session(1L, 1234, "Active", null, null));

        // Create input location object
        Location location = new Location();
        location.setLatitude(BigDecimal.valueOf(37.7749));
        location.setLongitude(BigDecimal.valueOf(-122.4194));

        // Call service method
        SessionResponse sessionResponse = sessionService.createSession(location);

        // Verify repository calls
        verify(sessionRepository, times(1)).findBySessionCodeAndStatus(anyInt(), anyString());
        verify(sessionRepository, times(1)).save(Mockito.any(Session.class));
        verify(locationRepository, times(1)).save(Mockito.any(Location.class)); // Two locations saved: initial and center

        // Verify session response object
        assertEquals(1234, sessionResponse.getSessionCode());
        assertEquals("Active", sessionResponse.getStatus());
        assertNotNull(sessionResponse.getSessionId());
    }

    @Test
    public void getSessionTest() {
        Long sessionId = 1L;
        Session session = new Session(sessionId, 1234, "Active", null, null);

        when(sessionRepository.findById(sessionId)).thenReturn(Optional.of(session));

        Session result = sessionService.getSession(sessionId);

        assertEquals(sessionId, result.getSessionId());
        assertEquals(session.getSessionCode(), result.getSessionCode());
        assertEquals(session.getStatus(), result.getStatus());
    }

    @Test
    public void joinSessionTest() {
        int sessionCode = 1234;
        Session session = new Session(1L, sessionCode, "Active", null, null);
        Location location = new Location(1L, new BigDecimal("37.422"), new BigDecimal("-122.084"), null, null);

        when(sessionRepository.findBySessionCodeAndStatus(sessionCode, "Active")).thenReturn(Optional.of(session));
        when(locationRepository.save(location)).thenReturn(location);

        SessionResponse result = sessionService.joinSession(sessionCode, location);

        assertEquals(session.getSessionId(), result.getSessionId());
        assertEquals(session.getSessionCode(), result.getSessionCode());
        assertEquals(session.getStatus(), result.getStatus());
    }
}

