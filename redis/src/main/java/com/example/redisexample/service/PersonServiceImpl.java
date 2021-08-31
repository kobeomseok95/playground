package com.example.redisexample.service;

import com.example.redisexample.dto.InfoDto;
import com.example.redisexample.dto.NicknameDto;
import com.example.redisexample.dto.TermsDto;
import com.example.redisexample.entity.Person;
import com.example.redisexample.repository.PersonJpaRepository;
import com.example.redisexample.repository.PersonRedisRepository;
import com.example.redisexample.vo.PersonRedis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonServiceImpl implements PersonService{

    private final PersonRedisRepository personRedisRepository;
    private final PersonJpaRepository personJpaRepository;

    @Override
    public String info(InfoDto infoDto) {
        PersonRedis personRedis = PersonRedis.builder()
                .name(infoDto.getName()).address(infoDto.getAddress()).build();
        PersonRedis save = personRedisRepository.save(personRedis);
        return save.getId();
    }

    @Override
    public void nickname(String personId, NicknameDto nicknameDto) {
        PersonRedis personRedis = personRedisRepository.findById(personId).orElseThrow();
        personRedis.setNickname(nicknameDto.getNickname());
        personRedisRepository.save(personRedis);
    }

    @Override
    public Long finalJoin(String redisPersonId, TermsDto termsDto) {
        PersonRedis personRedis = personRedisRepository.findById(redisPersonId).orElseThrow();
        Person person = Person.create(personRedis, termsDto);
        Person savedPerson = personJpaRepository.save(person);
        personRedisRepository.deleteById(redisPersonId);
        return savedPerson.getId();
    }

    // db ID로 조회
    @Override
    public Person getPerson(Long personId) {
        return personJpaRepository.findById(personId).orElseThrow();
    }
}
