package com.Parley.Backend.repositories;

import com.Parley.Backend.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
