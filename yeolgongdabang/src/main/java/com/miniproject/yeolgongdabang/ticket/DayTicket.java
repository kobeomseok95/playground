package com.miniproject.yeolgongdabang.ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DAY")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DayTicket extends Ticket {

    private int hour;
}
