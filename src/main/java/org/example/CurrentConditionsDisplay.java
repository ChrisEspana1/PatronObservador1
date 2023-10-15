package org.example;

public class CurrentConditionsDisplay implements IObserver,DisplayElement {
    public CurrentConditionsDisplay(ISubject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    private float temperature, humidity;
    private ISubject weatherData;
    @Override
    public void Display() {
        System.out.println("Current Conditions: " + temperature + "F degrees and" +humidity + "%humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
    this.humidity = humidity;
    this.temperature = temp;
    Display();
    }
}
