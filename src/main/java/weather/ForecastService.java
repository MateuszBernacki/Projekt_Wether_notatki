package weather;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;

@RequiredArgsConstructor
public class ForecastService {

   final  LocationRepository locationRepository;
   final  ObjectMapper objectMapper ;


    public Forecast getForecastWeat(Long locationId, Integer date) {

        Location location = locationRepository.findById(locationId)
                .orElseThrow(()-> new RuntimeException("Localization not found:" + locationId  ));

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.openweathermap.org/data/2.5/onecall?lat=50&lon=20&exclude=minutely,hourly&appid=2ed090c5de33977f0294a9c325a15fc6"))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println(responseBody);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            ForecastResponseDTO forecastResponseDTO = objectMapper.readValue(responseBody, ForecastResponseDTO.class);

            LocalDate forecastDate = LocalDate.now().plusDays(date);

            Forecast forecast = forecastResponseDTO.getDaily().stream().filter(singleDayForecast1 ->
                    singleDayForecast1.getDateTime().equals(forecastDate)).findFirst()
                    .map(s -> new Forecast().builder().temperature(s.getTemperature().celcius())
                            .pressure(s.getPressure())
                            .windSpeed(s.getWindSpeed())
                            .windDag(s.getWindDeg())
                            .humidity(s.getHumidity()) //todo .location(location)
                            .build())
                    .orElseThrow(()-> new RuntimeException("Weather not found"));

            return  forecast;
//todo cryate reposytory
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }


    }
}
