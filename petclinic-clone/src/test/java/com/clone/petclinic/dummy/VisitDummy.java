package com.clone.petclinic.dummy;

import com.clone.petclinic.domain.Visit;

import java.time.LocalDate;

public class VisitDummy {

    public static Visit createVisit() {
        return Visit.builder()
                .date(LocalDate.now())
                .description("test")
                .build();
    }
}
