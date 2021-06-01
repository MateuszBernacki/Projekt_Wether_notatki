package weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
@Data
public class ForecastResponseDTO {

    @JsonProperty("lat")
    private Double latitude;

    @JsonProperty("lon")
    private Double longitude;

    private List<SingleDayForecast> daily;
    @Data
    static class SingleDayForecast{
        @JsonProperty("pressure")
        private Double pressure;

        @JsonProperty("dt")
        private Long timeStamp;

        @JsonProperty("humidi")
        private Double humidity;

        @JsonProperty("wind_Speed")
        private Double windSpeed;

        @JsonProperty("wind_dag")
        private Double windDeg;

        @JsonProperty("temp")
        private  Temperature temperature;

        public LocalDate getDateTime(){
            Instant instant = Instant.ofEpochSecond(timeStamp);
            return instant.atZone(ZoneOffset.UTC).toLocalDate();
        }

        @Data
        static class Temperature{
            private Double day;

            public Double celcius(){
                return day -273.15;
            }
        }
    }
}



