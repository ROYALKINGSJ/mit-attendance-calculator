package OOPS_LAB.WEEK_5;
import java.util.Scanner;

class Weather{
    String City_Name;
    Double Temperature;
    Double Humidity;

    static class Forecast{
        Weather weather_object;
        
        Forecast(Weather w){
            this.weather_object=w;
        }

        void predict_forecast(){
            if (weather_object.Humidity>=75 && weather_object.Temperature<=30){
                System.out.println("Rainy");                
            }
            else if (weather_object.Humidity<=60 && weather_object.Temperature>=20){
                System.out.println("Sunny");
            }
            else {
                System.out.println("Cloudy");
            }
        }
    }

    void input_values(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter City Name : ");
        this.City_Name=sc.nextLine();

        System.out.println("Enter Temperature (in Celcius) : ");
        this.Temperature=sc.nextDouble();

        System.out.println("Enter Humidity (in percent) : ");
        this.Humidity=sc.nextDouble();

        sc.close();
    }
}

public class WEEK_5_4 {
    public static void main(String[] args) {
        Weather weather_object=new Weather();
        weather_object.input_values();

        Weather.Forecast forecast_object=new Weather.Forecast(weather_object);
        forecast_object.predict_forecast();
    }
}
