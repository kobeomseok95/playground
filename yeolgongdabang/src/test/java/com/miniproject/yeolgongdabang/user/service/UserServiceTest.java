package com.miniproject.yeolgongdabang.user.service;

import com.miniproject.yeolgongdabang.seat.Seat;
import com.miniproject.yeolgongdabang.seat.SeatRepository;
import com.miniproject.yeolgongdabang.ticket.Ticket;
import com.miniproject.yeolgongdabang.ticket.TicketRepository;
import com.miniproject.yeolgongdabang.ticket.TicketType;
import com.miniproject.yeolgongdabang.user.dto.DayTicketRequestDto;
import com.miniproject.yeolgongdabang.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Transactional
class UserServiceTest {

//    @InjectMocks UserService userService;
//    @Mock UserRepository userRepository;
//    @Mock TicketRepository ticketRepository;
//    @Mock SeatRepository seatRepository;
//
//
//    Ticket ticket;
//    Seat seat;
//    DayTicketRequestDto request;
//
//    @BeforeEach
//    void init() {
//        request = DayTicketRequestDto.builder()
//                .phone("12341234")
//                .seatId(3L)
//                .ticketId(2L)
//                .build();
//
//        ticket = Ticket.builder()
//                .id(2L)
//                .ticketName("1시간 이용권")
//                .second(3600L)
//                .ticketType(TicketType.DAY)
//                .price(5000)
//                .build();
//
//        seat = Seat.builder()
//                .id(3L)
//                .empty(true)
//                .seatNumber(3)
//                .build();
//    }
//
//    /**
//     *
//     * @throws Exception
//     */
//    @Test
//    void 당일_이용권_테스트() throws Exception {
//
//        // given
//        when(seatRepository.findById(request.getSeatId()))
//                .thenReturn(Optional.of(seat));
//        when(ticketRepository.findById(request.getTicketId()))
//                .thenReturn(Optional.of(ticket));
//
//        // when
//        userService.purchaseDayTicket(request);
//
//        // then
//        verify(seatRepository).findById(request.getSeatId());
//        verify(ticketRepository).findById(request.getTicketId());
//    }
}