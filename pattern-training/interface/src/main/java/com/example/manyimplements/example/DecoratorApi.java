package com.example.manyimplements.example;

import com.example.manyimplements.example.decoratorservice.PaymentDto;
import com.example.manyimplements.example.decoratorservice.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DecoratorApi {

    private final PaymentService paymentService;

    @PostMapping("/payment")
    public void pay(@RequestBody PaymentDto paymentDto) {
        paymentService.pay(paymentDto);
    }
}
