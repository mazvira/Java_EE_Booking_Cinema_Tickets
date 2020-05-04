package com.cinema.system.services;

import com.cinema.system.domain.entities.Ticket;
import com.cinema.system.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    @Transactional
    public Ticket createTicket(double price, int raw, int place) {
        Ticket ticket = new Ticket();
        ticket.setPrice(price);
        ticket.setRaw(raw);
        ticket.setPlace(place);
        return ticketRepository.save(ticket);
    }

    @Transactional
    public List<Ticket> findAllTickets() {
        return ticketRepository.findAll();
    }

    @Transactional
    public Ticket findById(Integer id) {
        return ticketRepository.findById(id).orElse(null);
    }
}