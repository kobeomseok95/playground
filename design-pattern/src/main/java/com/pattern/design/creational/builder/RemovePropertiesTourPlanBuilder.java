package com.pattern.design.creational.builder;

import java.time.LocalDate;
import java.util.ArrayList;

public class RemovePropertiesTourPlanBuilder implements TourPlanBuilder {

    private TourPlan tourPlan;

    @Override
    public TourPlan newInstance() {
        this.tourPlan = new TourPlan();
        return tourPlan;
    }

    @Override
    public TourPlanBuilder title(String title) {
        this.tourPlan.setTitle(title);
        return this;
    }

    @Override
    public TourPlanBuilder nightsAndDays(int nights, int days) {
        this.tourPlan.setNights(nights);
        this.tourPlan.setDays(days);
        return this;
    }

    @Override
    public TourPlanBuilder startDate(LocalDate date) {
        this.tourPlan.setStartDate(date);
        return this;
    }

    @Override
    public TourPlanBuilder whereToStay(String whereToStay) {
        this.tourPlan.setWhereToStay(whereToStay);
        return this;
    }

    @Override
    public TourPlanBuilder addPlan(int day, String plan) {
        if (this.tourPlan.getPlans() == null) {
            this.tourPlan.setPlans(new ArrayList<>());
        }
        this.tourPlan.getPlans().add(new DetailPlan(day, plan));
        return this;
    }

    @Override
    public TourPlan build() {
        return tourPlan;
    }
}
