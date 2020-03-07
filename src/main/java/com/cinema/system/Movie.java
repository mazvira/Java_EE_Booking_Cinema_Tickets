package com.cinema.system;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "movie")
@NoArgsConstructor
@Getter
@Setter
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
    private int duration;
}
