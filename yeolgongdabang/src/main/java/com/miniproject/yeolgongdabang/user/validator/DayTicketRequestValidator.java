package com.miniproject.yeolgongdabang.user.validator;

import com.miniproject.yeolgongdabang.seat.Seat;
import com.miniproject.yeolgongdabang.seat.SeatRepository;
import com.miniproject.yeolgongdabang.ticket.Ticket;
import com.miniproject.yeolgongdabang.ticket.TicketRepository;
import com.miniproject.yeolgongdabang.user.dto.DayTicketRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DayTicketRequestValidator implements Validator {

    private final SeatRepository seatRepository;
    private final TicketRepository ticketRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return DayTicketRequestDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DayTicketRequestDto request = (DayTicketRequestDto) target;
        Seat seat = seatRepository.findBySeatNumber(request.getSeatNumber());
        Optional<Ticket> ticket = ticketRepository.findById(request.getTicketId());

        if (!seat.isEmpty()) {
            errors.rejectValue("seat", "wrong.value", "해당 좌석은 비어있지 않습니다.");
        }

        if (ticket.isEmpty()) {
            errors.rejectValue("ticket", "empty.value", "해당 이용권은 존재하지 않습니다.");
        }
    }
}
