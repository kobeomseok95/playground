package com.example.solid.unit.modules;

import com.example.solid.unit.config.TestQuerydslConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityManager;

@DataJpaTest
@Import(TestQuerydslConfiguration.class)
public abstract class RepositoryUnitTest {

    @Autowired
    protected EntityManager entityManager;

    protected void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }
}
