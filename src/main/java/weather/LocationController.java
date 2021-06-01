package weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class LocationController {

    private final LocationService locationService;
    private ObjectMapper objectMapper = new ObjectMapper();

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    public String createNewLocation(String countryName, String region,String city, int longitude, int latitude) { // todo city value is missing
        try {
            Location newLocation = locationService
                    .createNewLocation("countryName", "region","city", 12, 14); // todo pass there method parameters
            return objectMapper.writeValueAsString(newLocation);
        } catch (JsonProcessingException e) {
            return "{\"error message\": \"" + e.getMessage() + "\"}";
        }
    }
    public String showAllLocations(){
        try {
            List<Location> locations = locationService.showAllLocations();
            return objectMapper.writeValueAsString(locations);
        } catch (Exception e) {
           return "Error: " + e.getMessage();
        }
    }
}
