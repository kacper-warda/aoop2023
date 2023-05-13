package com.example.wsbaoop.mobilezoo;

import com.example.wsbaoop.mobilezoo.person.Person;
import com.example.wsbaoop.mobilezoo.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zoo")
public class ZooController {

    @GetMapping("/test")
    public String test() {
        Animal dog = new Animal("canis", "szarik", true);
        String html = "<html><body><h1>no elo</h1>" +
                "<h2>" + dog.name + "</h2>" +
                "</body></html>";
        return html;
    }

    @GetMapping("/test2")
    public String test2() {
        return "pozdrawiam 2000";
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/test3")
    public String test3() {

        String insertQuery = "INSERT INTO student (name, email) VALUES ('Kacper Warda', 'niepiszdomnie@wsb.pl')";
        jdbcTemplate.update(insertQuery);

        String selectQuery = "SELECT * FROM student";
        List<Student> students = jdbcTemplate.query(selectQuery, new BeanPropertyRowMapper(Student.class));

        return students.toString();
    }

    @GetMapping("/test4")
    public String test4() {
        Animal dog = new Animal("canis", "burek", true);
        dog.save(jdbcTemplate);

        List<Animal> animals = jdbcTemplate.query("SELECT * FROM animal", new AnimalRowMapper());
//        List<Animal> animals = jdbcTemplate.query("SELECT * FROM animal", new BeanPropertyRowMapper(Animal.class));

        return animals.toString();
    }

    private final PersonRepository personRepository;

    @Autowired
    public ZooController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @GetMapping("/test5")
    public String test5() {
        Person newperson = this.personRepository.save(new Person("kacper", "adminadmin", true));
        return "zapisało " + newperson;
    }
}
