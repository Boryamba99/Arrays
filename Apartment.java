package Model;

public class Apartment
{
    private Person [] person;

    public Apartment(Person [] person)
    {
        this.person = person;
    }

    public Person[] getPerson() {
        return person;
    }

    public void setPerson(Person[] person) {
        this.person = person;
    }
}
