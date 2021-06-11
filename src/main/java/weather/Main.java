package weather;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();

        LocationRepository locationRepository = new LocationRepository(sessionFactory);
        ForecastRepositoryImpl forecastRepositoryImpl = new ForecastRepositoryImpl(sessionFactory);
        LocationService locationService = new LocationService(locationRepository);
        ForecastService forecastService = new ForecastService(locationRepository, forecastRepositoryImpl);
        LocationController locationController = new LocationController(locationService);
        ForecastController forecastController = new ForecastController(forecastService);
        UserInterface userInterface = new UserInterface(locationController, forecastController );
        userInterface.run();

        //https://api.openweathermap.org/data/2.5/onecall?lat=50&lon=20&exclude=minutely,hourly&appid=2ed090c5de33977f0294a9c325a15fc6
    }
}
