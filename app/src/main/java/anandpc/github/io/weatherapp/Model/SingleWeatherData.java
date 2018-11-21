package anandpc.github.io.weatherapp.Model;

public class SingleWeatherData {

    private String cityName;
    private String temp;
    private String description;

    public SingleWeatherData(String cityName, String temp, String description) {
        this.cityName = cityName;
        this.temp = temp;
        this.description = description;
    }

    public String getCityName() {
        return cityName;
    }

    public String getTemp() {
        return temp;
    }

    public String getDescription() {
        return description;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SingleWeatherData{" +
                "cityName='" + cityName + '\'' +
                ", temp='" + temp + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
