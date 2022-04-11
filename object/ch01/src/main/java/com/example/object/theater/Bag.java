package com.example.object.theater;

import lombok.Getter;

@Getter
public class Bag {

    private Long amount;
    private Invocation invocation;
    private Ticket ticket;

    public Bag(Invocation invocation, Long amount) {
        this.invocation = invocation;
        this.amount = amount;
    }

    public Bag(Long amount) {
        this(null, amount);
    }

    public Long hold(Ticket ticket) {
        if (hasInvocation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }

    }

    private boolean hasInvocation() {
        return invocation != null;
    }

    private boolean hasTicket() {
        return ticket != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }
}
