package com.cinema.system;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
@NoArgsConstructor
@Getter
@Setter
@NamedQueries(value = {
        @NamedQuery(query = "SELECT ticket FROM Ticket ticket WHERE ticket.id = :id", name = Ticket.FIND_BY_ID),
})
class Ticket {
    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "price")
    private double price;
    @Column(name = "raw")
    private int raw;
    @Column(name = "place")
    private int place;
    @Column(name = "movie_id")
    private Integer idOfMovie;
    @Column(name = "movieTime_id")
    private Integer idOfMovieTime;
    @Column(name = "cinemaHall_id")
    private Integer idOfCinemaHall;

    public static final String FIND_BY_ID = "Ticket.FIND_BY_ID";
}
