package be.intecbrussel.services.implementations;

import be.intecbrussel.dao.implementations.PersonDaoImpl;
import be.intecbrussel.dao.interfaces.PersonDao;
import be.intecbrussel.model.Person;
import be.intecbrussel.services.interfaces.PersonService;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person getPerson(int id) {

        return personDao.readPerson(id);
    }

    public void addPerson(Person person) {
        personDao.createPerson(person);
    }

    public void addPerson(List<Person> personList) {
        personList.forEach(person -> personDao.createPerson(person));
    }

    @Override
    public List<Person> getPersonList() {
        return personDao.getAllPersons();
    }


}
