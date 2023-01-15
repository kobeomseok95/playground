package com.pattern.design.creational.builder;

import java.time.LocalDate;
import java.util.stream.Stream;

public class Client {

    public static void main(String[] args) {
        TourPlanBuilder builder = new RemovePropertiesTourPlanBuilder();
        TourPlan plan = builder.title("여행한다.")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2023, 1, 14))
                .whereToStay("어딘가")
                .addPlan(1, "체크인")
                .addPlan(2, "끝내주게 놀기")
                .build();
        TourDirector tourDirector = new TourDirector(builder);
        tourDirector.createTrip();
    }
}
