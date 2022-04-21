package temp.temperaturesensor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import temp.temperaturesensor.Temperature.*;

import java.util.List;

@Controller
@AllArgsConstructor
@Getter
@Setter
public class appController {

    @Autowired
    TemperatureRepo temperatureRepo;
    @Autowired
    temperatureSensorRepo temperatureSensorRepo;
    @Autowired
    TemperatureService temperatureService;

    @PostMapping(path = "/newTemp")
    public String newTemp(@RequestBody Temperature temperature){
        if(!temperatureSensorRepo.findById(temperature.getId()).isPresent()){
            temperatureSensorRepo.save(new TemperatureSensor(temperature.getId()));
        }
        temperatureRepo.save(temperature);
        return temperature.getTemperature();
    }

    @GetMapping("")
    public String home(){
        return "index";
    }


    @GetMapping("/averageTemperature")
    public String averageWebsite(Model model) {
        if(temperatureService.highestTemp()==2000.0){
            model.addAttribute("highestTemp",       " - ");
            model.addAttribute("lowestTemp",        " - ");
            model.addAttribute("tempDifference",    " - ");
            model.addAttribute("averageTemperature"," - ");
        }else {
            model.addAttribute("highestTemp",           temperatureService.highestTemp());
            model.addAttribute("lowestTemp",            temperatureService.lowestTemp());
            model.addAttribute("tempDifference",        temperatureService.temperatureDifference());
            model.addAttribute("averageTemperature",    temperatureService.averageTemperature());
        }
        return "averageTemperature";
    }


    @GetMapping("/ThymleafSide")
    public String getTemperature(Model model){
        model.addAttribute("Hallo","Hallo");
        model.addAttribute("temperatures",temperatureRepo.findAll());
        return "ThymleafSide";
    }

    @GetMapping("/readTemperature")
    public String readTemperature(){
        return "readTemperature";
    }





}
