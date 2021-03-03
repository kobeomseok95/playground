package com.miniproject.yeolgongdabang.ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TIME")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeTicket extends Ticket {

    private int hour;
}
