package com.example.aop.check;

import com.example.aop.aspect.ParameterIsEven;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CheckService {

    public String checkEven(int number) {
        return "even";
    }

    public String checkOdd(int number) {
        return "odd";
    }
}
