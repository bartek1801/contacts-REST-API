package lech.bartlomiej.contacts;


import com.fasterxml.jackson.databind.ObjectMapper;
import lech.bartlomiej.contacts.domain.Gender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AppTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DatabaseCleaner cleaner;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void cleanDatabase(){
        cleaner.cleanDatabase();
    }


    @Test
    public void shouldAddNewPerson() throws Exception {
        savePerson("Jan", "Nowak", Gender.M, LocalDate.parse("1990-01-01"), 90010122222L);

        mockMvc.perform(get("/person/1").
                param("firstName", "Jan").
                param("lastName", "Nowak").
                param("gen`der", "M").
                param("birthDate", "1990-01-01").
                param("pesel", "90010122222").
                param("active", "true").
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk())
        ;
    }

    @Test
    public void shouldNotAddNewPerson() throws Exception {
        Person person = new Person("", "", Gender.M, null, null);

        mockMvc.perform(put("/person").
                contentType(MediaType.APPLICATION_JSON).
                content(objectMapper.writeValueAsString(person))
        ).andExpect(status().isUnprocessableEntity()).
                andExpect(jsonPath("$.errors.firstName").value("can't be blank")).
                andExpect(jsonPath("$.errors.lastName").value("can't be blank")).
                andExpect(jsonPath("$.errors.birthDate").value("can't be blank")).
                andExpect(jsonPath("$.errors.pesel").value("can't be blank"))
        ;
    }

    @Test
    public void shouldDeletePerson() throws Exception {
        savePerson("Jan", "Nowak", Gender.M, LocalDate.parse("1990-01-01"), 90010122222L);

        mockMvc.perform(delete("/person/1")).andExpect(status().isOk());

        mockMvc.perform(get("/person/1").
                param("firstName", "Jan").
                param("lastName", "Nowak").
                param("gen`der", "M").
                param("birthDate", "1990-01-01").
                param("pesel", "90010122222").
                param("active", "false").
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk())
        ;
    }


    private void savePerson(String firstName, String lastName, Gender gender, LocalDate birthDate, Long pesel) throws Exception {
        Person person = new Person(firstName, lastName, gender, birthDate, pesel);
        mockMvc.perform(
                put("/person").
                        contentType(MediaType.APPLICATION_JSON).
                        content(objectMapper.writeValueAsString(person))
        ).andExpect(status().isOk());
    }


    class Person{

        private String firstName;
        private String lastName;
        private Gender gender;
        private LocalDate birthDate;
        private Long pesel;

        public Person(String firstName, String lastName, Gender gender, LocalDate birthDate, Long pesel) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.birthDate = birthDate;
            this.pesel = pesel;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Gender getGender() {
            return gender;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public Long getPesel() {
            return pesel;
        }
    }

}
