package weatherApp;

public class Main {
    public static void main(String[] args) {
        LocationRepository locationRepository = new LocationRepository();
        LocationService locationService = new LocationService(locationRepository);
        LocationController locationController = new LocationController(locationService);
        UserInterface userInterface = new UserInterface(locationController);
        userInterface.run();
    }
}
