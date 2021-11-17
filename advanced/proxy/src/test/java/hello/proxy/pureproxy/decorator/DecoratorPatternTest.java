package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.DecoratorPatternClient;
import hello.proxy.pureproxy.decorator.code.MessageDecorator;
import hello.proxy.pureproxy.decorator.code.RealComponent;
import hello.proxy.pureproxy.decorator.code.TimeDecorator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() throws Exception {
        RealComponent realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    void decorator1() throws Exception {
        DecoratorPatternClient client = new DecoratorPatternClient(new MessageDecorator(new RealComponent()));
        client.execute();
    }

    @Test
    void decorator2() throws Exception {
        DecoratorPatternClient client = new DecoratorPatternClient(
                new TimeDecorator(
                    new MessageDecorator(
                            new RealComponent()
                    )
                )
        );
        client.execute();
    }
}
