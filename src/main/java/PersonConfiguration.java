import be.intecbrussel.dao.implementations.PersonDaoImpl;
import be.intecbrussel.dao.interfaces.PersonDao;
import be.intecbrussel.model.Person;
import be.intecbrussel.services.implementations.PersonServiceImpl;
import be.intecbrussel.services.interfaces.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class PersonConfiguration {

    private int id =0;
    @Bean
    @Scope("prototype")
    public Person person(){
        Person person = new Person();
        person.setId(id);
        id++;
        return person;

    }

    @Bean
    public PersonDao mockDao() {
        return new PersonDaoImpl();
    }

    @Bean
    public PersonService mockService(PersonDao mockDao) {
        return new PersonServiceImpl(mockDao);
    }
}