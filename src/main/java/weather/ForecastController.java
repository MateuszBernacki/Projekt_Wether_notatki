package weather;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ForecastController {
    private final  ForecastService forecastService;
    private ObjectMapper objectMapper = new ObjectMapper();

    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    public String getForecast(Long locationId, Integer date){
        try {
            Forecast forecast = forecastService.getForecastWeat(locationId,date);
            return objectMapper.writeValueAsString(forecast);
        } catch (Exception e){
            return "Err message: " + e.getMessage();
        }
    }
}
