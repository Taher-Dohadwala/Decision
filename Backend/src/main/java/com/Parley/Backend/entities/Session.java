package com.Parley.Backend.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "sessions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Session {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "session_id")
    private Long SessionId;

    private int sessionCode;

    private String status;


    @OneToMany(mappedBy = "session")
    private List<Location> locations;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location centerLocation;


    //private DecisionState decisionState;

}
