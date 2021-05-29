package weatherApp;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class LocationService {
    private final LocationRepository locationRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
        this.objectMapper
                .configure(DeserializationFeature
                        .FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    Location createNewLocation(String country_name, String region, int longitude, int latitude) {
        if (country_name == null || country_name.isEmpty()) {
            throw new RuntimeException("Country name do not exist.");
        }
        if (region.isBlank()) {
            region = null;
        }

        if (longitude <= -90 || longitude >= 90) {
            throw new RuntimeException("Longitude do not exist.");
        }
        if (latitude <= -180 || latitude >= 180) {
            throw new RuntimeException("Longitude do not exist.");
        }

        Location location = new Location(null, longitude, latitude, region, country_name);

        return locationRepository.save(location);
    }
}
