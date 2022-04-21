package temp.temperaturesensor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import temp.temperaturesensor.Temperature.Temperature;
import temp.temperaturesensor.Temperature.TemperatureRepo;
import temp.temperaturesensor.Temperature.TemperatureService;

import java.util.List;

@RestController
public class FrontendController {

    @Autowired
    TemperatureRepo temperatureRepo;
    @Autowired
    TemperatureService temperatureService;

    @GetMapping(path = "/getTemperature")
    public List<Temperature> Temperature(){
        List<Temperature> temps = temperatureRepo.findAll();
        return temps;
    }

    @GetMapping("/averageTemp")
    public double averageTemperature(){


        return temperatureService.averageTemperature();
    }

    @GetMapping("/tempDistance")
    public double getTempDistance(){
        return temperatureService.temperatureDifference();
    }
    @GetMapping("/lowestTemp")
    public double getlowestTemperature(){
        return temperatureService.lowestTemp();
    }
    @GetMapping("/highestTemp")
    public double gethighestTemperature(){
        return temperatureService.highestTemp();
    }

    @GetMapping("/controllFan")
    public boolean controllFan(){
        if(temperatureService.getLastTemperature()>30){
            return true;
        }else{
            return false;
        }
    }

}
