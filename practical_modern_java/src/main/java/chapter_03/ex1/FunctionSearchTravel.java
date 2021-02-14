package chapter_03.ex1;

import java.util.ArrayList;
import java.util.List;

public class FunctionSearchTravel {

    private List<TravelInfoVO> infoList = new ArrayList<>();

    public FunctionSearchTravel() {
        TravelInfoVO cebu = new TravelInfoVO();
        cebu.setName("Cebu Travel");
        cebu.setCountry("philliphine");
        cebu.setCity("cebu");
        cebu.setDays(5);
        cebu.setNights(3);
        infoList.add(cebu);

        TravelInfoVO boracay = new TravelInfoVO();
        boracay.setName("Boracay Travel");
        boracay.setCountry("philliphine");
        boracay.setCity("boracay");
        boracay.setDays(5);
        boracay.setNights(3);
        infoList.add(boracay);

        TravelInfoVO hanoi = new TravelInfoVO();
        hanoi.setName("Hanoi Travel");
        hanoi.setCountry("vietnam");
        hanoi.setCity("hanoi");
        hanoi.setDays(3);
        hanoi.setNights(2);
        infoList.add(hanoi);

        TravelInfoVO danang = new TravelInfoVO();
        danang.setName("Danang Travel");
        danang.setCountry("vietnam");
        danang.setCity("danang");
        danang.setDays(6);
        danang.setNights(4);
        infoList.add(danang);

        TravelInfoVO bankok = new TravelInfoVO();
        bankok.setName("Bankok Travel");
        bankok.setCountry("tailand");
        bankok.setCity("bankok");
        bankok.setDays(5);
        bankok.setNights(3);
        infoList.add(bankok);
    }

    public List<TravelInfoVO> searchTravelInfo(TravelInfoFilter condition) {
        List<TravelInfoVO> result = new ArrayList<>();

        for (TravelInfoVO info : infoList) {
            if (condition.isMatched(info)) {
                result.add(info);
            }
        }

        return result;
    }

    //isMatched의 구현 메서드를 나눠서 유지보수성을 높였다.
    public static boolean isVietnam(TravelInfoVO vo) {
        if (vo.getCountry().equals("vietnam")) {
            return true;
        }
        return false;
    }
}
