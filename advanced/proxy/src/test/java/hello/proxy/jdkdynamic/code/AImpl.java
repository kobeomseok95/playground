package hello.proxy.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AImpl implements AInterface {
    @Override
    public int callInteger() {
        log.info("call 호출");
        return 1234;
    }

    @Override
    public String call2() {
        log.info("A2 호출");
        return "a2";
    }
}
