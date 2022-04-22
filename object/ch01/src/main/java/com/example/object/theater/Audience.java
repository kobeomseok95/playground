package com.example.object.theater;

import lombok.Getter;

@Getter
public class Audience {

    private Bag bag;

    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}
