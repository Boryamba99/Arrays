package Service;

import Model.Person;

import java.util.Random;

public class PersonService
{

    private String[] womanNames = {"Юлия", "Виктория", "Татьяна", "Пелагея"};

    private String[] manNames = {"Артём", "Валерий", "Александр", "Лев"};
    Random random = new Random();
    public Person generatePerson()
    {
/**
 * Генерирует жильца
 * @return Жилец
 */
        boolean male = random.nextBoolean();
        int age = random.nextInt(70);
       return new Person(male,getName(male),age);
    }

    /**
     * Возвращает женское или мужское имя
     * @param male пол
     * @return имя
     */

    private String getName(boolean male)
    {
        if (male){
           int randomArrayPosition = random.nextInt(womanNames.length - 1);
           return manNames[randomArrayPosition];
        } else{
           int randomArrayPosition = random.nextInt(manNames.length - 1);
           return womanNames[randomArrayPosition];
        }

    }

}
