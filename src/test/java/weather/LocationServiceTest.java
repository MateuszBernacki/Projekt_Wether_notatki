package weather;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class LocationServiceTest {

    LocationService locationService;

    @Before
    public void setUp() {
        LocationRepository locationRepository = new LocatioRepositoryMock();
        locationService = new LocationService(locationRepository);
    }

    @Test
    public void whenCreateNewLocation_givenCorrectValues_thenCreatesNewLocation() {
        // when
        Location result = locationService
                .createNewLocation("country","region", "city",23,32);

        // then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getCountry_name()).isEqualTo("country");
        assertThat(result.getRegion()).isEqualTo("region");
        assertThat(result.getCity()).isEqualTo("city");
        assertThat(result.getLongitude()).isEqualTo(23);
        assertThat(result.getLatitude()).isEqualTo(32);
    }

    @Test
    public void createNewLocation_titleIsEmpty_throwsAnException() {
        // when
        Throwable result = catchThrowable(() -> locationService.createNewLocation("","region", "city",23,32));
        // then
        assertThat(result).isExactlyInstanceOf(RuntimeException.class);
    }
}