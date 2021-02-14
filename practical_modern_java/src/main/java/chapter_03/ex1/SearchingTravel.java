package chapter_03.ex1;

import java.util.ArrayList;
import java.util.List;

public class SearchingTravel {
    public static final String COUNTRY_VIETNAM = "vietnam";
    public static final String COUNTRY_PHILLIPHINE = "philliphine";
    public static final String COUNTRY_TAILAND = "tailand";

    private List<TravelInfoVO> travelInfoList = new ArrayList<>();

    public SearchingTravel() {
        initializeProduct();
    }

    private void initializeProduct() {
        TravelInfoVO cebu = new TravelInfoVO();
        cebu.setName("Cebu Travel");
        cebu.setCountry(COUNTRY_PHILLIPHINE);
        cebu.setCity("cebu");
        cebu.setDays(5);
        cebu.setNights(3);
        travelInfoList.add(cebu);

        TravelInfoVO boracay = new TravelInfoVO();
        boracay.setName("Boracay Travel");
        boracay.setCountry(COUNTRY_PHILLIPHINE);
        boracay.setCity("boracay");
        boracay.setDays(5);
        boracay.setNights(3);
        travelInfoList.add(boracay);

        TravelInfoVO hanoi = new TravelInfoVO();
        hanoi.setName("Hanoi Travel");
        hanoi.setCountry(COUNTRY_VIETNAM);
        hanoi.setCity("hanoi");
        hanoi.setDays(3);
        hanoi.setNights(2);
        travelInfoList.add(hanoi);

        TravelInfoVO danang = new TravelInfoVO();
        danang.setName("Danang Travel");
        danang.setCountry(COUNTRY_VIETNAM);
        danang.setCity("danang");
        danang.setDays(6);
        danang.setNights(4);
        travelInfoList.add(danang);

        TravelInfoVO bankok = new TravelInfoVO();
        bankok.setName("Bankok Travel");
        bankok.setCountry(COUNTRY_TAILAND);
        bankok.setCity("bankok");
        bankok.setDays(5);
        bankok.setNights(3);
        travelInfoList.add(bankok);
    }

    public List<TravelInfoVO> searchTravelInfoByCountry(String country) {
        List<TravelInfoVO> returnValue = new ArrayList<>();

        for (TravelInfoVO travelInfo : travelInfoList) {
            if (country.equals(travelInfo.getCountry())) {
                returnValue.add(travelInfo);
            }
        }

        return returnValue;
    }

    public List<TravelInfoVO> searchTravelInfoByCity(String city) {
        List<TravelInfoVO> returnValue = new ArrayList<>();

        for (TravelInfoVO travelInfo : travelInfoList) {
            if (city.equals(travelInfo.getCity())) {
                returnValue.add(travelInfo);
            }
        }

        return returnValue;
    }
}
