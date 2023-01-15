package com.pattern.design.creational.builder;

import java.time.LocalDate;

public interface TourPlanBuilder {
    TourPlan newInstance();
    TourPlanBuilder title(String title);
    TourPlanBuilder nightsAndDays(int nights, int days);
    TourPlanBuilder startDate(LocalDate date);
    TourPlanBuilder whereToStay(String whereToStay);
    TourPlanBuilder addPlan(int day, String plan);
    TourPlan build();
}
