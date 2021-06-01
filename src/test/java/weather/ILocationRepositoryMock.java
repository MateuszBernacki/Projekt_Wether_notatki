package weather;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ILocationRepositoryMock implements ILocationRepository {

    private List<Location> entries = new ArrayList<>();

    @Override
    public Location save(Location entry) {
        entry.setId(1L);
        entries.add(entry);
        return entry;
    }

    @Override
    public List<Location> getAllLocations() {
        return getAllLocations();
    }

    @Override
    public Optional<Location> findById(Long id) {
        return Optional.empty();
    }

}
