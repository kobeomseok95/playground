package com.demo.querydslexample.configs;

import com.demo.querydslexample.entity.Member;
import com.demo.querydslexample.entity.Team;
import com.demo.querydslexample.repository.MemberJpaRepository;
import com.demo.querydslexample.repository.TeamJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@RequiredArgsConstructor
public class InitMember {

    private final InitMemberService initMemberService;

    @PostConstruct
    public void init() {
        initMemberService.init();
    }

    @Component
    @RequiredArgsConstructor
    public static class InitMemberService {

        private final MemberJpaRepository memberJpaRepository;
        private final TeamJpaRepository teamJpaRepository;
        EntityManager em;

        @Transactional
        public void init() {
            Team teamA = new Team("teamA");
            Team teamB = new Team("teamB");
            teamJpaRepository.save(teamA);
            teamJpaRepository.save(teamB);

            for (int i = 1; i <= 100; i++) {
                Team selectedTeam = i % 2 == 0 ? teamA : teamB;
                memberJpaRepository.save(new Member("member" + i, i, selectedTeam));
            }
        }
    }
}
