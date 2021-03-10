package com.miniproject.yeolgongdabang.user;

import com.miniproject.yeolgongdabang.ticket.Ticket;
import com.miniproject.yeolgongdabang.ticket.TicketType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTicketTest {

    User user;
    Ticket dayTicket;

    @BeforeEach
    void init() {
        user = User.builder()
                .id(1L)
                .phone("12341234")
                .build();

        dayTicket = Ticket.builder()
                .id(3L)
                .second(3600L)
                .ticketName("1시간 이용권")
                .price(2000)
                .ticketType(TicketType.DAY)
                .build();
    }

    @Test
    void 티켓_연관관계_테스트 () throws Exception {
//
////        given & when
//        TicketPurchasedUser userTicket = TicketPurchasedUser.buyATicket(user, dayTicket);
//
////        then
//        assertAll(
//                () -> assertEquals(user.getUserTickets().size(), 1),
//                () -> assertTrue(user.getUserTickets().contains(userTicket)),
//                () -> assertEquals(userTicket.getTicket(), dayTicket)
//        );
    }
}