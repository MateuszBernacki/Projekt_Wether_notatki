package weather;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class LocationServiceTest {

    LocationService locationService;

    @Before
    public void setUp() {
        ILocationRepository locationRepository = new ILocationRepositoryMock();
        locationService = new LocationService(locationRepository);
    }

    @Test
    public void whenCreateNewLocation_givenCorrectValues_thenCreatesNewLocation() {
        // when
        Location result = locationService
                .createNewLocation("country", "region", "city", 23, 32);

        // then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getCountryName()).isEqualTo("country");
        assertThat(result.getRegion()).isEqualTo("region");
        assertThat(result.getCity()).isEqualTo("city");
        assertThat(result.getLongitude()).isEqualTo(23);
        assertThat(result.getLatitude()).isEqualTo(32);
    }

    @Test
    public void createNewLocation_countryNameIsEmpty_throwsAnException() {
        // when
        Throwable result = catchThrowable(() -> locationService.createNewLocation("", "region", "city", 23, 32));
        // then
        assertThat(result).isExactlyInstanceOf(RuntimeException.class);
    }

    @Test
    public void createNewLocation_regionIsEmpty() {
        //when
        Throwable result = catchThrowable(() -> locationService.createNewLocation("country", "", "city", 23, 32));
        //then

    }


}
