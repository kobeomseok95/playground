package com.miniproject.yeolgongdabang.user.service;

import com.miniproject.yeolgongdabang.seat.Seat;
import com.miniproject.yeolgongdabang.seat.SeatRepository;
import com.miniproject.yeolgongdabang.ticket.Ticket;
import com.miniproject.yeolgongdabang.ticket.TicketRepository;
import com.miniproject.yeolgongdabang.user.User;
import com.miniproject.yeolgongdabang.user.SeatedUser;
import com.miniproject.yeolgongdabang.user.TicketPurchasedUser;
import com.miniproject.yeolgongdabang.user.dto.DayTicketRequestDto;
import com.miniproject.yeolgongdabang.user.dto.EnterResponseDto;
import com.miniproject.yeolgongdabang.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    private final SeatRepository seatRepository;

    /**
     *  phone, seatId, ticketId
     *  User, TicketPurchasedUser, SeatedUser 생성
     *  연관관계 설정하기
     *  =================================
     *  ResponseDto 리턴
     */
    public void purchaseDayTicket(DayTicketRequestDto request) {
        Seat seat = seatRepository.findBySeatNumber(request.getSeatNumber());
        Ticket ticket = ticketRepository.findById(request.getTicketId()).orElseThrow();
        checkEmptySeat(seat);

        User user = User.builder()
                .phone(request.getPhone())
                .build();

        TicketPurchasedUser ticketPurchasedUser = TicketPurchasedUser.createTicketPurchasedUser(user, ticket);
        SeatedUser seatedUser = SeatedUser.createSeatedUser(user, seat, ticketPurchasedUser.getEndDate());
        userRepository.save(user);

    }

    private void checkEmptySeat(Seat seat) {
        if (!seat.isEmpty()) {
            throw new IllegalStateException("빈 자리가 아닙니다!");
        }
    }


}



















