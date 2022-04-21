package temp.temperaturesensor.Temperature;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Temperature {
    @SequenceGenerator(
            name = "temperature_sequence",
            sequenceName = "temperature_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "temperature_sequence"
    )
    @Id
    private long id;
    String temperature;

    Long temperatureSensorId;
    Timestamp timestamp;

    public Temperature(String temperature, Long temperatureSensorId) {
        this.temperature = temperature;
        this.temperatureSensorId=temperatureSensorId;
        timestamp.setTime(System.currentTimeMillis());
    }

    public Temperature(String temperature, Long temperatureSensorId, Timestamp timestamp) {
        this.temperature = temperature;
        this.temperatureSensorId = temperatureSensorId;
        this.timestamp = timestamp;
    }
}
