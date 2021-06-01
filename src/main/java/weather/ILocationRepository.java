package weather;

import java.util.List;
import java.util.Optional;

public interface ILocationRepository {
    Location save(Location entry);
    List<Location>getAllLocations();
    Optional<Location> findById(Long id);
}
