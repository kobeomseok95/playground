package chapter_02.ex2;

public class CountryAddress implements HouseAddress {

    private int code;
    private String postCode;
    private String address;
    private String detailAddress;

    public CountryAddress(int code, String postCode, String address, String detailAddress) {
        this.code = code;
        this.postCode = postCode;
        this.address = address;
        this.detailAddress = detailAddress;
    }

    @Override
    public String getPostcode() {
        return postCode;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getDetailAddress() {
        return detailAddress;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDefaultCountry() {
        return HouseAddress.super.getDefaultCountry();
    }
}
