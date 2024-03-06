import Observable.Observable;
import Observable.WeatherStationImp;
import  Observable.StockObservableImp;
import Observer.Display;
import Observer.Phone;
import Observer.TV;

public class Main {
    public static void main(String[] args) {
        Observable weatherStation = new WeatherStationImp();
        Observable stock = new StockObservableImp();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1).append("char").append(true);
        System.out.println(stringBuilder);

        Observable stockObservable = new StockObservableImp();
        Display tvDisplayForStock = new TV(stockObservable);
        Display phoneDisplayForStock = new Phone(stockObservable);

        Display tvDisplayForWeather = new TV(weatherStation);
        Display phoneDisplayForWeather = new Phone(weatherStation);

        weatherStation.add(tvDisplayForWeather);
        weatherStation.add(phoneDisplayForWeather);
        System.out.println("Changing temp...");
        weatherStation.setData(10);

        stock.add(tvDisplayForStock);
        stock.add(phoneDisplayForStock);
        System.out.println("Changing stock price...");
        stock.setData(100);

        System.out.println("Removing TV display for weather updates...");
        weatherStation.remove(tvDisplayForWeather);

        System.out.println("Changing temp...");
        weatherStation.setData(20);
    }
}