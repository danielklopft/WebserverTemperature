package temp.temperaturesensor.Temperature;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TemperatureSensor {
    @SequenceGenerator(
            name = "temperatureSensor_sequence",
            sequenceName = "temperatureSensor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "temperatureSensor_sequence"
    )
    @Id
    long id;



}
