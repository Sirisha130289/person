package be.intecbrussel.services.interfaces;

import be.intecbrussel.model.Person;

import java.util.ArrayList;
import java.util.List;

public interface PersonService {
// this does not belong here ;-)
    List<Person> allPersons = new ArrayList<Person>();

    public Person getPerson(int id);

    public void addPerson(Person person);

    public void addPerson(List<Person> personList);

    public List<Person> getPersonList();

}
