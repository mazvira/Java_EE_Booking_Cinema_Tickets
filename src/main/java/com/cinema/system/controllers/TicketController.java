package com.cinema.system.controllers;

import com.cinema.system.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

}
