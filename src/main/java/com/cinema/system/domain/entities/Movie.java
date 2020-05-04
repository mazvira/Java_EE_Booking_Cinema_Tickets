package com.cinema.system.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "movie_name")
    private String name;
    @Column(name = "movie_producer")
    private String producer;
    @Column(name = "movie_director")
    private String director;
    @Column(name = "movie_country")
    private String country;
    @Column(name = "movie_duration")
    private double duration;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Session> sessions;
}
