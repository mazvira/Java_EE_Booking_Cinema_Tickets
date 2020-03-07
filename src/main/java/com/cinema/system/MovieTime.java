package com.cinema.system;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "movieTime")
@NoArgsConstructor
@Getter
@Setter
public class MovieTime {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "movietime_date")
    LocalDate dateOfMovieTime;
    @Column(name = "movietime_time")
    LocalTime timeOfMovieTime;
}
