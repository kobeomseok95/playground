package com.example.jpashop.example;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-30T06:29:32+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Amazon.com Inc.)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public Car carDtoToCar(CarDto carDto) {
        if ( carDto == null ) {
            return null;
        }

        String serial = null;
        String carName = null;
        CarType type = null;

        serial = carDto.getSerialNumber();
        carName = carDto.getName();
        if ( carDto.getCarType() != null ) {
            type = Enum.valueOf( CarType.class, carDto.getCarType() );
        }

        Long id = null;

        Car car = new Car( id, serial, carName, type );

        return car;
    }
}
