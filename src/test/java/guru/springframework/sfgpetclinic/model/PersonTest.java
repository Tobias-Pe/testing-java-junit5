package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupedAssertion() {
        //griven
        Person person = new Person(124234L, "Tobi", "P");
        //then
        assertAll(
            () -> assertEquals(person.getFirstName(), "Tobi"),
            () -> assertEquals(person.getLastName(), "P")
        );
    }

}