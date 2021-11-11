package com.pattern.design;

import com.pattern.design.strategy.Context;
import com.pattern.design.strategy.MinusStrategy;
import com.pattern.design.strategy.PlusStrategy;
import com.pattern.design.template.method.AbstractCalculate;
import com.pattern.design.template.method.MinusCalculate;
import com.pattern.design.template.method.PlusCalculate;
import org.springframework.stereotype.Component;

@Component
public class Client {

    public void main() {
        AbstractCalculate plusCalculate = new PlusCalculate();
        plusCalculate.calc(1, 2, "+");

        AbstractCalculate minusCalculate = new MinusCalculate();
        minusCalculate.calc(1, 2, "-");
    }
}
