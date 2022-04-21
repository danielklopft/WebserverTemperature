package temp.temperaturesensor.Temperature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface temperatureSensorRepo extends JpaRepository<TemperatureSensor,Long> {
}



