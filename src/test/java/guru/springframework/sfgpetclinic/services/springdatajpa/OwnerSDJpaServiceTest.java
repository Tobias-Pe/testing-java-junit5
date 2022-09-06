package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Disabled(value = "Until we learn Mocking")
class OwnerSDJpaServiceTest {

    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
        service = new OwnerSDJpaService(null, null, null);
    }

    @Test
    void findByLastName() {
        Owner foundOwner = service.findByLastName("World");
    }

    @Test
    void findAllByLastNameLike() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}