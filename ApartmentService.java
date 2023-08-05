package Service;

import Model.Apartment;
import Model.Person;

import java.util.Random;

public class ApartmentService
{
    private PersonService personService = new PersonService();
    private Random random = new Random();

    public Apartment generateApartment()
    {
        int personCount = random.nextInt(5);
        Person[] person = new Person[personCount];
        for (int i = 0; i < person.length ; i++)
        {
            person[i] = personService.generatePerson();
        }
        return new Apartment(person);
    }
}
