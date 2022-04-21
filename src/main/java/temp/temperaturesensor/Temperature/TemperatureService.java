package temp.temperaturesensor.Temperature;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemperatureService {

    @Autowired
    TemperatureRepo temperatureRepo;

    public double averageTemperature(){
        double temps=0;
        List<Temperature> temperatureList = temperatureRepo.findAll();
        if(temperatureList.isEmpty()){
            return 200.0;
        }
        temperatureList.get(0).getTemperature();
        for(int i=0;i<temperatureList.size();i++){
            temps=temps+Double.parseDouble(temperatureList.get(i).getTemperature());
        }
        double average = temps/temperatureList.size();
        return average;
    }

    public double getMedianTemperature(){
        List<Temperature> temperatureList = temperatureRepo.findAll();
        if(temperatureList.isEmpty()){
            return 200.0;
        }
        if(temperatureList.size()%2==0){
            return ((Double.parseDouble(temperatureList.get(temperatureList.size()/2).getTemperature()))+
                    Double.parseDouble(temperatureList.get((temperatureList.size()/2)+2).getTemperature()))/2;
        }else{
            return Double.parseDouble(temperatureList.get(temperatureList.size()/2).getTemperature());
        }
    }

    public double temperatureDifference(){
        List<Temperature> temps = temperatureRepo.findAll();
        if(temps.isEmpty()){
            return 0.0;
        }
        double lowest = getTemp(temps,0);
        double highest = getTemp(temps,0);
        for(int i=1;i<temps.size();i++){
            if(getTemp(temps,i)<lowest){
                lowest=getTemp(temps,i);
            }
            else if(getTemp(temps,i)>highest){
                highest=getTemp(temps,i);
            }

        }
        double tempDifference = highest-lowest;
        return tempDifference;
    }

    public double lowestTemp() {
        List<Temperature> temps = temperatureRepo.findAll();
        if(temps.isEmpty()){
            return 2000.0;
        }
        double lowest = getTemp(temps, 0);
        double highest = getTemp(temps, 0);
        for (int i = 1; i < temps.size(); i++) {
            if (getTemp(temps, i) < lowest) {
                lowest = getTemp(temps, i);
            }

        }
        return lowest;
    }

    public double highestTemp(){
        List<Temperature> temps = temperatureRepo.findAll();
        if(temps.isEmpty()){
            return 2000.0;
        }
        double lowest = getTemp(temps,0);
        double highest = getTemp(temps,0);
        for(int i=1;i<temps.size();i++){
            if(getTemp(temps,i)>highest){
                highest=getTemp(temps,i);
            }

        }
        return highest;
    }

    public double getTemp(List<Temperature> temps,int pos){
        return Double.parseDouble(temps.get(pos).temperature);
    }

    public double getLastTemperature(){
        List<Temperature> allTemps = temperatureRepo.findAll();
        if(allTemps.size()==0){
            return -200;
        }
        return Double.parseDouble(allTemps.get(allTemps.size()-1).temperature);
    }

}
