package com.cinema.system;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final EntityManager entityManager;

    @Transactional
    public Ticket createTicket(double price, int raw, int place) {
        Ticket ticket = new Ticket();
        ticket.setPrice(price);
        ticket.setRaw(raw);
        ticket.setPlace(place);
        return entityManager.merge(ticket);
    }

    @Transactional
    public List<Ticket> getAllTickets() {
        return entityManager.createQuery("FROM Ticket", Ticket.class)
                .getResultList();
    }

    @Transactional
    public Ticket findById(Integer id) {
        return entityManager.createNamedQuery(Ticket.FIND_BY_ID, Ticket.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}