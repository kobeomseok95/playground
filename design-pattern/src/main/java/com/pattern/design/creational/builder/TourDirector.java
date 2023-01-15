package com.pattern.design.creational.builder;

import java.time.LocalDate;

public class TourDirector {
    private TourPlanBuilder tourPlanBuilder;

    public TourDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }

    public TourPlan createTrip() {
        return tourPlanBuilder.title("여행한다.")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2023, 1, 14))
                .whereToStay("어딘가")
                .addPlan(1, "체크인")
                .addPlan(2, "끝내주게 놀기")
                .build();
    }
}
