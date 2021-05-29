package weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationController {

    private final LocationService locationService;
    private ObjectMapper objectMapper = new ObjectMapper();

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    public String createNewLocation(String countryName, String region, int longitude, int latitude) { // todo city value is missing
        try {
            Location newLocation = locationService
                    .createNewLocation("countryName", "region", 12, 14); // todo pass there method parameters
            return objectMapper.writeValueAsString(newLocation);
        } catch (JsonProcessingException e) {
            return "{\"error message\": \"" + e.getMessage() + "\"}";
        }
    }
}
