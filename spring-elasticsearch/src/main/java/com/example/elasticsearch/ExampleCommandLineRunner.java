package com.example.elasticsearch;

import com.example.elasticsearch.entity.LectureEntity;
import com.example.elasticsearch.entity.LectureEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExampleCommandLineRunner implements CommandLineRunner {

    private final LectureEntityRepository lectureEntityRepository;

    @Override
    public void run(String... args) throws Exception {
        for(int i = 0; i < 10; i++) {
            lectureEntityRepository.save(
                    LectureEntity.builder()
                            .imageUrl("test")
                            .title("타이틀")
                            .description("디스크립션")
                            .finishedProductText("테스트")
                            .regularPrice(1000)
                            .priceOne(1000)
                            .priceTwo(1000)
                            .priceThree(1000)
                            .priceFour(1000)
                            .build()
            );
        }
    }
}
