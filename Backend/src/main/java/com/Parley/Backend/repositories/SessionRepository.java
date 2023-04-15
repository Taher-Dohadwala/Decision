package com.Parley.Backend.repositories;

import com.Parley.Backend.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long > {


    Optional<Session> findBySessionCode(int sessionCode);
}
