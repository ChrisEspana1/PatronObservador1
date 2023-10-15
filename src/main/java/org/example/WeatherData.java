package org.example;

import java.util.ArrayList;
import java.util.List;

public class WheatherData implements ISubject{
    private List<IObserver> observes;
    public float temp,humidity,pressure;
    public WheatherData(){
    observes = new ArrayList<IObserver>();
    }
    @Override
    public void registerObserver(IObserver o) {
    observes.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
    int i = observes.indexOf(o);
    if(i>=0){
        observes.remove(o);
    }else{
        System.out.println("no se encontro el indice indicado");
    }
    }
    @Override
    public void notifyObservers() {
    for(IObserver o:observes)
        o.update(temp,humidity,pressure);
}
public void measurementsChanged(){
        //acciones
    notifyObservers();
}
    public void setMesurements( float temp, float humidity,float pressure){
        this.temp = temp;
        this.humidity=humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
    public float getTemp() {
        return temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
