package com.miniproject.yeolgongdabang.user;

import com.miniproject.yeolgongdabang.user.dto.DayTicketRequestDto;
import com.miniproject.yeolgongdabang.user.service.UserService;
import com.miniproject.yeolgongdabang.user.validator.DayTicketRequestValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;
    private final DayTicketRequestValidator dayTicketRequestValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(dayTicketRequestValidator);
    }

    @PostMapping("/api/v1/buy_day_ticket")
    public void buyTicket(@RequestBody @Valid DayTicketRequestDto request) {
        userService.buyDayTicket(request);
    }

}
