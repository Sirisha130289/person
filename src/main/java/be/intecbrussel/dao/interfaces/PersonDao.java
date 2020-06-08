package be.intecbrussel.dao.interfaces;

import be.intecbrussel.model.Person;

import java.util.List;

public interface PersonDao {
    public boolean createPerson(Person person);
    public Person readPerson(int id);
    public boolean updatePerson(Person person);
    public boolean deletePerson(Person person);
    public List<Person> getAllPersons();
}
