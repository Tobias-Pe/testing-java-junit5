package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VetControllerTest {

    VetController controller;

    VetMapService vetService;
    Model model;

    HashMap<String, Object> map;

    @BeforeEach
    void setUp() {
        vetService = new VetMapService(new SpecialityMapService());
        controller = new VetController(vetService);
        map = new HashMap<>();
        model = new Model() {
            @Override
            public void addAttribute(String key, Object o) {
                map.put(key, o);
            }

            @Override
            public void addAttribute(Object o) {
                //not necessary
            }
        };
    }

    @Test
    void listVets() {
        HashSet<Speciality> hashSet = new HashSet<>();
        hashSet.add(new Speciality(2L, "Programmer"));
        vetService.save(new Vet(1L, "Hello", "World", hashSet));
        String output = controller.listVets(model);
        assertEquals("vets/index", output);
        assertTrue(map.size() > 0);
        assertEquals(vetService.findAll(), map.get("vets"));
    }
}