package chapter_03.ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewSearchingTravel {
    private List<TravelInfoVO> list = new ArrayList<>();

    public NewSearchingTravel() {
        TravelInfoVO cebu = new TravelInfoVO();
        cebu.setName("Cebu Travel");
        cebu.setCountry("philliphine");
        cebu.setCity("cebu");
        cebu.setDays(5);
        cebu.setNights(3);
        list.add(cebu);

        TravelInfoVO boracay = new TravelInfoVO();
        boracay.setName("Boracay Travel");
        boracay.setCountry("philliphine");
        boracay.setCity("boracay");
        boracay.setDays(5);
        boracay.setNights(3);
        list.add(boracay);

        TravelInfoVO hanoi = new TravelInfoVO();
        hanoi.setName("Hanoi Travel");
        hanoi.setCountry("vietnam");
        hanoi.setCity("hanoi");
        hanoi.setDays(3);
        hanoi.setNights(2);
        list.add(hanoi);

        TravelInfoVO danang = new TravelInfoVO();
        danang.setName("Danang Travel");
        danang.setCountry("vietnam");
        danang.setCity("danang");
        danang.setDays(6);
        danang.setNights(4);
        list.add(danang);

        TravelInfoVO bankok = new TravelInfoVO();
        bankok.setName("Bankok Travel");
        bankok.setCountry("tailand");
        bankok.setCity("bankok");
        bankok.setDays(5);
        bankok.setNights(3);
        list.add(bankok);
    }

    public List<TravelInfoVO> searchTravelInfo(TravelInfoFilter condition) {
        List<TravelInfoVO> result = new ArrayList<>();

        for (TravelInfoVO info : list) {
            if (condition.isMatched(info)) {
                result.add(info);
            }
        }

        return result;
    }
}
