package com.example.redisexample.service;

import com.example.redisexample.dto.InfoDto;
import com.example.redisexample.dto.NicknameDto;
import com.example.redisexample.dto.TermsDto;
import com.example.redisexample.entity.Person;

public interface PersonService {

    String info(InfoDto infoDto);

    void nickname(String personId, NicknameDto addressDto);

    Long finalJoin(String personId, TermsDto termsDto);

    Person getPerson(Long personId);
}
