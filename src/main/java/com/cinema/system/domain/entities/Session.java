package com.cinema.system.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "session")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Session {

    @Id
    @Column(name = "session_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "session_date")
    LocalDate dateOfMovieTime;
    @Column(name = "session_time")
    LocalTime timeOfMovieTime;

    @OneToMany(mappedBy = "session", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
}
