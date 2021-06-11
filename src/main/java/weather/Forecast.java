package weather;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "forecast")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Forecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "pressure")
    private Double pressure;

    @Column(name = "windSpeed")
    private Double windSpeed;

    @Column(name = "windDag")
    private Double windDag;

    @Column(name = "humidity")
    private Double humidity;

    @ManyToOne
    private Location location;
}
