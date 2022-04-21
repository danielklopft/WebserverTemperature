package temp.temperaturesensor;


import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import temp.temperaturesensor.Temperature.Temperature;
import temp.temperaturesensor.Temperature.TemperatureRepo;
import temp.temperaturesensor.Temperature.TemperatureService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class TemperatureServiceTest {

    @Autowired
    private TemperatureRepo temperatureRepo;
    @Autowired
    private TemperatureService temperatureService;

    @BeforeEach
    void setUp(){
        for(int i=20;i<31;i++){
            double temp = Double.valueOf(i);
            String parsed = String.valueOf(temp);
        Temperature t = new Temperature(parsed,1L);
        temperatureRepo.save(t);
        }
    }
    @AfterEach
    void tearDown(){
        temperatureRepo.deleteAll();
    }
    @Test
    void calculateMedian(){
        List<Temperature> temps = temperatureRepo.findAll();
        temps.forEach(p->{
            System.out.println(p.getTemperature());
        });
        assertEquals(25.0,temperatureService.getMedianTemperature());

    }




}
