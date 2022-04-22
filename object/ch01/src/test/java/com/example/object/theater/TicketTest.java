package com.example.object.theater;

import com.navercorp.fixturemonkey.FixtureMonkey;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class TicketTest {

    @Test
    void ticket_test() throws Exception {

        // given
        FixtureMonkey fixture = FixtureMonkey.create();

        // when
        Ticket ticket = fixture.giveMeOne(Ticket.class);

        // then
        assertNotNull(ticket.getFee());
        log.info("{}", ticket.getFee());
    }
}