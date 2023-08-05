import Model.Apartment;
import Service.CityService;

public class Main {

    public static CityService cityService = new CityService();
    public static void main(String[] args)
    {
        int hours = 0;
        Apartment[][][] apartments = cityService.generateCity();
        for (int i = 0; i < 300; i++) {
            hours = checkTime(hours);
            System.out.println("Текущее время " + hours);
            for (int j = 0; j < apartments.length  ; j++) {
                for (int k = 0; k < apartments[j].length; k++) {
                    for (int l = 0; l < apartments[j][k].length; l++) {
                       Apartment apartment = apartments[j][k][l];
                       cityService.releaseEvent(apartment, hours);

                    }
                }
            }
        }

    }

    private static int checkTime(int hours)
    {
        int currentHours = hours + 1;
        if(hours > 23){
            return 0;
        }
        return currentHours;
    }
}