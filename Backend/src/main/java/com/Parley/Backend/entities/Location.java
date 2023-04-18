package com.Parley.Backend.entities;


import com.Parley.Backend.entities.Session;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "locations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long location_id;

    @Column(precision = 19, scale = 10)
    private BigDecimal latitude;

    @Column(precision = 19, scale = 10)
    private BigDecimal longitude;

    @ManyToOne
    @JoinColumn(name="session_id")
    @JsonIgnore
    private Session session;

    @OneToOne(mappedBy = "centerLocation")
    @JsonIgnore
    private Session centerLocationSession;

}
