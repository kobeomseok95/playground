package chapter_03.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 안좋은예
//        SearchingTravel travelSearch = new SearchingTravel();
//        List<TravelInfoVO> countries = travelSearch.searchTravelInfoByCountry(SearchingTravel.COUNTRY_VIETNAM);
//        for (TravelInfoVO travelInfo : countries) {
//            System.out.println(travelInfo);
//        }
//
//        List<TravelInfoVO> cebus = travelSearch.searchTravelInfoByCity("cebu");
//        for (TravelInfoVO travelInfo : cebus) {
//            System.out.println("travelInfo = " + travelInfo);
//        }

        // 익명클래스
//        NewSearchingTravel search = new NewSearchingTravel();
//        List<TravelInfoVO> list = search.searchTravelInfo(new TravelInfoFilter() {
//                @Override
//                public boolean isMatched(TravelInfoVO info, Map<String, String> condition) {
//                    for (String key : condition.keySet()) {
//                        if (key.equals("city") && !condition.get(key).equals(info.getCity())) {
//                            return false;
//                        }
//
//                        if (key.equals("country") && !condition.get(key).equals(info.getCountry())) {
//                            return false;
//                        }
//                    }
//                    return true;
//                }
//            }
//        );
//        NewSearchingTravel search = new NewSearchingTravel();
//        List<TravelInfoVO> searchByCountry = search.searchTravelInfo((TravelInfoVO vo) -> vo.getCountry().equals("vietnam"));
//        for (TravelInfoVO vo : searchByCountry) {
//            System.out.println("vo = " + vo);
//        }
//
//        List<TravelInfoVO> searchByCity = search.searchTravelInfo((TravelInfoVO vo) -> vo.getCity().equals("hanoi"));
//        for (TravelInfoVO vo : searchByCity) {
//            System.out.println("vo = " + vo);
//        }



//        List<TravelInfoVO> results = search.searchTravelInfo(new TravelInfoFilter() {
//            @Override
//            public boolean isMatched(TravelInfoVO travelInfo) {
//                if (travelInfo.getCountry().equals("vietnam")) {
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        });
        // 메서드 참조
        FunctionSearchTravel search = new FunctionSearchTravel();
        List<TravelInfoVO> travelInfoVOS = search.searchTravelInfo(FunctionSearchTravel::isVietnam);
        for (TravelInfoVO travelInfoVO : travelInfoVOS) {
            System.out.println("travelInfoVO = " + travelInfoVO);
        }
    }
}














