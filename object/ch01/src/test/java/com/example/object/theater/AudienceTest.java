package com.example.object.theater;

import com.navercorp.fixturemonkey.ArbitraryBuilder;
import com.navercorp.fixturemonkey.FixtureMonkey;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class AudienceTest {

    @Test
    void audience_test() throws Exception {

        // given
        FixtureMonkey fixture = FixtureMonkey.create();
        ArbitraryBuilder<Bag> bagArbitraryBuilder = fixture.giveMeBuilder(Bag.class);

        // when
        Audience audience = fixture.giveMeBuilder(Audience.class)
                .setBuilder("bag", bagArbitraryBuilder)
                .sample();

        // then
        assertNotNull(audience.getBag());
        log.info("{}", audience.getBag());
    }
}