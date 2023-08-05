package Service;

import Model.Apartment;
import Model.Person;

import java.util.Random;

public class CityService
{
    private ApartmentService apartmentService = new ApartmentService();
    private Random random = new Random();
    public Apartment[][][] generateCity()
    {
        Apartment[][][] apartments = new Apartment[10][20][30];
        for (int i = 0; i < apartments.length; i++) {
            for (int j = 0; j < apartments[i].length; j++) {
                for (int k = 0; k < apartments[i][j].length; k++) {
                    apartments[i][j][k] = apartmentService.generateApartment();
                }
            }
        }
        return apartments;
    }

    public void releaseEvent(Apartment apartment, int hours)
    {
        int delivery = random.nextInt(100); // Процент захода
        int goWork = random.nextInt(100);
        if(goWork < 60 && hours == 8){
            goWork(apartment);
        }
        if(hours == 17){
            returnFromWork(apartment);
        }
        if(delivery < 20 && (hours > 9 && hours < 18)){
            delivery(apartment);
        }
    }

    /**
     * шанс 20%, что ожидается посылка
     * @param apartment
     */
    public void delivery(Apartment apartment)
    {
        if(apartment.getPerson().length > 0){ // Если в квартире есть жильцы
            for (int i = 0; i < apartment.getPerson().length; i++) { // проходим по всем жильцам
                if(apartment.getPerson()[i].isAtHome()){             // проверяем,что кто-то дома
                    if(apartment.getPerson()[i].getAge() > 14)
                    System.out.println("Посылка доставлена для " + apartment.getPerson()[i].getName());
                    return;
                }
            }
        }
    }

    public void goWork(Apartment apartment)
    {
        if(apartment.getPerson().length > 0){ // Если в квартире есть жильцы
            for (int i = 0; i < apartment.getPerson().length; i++) { // проходим по всем жильцам
                if(apartment.getPerson()[i].isAtHome()){             // проверяем,что кто-то дома
                    if(apartment.getPerson()[i].getAge() > 21){
                        Person person = apartment.getPerson()[i];
                        person.setAtHome(false);
                        System.out.println(person.getName() + " ушёл на работу");
                    }

                }
            }
        }
    }

    public void returnFromWork(Apartment apartment)
    {
        if(apartment.getPerson().length > 0){ // Если в квартире есть жильцы
            for (int i = 0; i < apartment.getPerson().length; i++) { // проходим по всем жильцам
                if(!apartment.getPerson()[i].isAtHome()){             // проверяем,что кто-то дома
                    Person person = apartment.getPerson()[i];
                    person.setAtHome(true);
                    System.out.println(person.getName() + " вернулся с работы");
                    return;
                }
            }
        }
    }
}
