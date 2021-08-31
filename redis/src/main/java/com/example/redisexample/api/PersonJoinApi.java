package com.example.redisexample.api;

import com.example.redisexample.dto.InfoDto;
import com.example.redisexample.dto.NicknameDto;
import com.example.redisexample.dto.TermsDto;
import com.example.redisexample.entity.Person;
import com.example.redisexample.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonJoinApi {

    private final PersonService personService;

    @PostMapping("/info")
    public String info(@RequestBody InfoDto infoDto) {
        return personService.info(infoDto);
    }

    @PostMapping("/{personId}/nickname")
    public String nickname(@PathVariable String personId,
                                                @RequestBody NicknameDto nicknameDto) {
        personService.nickname(personId, nicknameDto);
        return "nickname save";
    }

    @PostMapping("/{personId}/terms")
    public Long finalJoin(@PathVariable String personId,
                                                @RequestBody TermsDto termsDto) {
        return personService.finalJoin(personId, termsDto);
    }

    @GetMapping("/{personId}")
    public Person getPerson(@PathVariable Long personId) {
        return personService.getPerson(personId);
    }
}
