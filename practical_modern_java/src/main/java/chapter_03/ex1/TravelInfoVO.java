package chapter_03.ex1;

public class TravelInfoVO {
    private String name;
    private String country;
    private String city;
    private int days;
    private int nights;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(name).append(" : ").append(country).append(", ").append(city).append(", ")
                .append(nights).append("박").append(days).append("일");

        return builder.toString();
    }
}
