package weather;

import java.util.ArrayList;
import java.util.List;

public class LocatioRepositoryMock extends LocationRepository implements LocationRepositoryInt{

    private List <Location> entries= new ArrayList<>();
    @Override
    public Location save(Location entry) {
        entry.setId(1L);
        entries.add(entry);
        return entry;
    }

}
