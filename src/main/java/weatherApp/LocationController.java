package weatherApp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationController {

    private final LocationService locationService;
    private ObjectMapper objectMapper = new ObjectMapper();

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    public String createNewLocation(String country_name, String region, int longitude, int latitude){
        try {
            Location newLocation = locationService
                    .createNewLocation("countryName","region",12,14);
            return objectMapper.writeValueAsString(newLocation);
        } catch (JsonProcessingException e) {
            return "{\"error message\": \"" + e.getMessage() + "\"}";
        }
    }
}
