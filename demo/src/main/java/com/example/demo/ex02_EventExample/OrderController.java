package com.example.demo.ex02_EventExample;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<OrderResponseDto> process(@RequestBody OrderRequestDto request) {
        OrderResponseDto response = orderService.order(request);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return new ResponseEntity<>(response, header, HttpStatus.OK);
    }

    @PostMapping("/cancel")
    public ResponseEntity<OrderCancelResponseDto> cancel(@RequestBody OrderCancelRequestDto request) {
        OrderCancelResponseDto response = orderService.cancel(request);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return new ResponseEntity<>(response, header, HttpStatus.OK);
    }
}
