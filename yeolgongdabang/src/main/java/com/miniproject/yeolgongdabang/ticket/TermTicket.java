package com.miniproject.yeolgongdabang.ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Term")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TermTicket extends Ticket {

    private int week;
}
