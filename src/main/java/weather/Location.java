package weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "region")
    private String region;

    @Column(name = "countryName")
    private String countryName;

    @Column(name = "city")
    private String city;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    public Location(Long id, String countryName, String city, double longitude, double latitude) {
        this.id = id;
        this.countryName = countryName;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
