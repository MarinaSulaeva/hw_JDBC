public class City {
    private int cityId;
    private String nameCity;

    public City(int cityId, String nameCity) {
        this.cityId = cityId;
        this.nameCity = nameCity;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }
}
