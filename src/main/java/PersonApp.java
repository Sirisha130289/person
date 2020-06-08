import be.intecbrussel.model.Person;
import be.intecbrussel.services.implementations.PersonServiceImpl;
import be.intecbrussel.services.interfaces.PersonService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonApp {
    public static void main(String[] args) {


        Person person1 = new Person();
        person1.setFirstName("Tom");
        person1.setLastName("Cruise");
        person1.setDateOfBirth(LocalDate.now());
        person1.setId(1);


        Person person2 = new Person();
        person2.setFirstName("Michael");
        person2.setLastName("Jackson");
        person2.setDateOfBirth(LocalDate.now());
        person2.setId(2);


        Person person3 = new Person();
        person3.setFirstName("John");
        person3.setLastName("Williams");
        person3.setDateOfBirth(LocalDate.now());
        person3.setId(3);
        try (
                ConfigurableApplicationContext applicationContext =
                        new AnnotationConfigApplicationContext(PersonConfiguration.class)) {

            applicationContext.getBean(PersonServiceImpl.class).addPerson(person1);
            List<Person> personList = new ArrayList<>();
            personList.add(person2);
            personList.add(person3);
            applicationContext.getBean(PersonServiceImpl.class).addPerson(personList);
            applicationContext.getBean(PersonServiceImpl.class).getPersonList().forEach(System.out::println);
            System.out.println(applicationContext.getBean(PersonServiceImpl.class).getPerson(2));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

