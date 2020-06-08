package be.intecbrussel.dao.implementations;

import be.intecbrussel.dao.interfaces.PersonDao;
import be.intecbrussel.model.Person;
import be.intecbrussel.services.implementations.PersonServiceImpl;
import be.intecbrussel.services.interfaces.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonDaoImpl implements PersonDao {
    //  private List<Person> personDB = new ArrayList<>();


    public boolean createPerson(Person person) {
        if (PersonService.allPersons.contains(person)) {
            return false;
        } else {
            PersonService.allPersons.add(person);
            return true;
        }

    }

    public Person readPerson(int id) {
        Optional<Person> personOptional = PersonService.allPersons.stream().filter(person -> person.getId() == id)
                .findAny();

        if (personOptional.isPresent()) {
            return personOptional.get();
        }

        return null;
    }

    public boolean updatePerson(Person person) {
        if (PersonService.allPersons.contains(person)) {
            person.setId(4);
            return true;
        }
        return false;
    }

    public boolean deletePerson(Person person) {
        if (PersonService.allPersons.contains(person)) {
            PersonService.allPersons.remove(person);
            return true;
        }
        return false;
    }

    @Override
    public List<Person> getAllPersons() {
        return PersonService.allPersons;
    }
}
