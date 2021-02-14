package com.example.demo.ex01_ResponseEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;

@RestController
@RequiredArgsConstructor
public class ResponseEntityController {

    private final ResponseEntityService service;

    @GetMapping("/user/{id}")
    public ResponseEntity<MyDto> findByid(@PathVariable Long id) {
        User user = service.getUser();
        MyDto dto = new MyDto();

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        dto.setStatus(StatusEnum.OK);
        dto.setData(user);
        dto.setMessage("고범석 찾기 성공");

        return new ResponseEntity<>(dto, header, HttpStatus.OK);
    }
}
