package weather;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationService {
    private final LocationRepository locationRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
        this.objectMapper
                .configure(DeserializationFeature
                        .FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    Location createNewLocation(String country_name, String region, int longitude, int latitude) { // todo rename country_name to countryName and city value is missing
        if (country_name == null || country_name.isEmpty()) { // todo "   " -> isBlank() instead of isEmpty()
            throw new RuntimeException("Country name do not exist.");
        }
        if (region.isBlank()) { // todo what if region is null -> NullPointerException -> add region != null &&
            region = null;
        }
        if (longitude <= -90 || longitude >= 90) { // todo 90 and -90 are correct
            throw new RuntimeException("Longitude do not exist.");
        }
        if (latitude <= -180 || latitude >= 180) { // todo 180 and -180 are correct
            throw new RuntimeException("Longitude do not exist.");
        }

        Location location = new Location(null, longitude, latitude, region, country_name);

        return locationRepository.save(location);
    }
}
