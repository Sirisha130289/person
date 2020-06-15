package be.intecbrussel.dao.implementations;

import be.intecbrussel.dao.interfaces.PersonDao;
import be.intecbrussel.model.Person;
import be.intecbrussel.services.implementations.PersonServiceImpl;
import be.intecbrussel.services.interfaces.PersonService;

import javax.sql.rowset.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
//you need to change PersonService.allPersons to personDB the DaoImpl is the only class that knows
//about the DB
public class PersonDaoImpl implements PersonDao {

    //this list is your 'db' it needs to be here, not in your Service
    //the service cannot know about the db, it only knows about the existance of a Dao
    private List<Person> personDB = new ArrayList<>();


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
        boolean personExists = false;
        for (int i = 0; i <personDB.size() ; i++) {
            if (personDB.get(i).getId()==person.getId()){
                personExists=true;
                personDB.set(i,person);
            }
        }
         return personExists;



        /*if (PersonService.allPersons.contains(person)) {
            //this just changes the id of a given person to 4
            person.setId(4);


            return true;
        }
        return false;*/
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
