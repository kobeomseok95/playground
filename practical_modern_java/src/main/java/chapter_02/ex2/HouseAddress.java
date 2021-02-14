package chapter_02.ex2;

import java.util.HashMap;
import java.util.Map;

public interface HouseAddress {

    public static final Map<Integer, String> countryCodes = new HashMap<>();
    public static final String defaultCountry = "Korea";

    private void init() {
        countryCodes.put(0, "Korea");
        countryCodes.put(1, "USA");
        countryCodes.put(2, "Japan");
        countryCodes.put(3, "China");
        countryCodes.put(4, "UK");
    }

    public String getPostcode();

    public String getAddress();

    public String getDetailAddress();

    public int getCode();

    default String getCountry(){    //public 생략
        init();
        int code = getCode();
        return countryCodes.get(code);
    }

    default String getDefaultCountry() {
        return defaultCountry;
    }
}
