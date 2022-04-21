package temp.temperaturesensor;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import temp.temperaturesensor.Temperature.Temperature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TemperatureTest {
    Temperature t = new Temperature("22.5",1L);

    @Test
    void setTemperature(){
        t.setTemperature("30.0");
        assertEquals("30.0",t.getTemperature());
    }
    @Test
    void getTemperature(){
        assertEquals("22.5",t.getTemperature());
    }
}
